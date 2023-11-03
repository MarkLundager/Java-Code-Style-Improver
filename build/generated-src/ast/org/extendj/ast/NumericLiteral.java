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
 * Interface for numeric literals.
 * 
 * <p>This is used to add helper attributes to numeric literals
 * (IntegerLiteral and LongLiteral) without duplicating the attribute code.
 * @ast interface
 * @aspect Java7Literals
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:311
 */
 interface NumericLiteral {

     
    String getLITERAL();
  /**
   * @attribute syn
   * @aspect Java7Literals
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:317
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Java7Literals", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:317")
  public boolean isHex();
  /**
   * @attribute syn
   * @aspect Java7Literals
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:319
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Java7Literals", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:319")
  public boolean isOctal();
  /**
   * @attribute syn
   * @aspect Java7Literals
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:321
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Java7Literals", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java7\\frontend\\Literals.jrag:321")
  public boolean isDecimal();
}
