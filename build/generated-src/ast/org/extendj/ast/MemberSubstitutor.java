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
 * @ast interface
 * @aspect LookupParTypeDecl
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1249
 */
 interface MemberSubstitutor {

     
    TypeDecl original();
  /**
   * Substituted local methods.
   * 
   * <p>Includes all non-substitutable original methods plus all substituted methods.
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1369
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1369")
  public java.util.List<MethodDecl> localMethods();
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1384
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1384")
  public SimpleSet<Variable> localFields(String name);
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1415
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1415")
  public SimpleSet<TypeDecl> localTypeDecls(String name);
}
