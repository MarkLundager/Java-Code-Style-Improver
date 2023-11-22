package org.improver.frontend;

import org.extendj.ast.Frontend;

import org.improver.analysis.utils.Warning;
import org.improver.magpiebridge.ImproverServer;
import com.ibm.wala.classLoader.Module;
import com.ibm.wala.classLoader.SourceFileModule;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.extendj.ast.CompilationUnit;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.extendj.ast.Program;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import magpiebridge.core.ToolAnalysis;
import magpiebridge.core.ServerAnalysis;
import magpiebridge.projectservice.java.JavaProjectService;
import magpiebridge.core.IProjectService;
import magpiebridge.core.MagpieServer;
import magpiebridge.core.ServerConfiguration;
import java.util.Optional;
import java.util.Set;
import magpiebridge.core.AnalysisResult;
import org.improver.magpiebridge.analysis.CodeAnalysis;
import java.net.URL;

public class Improver extends Frontend {
  public static Object CodeProber_root_node;
  public static ArrayList<String> temp = new ArrayList();
  private Collection<String> vscodeArgs;
  private static Improver improver;
  private static MagpieServer magpiebridgeServer;
  private static ImproverServer serverAnalysis = new ImproverServer();

  public static void main(String[] args) {
    if (args[0].equals("-vscode")) {
      Improver improver = new Improver();
      improver.run(args);
      CodeProber_root_node = improver.getEntryPoint();
      createServer().launchOnStdio();
    } else {
      createServer().launchOnStdio(); //has to be in the beginning for both to work
      String cpFlag = "-classpath";
      String classpath = "/home/mark/.gradle/caches/modules-2/files-2.1/net.sf.beaver/beaver-rt/0.9.11/1c37723904832ced60ed3c3f752362e5b38b4b64/beaver-rt-0.9.11.jar";
      marksfilefindingfunction(args[0]);
      Improver improver = new Improver();
      ArrayList argsArray = new ArrayList();
      argsArray.add("-nowarn");
      argsArray.addAll(temp);
      argsArray.add(cpFlag);
      argsArray.add(classpath);

      improver.run(((String[]) argsArray.toArray(new String[argsArray.size()])));
      CodeProber_root_node = improver.getEntryPoint();

    }
  }

  public MagpieServer getServer() {
    return magpiebridgeServer;
  }

  public Program getEntryPoint() {
    return program;
  }

  private static ArrayList<String> marksfilefindingfunction(String path) {
    try {
      Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
          if (file.toString().endsWith(".java")) {
            temp.add(file.toAbsolutePath().toString());
          }
          return FileVisitResult.CONTINUE;
        }
      });
    } catch (Throwable t) {
      t.printStackTrace();
      System.err.println("Error while iterating over the rootPath");
    }
    return temp;
  }

  public static MagpieServer createServer() {
    ServerConfiguration config = new ServerConfiguration();

    config.setDoAnalysisBySave(true);
    config.setDoAnalysisByFirstOpen(true);
    config.setDoAnalysisByOpen(true);
    config.setShowConfigurationPage(true, true);
    config.setUseMagpieHTTPServer(true);
    magpiebridgeServer = new MagpieServer(config);
    String language = "java";
    IProjectService javaProjectService = new JavaProjectService();
    magpiebridgeServer.addProjectService(language, javaProjectService);
    Either<ServerAnalysis, ToolAnalysis> analysis = Either.forLeft(serverAnalysis);
    magpiebridgeServer.addAnalysis(analysis, language);
    return magpiebridgeServer;
  }

  public void setup(Collection<? extends Module> files, Set<Path> sourcePath,
      Set<Path> classPath, Set<Path> libPath,
      Optional<Path> rootPath) {
    super.program = new Program();
    vscodeArgs = new LinkedHashSet<String>();
    vscodeArgs.add("-nowarn");
    String path = computeClassPath(sourcePath, classPath, libPath, rootPath);
    System.err.println("Classpath: " + path + " isEmpty ? " + path.isEmpty());
    if (!path.isEmpty()) {
      vscodeArgs.add("-classpath");
      vscodeArgs.add(path);
    }

    for (Module file : files) {
      if (file instanceof SourceFileModule) {
        SourceFileModule sourceFileModule = (SourceFileModule) file;

        vscodeArgs.add(sourceFileModule.getURL().getPath());
      }
    }
    System.err.println("vscodeArgs: " + vscodeArgs);
  }

  public int run() {
    return improver.run(vscodeArgs.toArray(new String[vscodeArgs.size()]));
  }

  /**
   * Run the Java checker.
   * 
   * @param args command-line arguments
   * @return 0 on success, 1 on error, 2 on configuration error, 3 on system
   */
  public int run(String args[]) {
    return run(args, Program.defaultBytecodeReader(),
        Program.defaultJavaParser());
  }

  public Collection<AnalysisResult> analyze(SourceFileModule file, URL clientURL, CodeAnalysis analysis) {
    for (CompilationUnit cu : getInstance().getEntryPoint().getCompilationUnits()) {
      if (cu.getClassSource().sourceName().equals(file.getAbsolutePath())) {
        analysis.doAnalysis(cu, clientURL);
      }
    }
    return analysis.getResult();
  }

  @Override
  protected void processNoErrors(CompilationUnit cu) {
    System.out.println(cu.pathName());
    for (Warning w : cu.IFRC()) {
      System.out.println(w.toString());
    }
    for (Warning w : cu.IFRT()) {
      System.out.println(w.toString());
    }
    for (Warning w : cu.EIFB()) {
      System.out.println(w.toString());
    }
  }

  protected String computeClassPath(Set<Path> classPath, Set<Path> srcPath,
      Set<Path> libPath,
      Optional<Path> rootPath) {
    StringBuilder sb = new StringBuilder();

    for (Path path : classPath) {
      sb.append(path.toAbsolutePath().toString());
      sb.append(":");
    }
    System.err.println("classPath: " + classPath);

    for (Path path : srcPath) {
      sb.append(path.toAbsolutePath().toString());
      sb.append(":");
    }
    System.err.println("srcPath: " + srcPath);

    for (Path path : libPath) {
      sb.append(path.toAbsolutePath().toString());
      sb.append(":");
    }
    System.err.println("libPath: " + libPath);

    if (rootPath.isPresent()) {
      // Iterate recusively over the rootPath and add to sb all jar files
      try {
        Files.walkFileTree(rootPath.get(), new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            if (file.toString().endsWith(".jar")) {
              sb.append(file.toAbsolutePath().toString());
              sb.append(":");
            }
            return FileVisitResult.CONTINUE;
          }
        });
      } catch (Throwable t) {
        t.printStackTrace();
        System.err.println("Error while iterating over the rootPath");
      }
    }

    return sb.toString();
  }

  public static Improver getInstance() {
    if (improver == null) {
      improver = new Improver();
    }
    return improver;
  }

  public int numCompilationUnits(ArrayList<CompilationUnit> compilationUnits) {
    return compilationUnits.size();
  }

}