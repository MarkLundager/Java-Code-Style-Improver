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
 * @aspect Generics
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:339
 */
 interface ParTypeDecl {

     
    TypeVariable getTypeParameter(int i);

     
    Parameterization getParameterization();

     
    public String typeName();

     
    SimpleSet<Variable> localFields(String name);

     
    Map<String, SimpleSet<MethodDecl>> localMethodsSignatureMap();

     
    List<TypeVariable> getSubstTypeParamList();
public int numTypeParameter();

public TypeVariable typeParameter(int index);

public Access createQualifiedAccess();

  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:342
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Generics", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:342")
  public boolean isParameterizedType();
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:343
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Generics", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:343")
  public boolean isRawType();
  /**
   * @attribute syn
   * @aspect GenericsTypeCheck
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:633
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsTypeCheck", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:633")
  public boolean sameArguments(ParTypeDecl decl);
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:881
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:881")
  public boolean sameSignature(Access a);
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:928
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:928")
  public boolean sameSignature(java.util.List<TypeDecl> list);
  /**
   * @attribute syn
   * @aspect GenericsParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\GenericsParTypeDecl.jrag:55
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="GenericsParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\GenericsParTypeDecl.jrag:55")
  public String nameWithArgs();
  /**
   * @attribute inh
   * @aspect GenericsParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\GenericsParTypeDecl.jrag:74
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="GenericsParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\GenericsParTypeDecl.jrag:74")
  public TypeDecl genericDecl();
}
