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
import java.io.FileWriter;

public class TestImprover{

  public TestImprover(){
  }

  @Test
  public void test(){
    StringBuilder sb = new StringBuilder();
    String fileName = "testOutput.txt";
    String [] args = {"testfiles\\allTests.java"};//Windows
    // String [] args = {"testfiles/allTests.java"};//Linux


    Improver imp = new Improver();
    int exitcode = imp.run(args);
    if(exitcode!=0) {
      
    }
    imp.createServer().launchOnStdio();
    Program p = imp.getEntryPoint();
    CompilationUnit cu = p.getCompilationUnit(0);

    for(Warning w : cu.IFRC()){
      sb.append(w.toString());
    }
    for(Warning w : cu.IFRT()){
      sb.append(w.toString());
    }
    for(Warning w : cu.EIFB()){
      sb.append(w.toString());
    }

    assertEquals(sb.toString(),"IFRC - testfiles\\allTests.java:15,7 - Unnecessary IF statement when returning the value of the condition.IFRC - testfiles\\allTests.java:24,7 - Unnecessary IF statement when returning the value of the condition.IFRT - testfiles\\allTests.java:32,7 - IFRTIFRT - testfiles\\allTests.java:41,7 - IFRTIFRC - testfiles\\allTests.java:8,7 - EIFBWarning");

    try{
      File myObj = new File(fileName);
      myObj.createNewFile();
      System.out.println("File created: " + myObj.getName());
      FileWriter myWriter = new FileWriter(fileName);
      myWriter.write(sb.toString());
      myWriter.close();
    }

    catch(Exception e){

    }
  }
}