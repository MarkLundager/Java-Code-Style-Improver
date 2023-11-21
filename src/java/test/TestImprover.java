package org.improver.frontend;

import org.extendj.ast.Frontend;

import org.jastadd.util.*;
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
import org.improver.analysis.utils.Warning;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class TestImprover{

  public TestImprover(){
  }

  @Test
  void test(){  
    Improver improver = new Improver();
    CompilationUnit cus;
    LinkedHashSet<String> vscodeArgs = new LinkedHashSet<String>();
    vscodeArgs.add("-nowarn");
    vscodeArgs.add("/mnt/c/Users/Mark_/Documents/EDAN70/testfiles/allTests.java");
    improver.run(vscodeArgs.toArray(new String[vscodeArgs.size()]));
    cus = ((CompilationUnit)improver.getEntryPoint().getChild(0));
    for(Warning w : cus.EIFB()){
      w.toString();
      assertEquals(w.toString(), "apa");
    }
  }
}