package org.extendj.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.net.URL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import beaver.Symbol;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.LinkedHashSet;
import java.util.*;
import org.jastadd.util.*;
import java.util.zip.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jastadd.util.PrettyPrintable;
import org.jastadd.util.PrettyPrinter;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import org.improver.magpiebridge.utils.Pos;
import com.ibm.wala.cast.tree.CAstSourcePositionMap.Position;
import com.ibm.wala.util.collections.Pair;
import org.improver.analysis.utils.Analysis;
import org.improver.analysis.utils.Warning;
/**
 * Represents a bytecode class source (.class file).
 * @ast class
 * @aspect PathPart
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PathPart.jadd:190
 */
public abstract class BytecodeClassSource extends ClassSource {
  
    public BytecodeClassSource(PathPart sourcePath) {
      super(sourcePath);
    }

  

    @Override
    public CompilationUnit parseCompilationUnit(Program program) throws IOException {
      InputStream is = openInputStream();
      try {
        if (program.options().verbose()) {
          System.out.print("Loading " + sourceName());
        }

        long start = System.nanoTime();
        CompilationUnit u = program.bytecodeReader.read(is, sourceName(), program);
        long elapsed = System.nanoTime() - start;
        program.bytecodeParseTime += elapsed;
        program.numClassFiles += 1;

        u.setFromSource(false);
        u.setClassSource(this);

        if (program.options().verbose()) {
          System.out.println(" in " + (elapsed / 1000000) + " ms");
        }
        return u;
      } catch (AbstractClassfileParser.ClassfileFormatError e) {
        throw new AbstractClassfileParser.ClassfileFormatError(
            String.format("Error loading classfile %s: %s\n", sourceName(), e.getMessage()));
      } catch (Exception e) {
        throw new Error("Error loading classfile " + sourceName(), e);
      } finally {
        if (is != null) {
          try {
            is.close();
          } catch (IOException e) {
          }
        }
      }
    }


}
