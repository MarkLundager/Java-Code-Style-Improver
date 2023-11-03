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
 * @aspect Variable
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java8\\frontend\\Variable.jadd:31
 */
public interface Variable {

     
    public String name();

     
    public TypeDecl type();

     
    public Collection<TypeDecl> throwTypes();

     
    public boolean isParameter();


    // 4.5.3
     

    // 4.5.3
    public boolean isClassVariable();

     
    public boolean isInstanceVariable();

     
    public boolean isMethodParameter();

     
    public boolean isConstructorParameter();

     
    public boolean isExceptionHandlerParameter();

     
    public boolean isLocalVariable();

     
    public boolean isField();


     

    public boolean isPublic();


    // 4.5.4
     

    // 4.5.4
    public boolean isFinal();

     
    public boolean isVolatile();


    // 4.12.4
     

    // 4.12.4
    public boolean isEffectivelyFinal();


     

    public boolean isBlank();

     
    public boolean isStatic();

     
    public boolean isSynthetic();


     

    public boolean accessibleFrom(TypeDecl type);

     
    public TypeDecl hostType();


     

    public Expr getInit();

     
    public boolean hasInit();


     

    public boolean isConstant();

     
    public Constant constant();


     

    public Modifiers getModifiers();
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\Modifiers.jrag:278
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\Modifiers.jrag:278")
  public boolean isProtected();
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\Modifiers.jrag:280
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\Modifiers.jrag:280")
  public boolean isPrivate();
  /**
   * @attribute syn
   * @aspect STREQ
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\src\\jastadd\\StringEqCheck.jrag:68
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="STREQ", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\src\\jastadd\\StringEqCheck.jrag:68")
  public Position getPosition();
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:686
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NestedTypes", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:686")
  public String hostPackage();
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1405
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="LookupParTypeDecl", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\Generics.jrag:1405")
  public FieldDecl fieldDecl();
}
