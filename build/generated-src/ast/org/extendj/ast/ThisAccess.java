/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.2 */
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
 * Represent explicit and implicit {@code this} references.
 * @ast node
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\grammar\\Java.ast:106
 * @astdecl ThisAccess : Access;
 * @production ThisAccess : {@link Access};

 */
public class ThisAccess extends Access implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PrettyPrint.jadd:582
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print("this");
  }
  /**
   * @aspect PrettyPrintUtil
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PrettyPrintUtil.jrag:163
   */
  @Override public String toString() {
    return "this";
  }
  /**
   * @declaredat ASTNode:1
   */
  public ThisAccess() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:19
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    decl_reset();
    type_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public ThisAccess clone() throws CloneNotSupportedException {
    ThisAccess node = (ThisAccess) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public ThisAccess copy() {
    try {
      ThisAccess node = (ThisAccess) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:57
   */
  @Deprecated
  public ThisAccess fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:67
   */
  public ThisAccess treeCopyNoTransform() {
    ThisAccess tree = (ThisAccess) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:87
   */
  public ThisAccess treeCopy() {
    ThisAccess tree = (ThisAccess) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:101
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * @aspect TypeScopePropagation
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:394
   */
  private TypeDecl refined_TypeScopePropagation_ThisAccess_decl()
{ return isQualified() ? qualifier().type() : hostType(); }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:387
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:387")
  public SimpleSet<TypeDecl> decls() {
    SimpleSet<TypeDecl> decls_value = emptySet();
    return decls_value;
  }
  /** @apilevel internal */
  private void decl_reset() {
    decl_computed = null;
    decl_value = null;
  }
  /** @apilevel internal */
  protected ASTState.Cycle decl_computed = null;

  /** @apilevel internal */
  protected TypeDecl decl_value;

  /**
   * @return the type which this access references.
   * @attribute syn
   * @aspect LookupType
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java8\\frontend\\LookupType.jrag:39
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:394")
  public TypeDecl decl() {
    ASTState state = state();
    if (decl_computed == ASTState.NON_CYCLE || decl_computed == state().cycle()) {
      return decl_value;
    }
    decl_value = decl_compute();
    if (state().inCircle()) {
      decl_computed = state().cycle();
    
    } else {
      decl_computed = ASTState.NON_CYCLE;
    
    }
    return decl_value;
  }
  /** @apilevel internal */
  private TypeDecl decl_compute() {
      TypeDecl typeDecl;
      if (isQualified()) {
        typeDecl = qualifier().type();
      } else {
        typeDecl = hostType();
        while (typeDecl instanceof LambdaAnonymousDecl) {
          typeDecl = typeDecl.enclosingType();
        }
      }
  
      if (typeDecl instanceof ParTypeDecl) {
        typeDecl = ((ParTypeDecl) typeDecl).genericDecl();
      }
      return typeDecl;
    }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:64
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="AccessTypes", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:62")
  public boolean isThisAccess() {
    boolean isThisAccess_value = true;
    return isThisAccess_value;
  }
  /**
   * @attribute syn
   * @aspect SyntacticClassification
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\SyntacticClassification.jrag:115
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="SyntacticClassification", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\SyntacticClassification.jrag:60")
  public NameType predNameType() {
    NameType predNameType_value = NameType.TYPE_NAME;
    return predNameType_value;
  }
  /** @apilevel internal */
  private void type_reset() {
    type_computed = null;
    type_value = null;
  }
  /** @apilevel internal */
  protected ASTState.Cycle type_computed = null;

  /** @apilevel internal */
  protected TypeDecl type_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:310
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:296")
  public TypeDecl type() {
    ASTState state = state();
    if (type_computed == ASTState.NON_CYCLE || type_computed == state().cycle()) {
      return type_value;
    }
    type_value = decl();
    if (state().inCircle()) {
      type_computed = state().cycle();
    
    } else {
      type_computed = ASTState.NON_CYCLE;
    
    }
    return type_value;
  }
  /**
   * @attribute syn
   * @aspect TypeHierarchyCheck
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:176
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeHierarchyCheck", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:176")
  public Collection<Problem> typeHierarchyProblems() {
    {
        Collection<Problem> problems = new LinkedList<Problem>();
        // 8.8.5.1
        // JLSv7 8.8.7.1
        TypeDecl constructorHostType = enclosingExplicitConstructorHostType();
        if (constructorHostType != null && (constructorHostType == decl())) {
          problems.add(error("this may not be accessed in an explicit constructor invocation"));
        } else if (isQualified()) {
          // 15.8.4
          if (inStaticContext()) {
            problems.add(error("qualified this may not occur in static context"));
          } else if (!hostType().isInnerTypeOf(decl()) && hostType() != decl()) {
            problems.add(errorf("qualified this access must name an enclosing type which %s is not",
                decl().typeName()));
          }
        } else if (!isQualified() && inStaticContext()) {
          // 8.4.3.2
          problems.add(error("this access may not be used in a static context"));
        }
        return problems;
      }
  }
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:202
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeHierarchyCheck", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:202")
  public boolean inExplicitConstructorInvocation() {
    boolean inExplicitConstructorInvocation_value = getParent().Define_inExplicitConstructorInvocation(this, null);
    return inExplicitConstructorInvocation_value;
  }
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:213
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeHierarchyCheck", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:213")
  public TypeDecl enclosingExplicitConstructorHostType() {
    TypeDecl enclosingExplicitConstructorHostType_value = getParent().Define_enclosingExplicitConstructorHostType(this, null);
    return enclosingExplicitConstructorHostType_value;
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
  /** @apilevel internal */
  protected void collect_contributors_CompilationUnit_problems(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeHierarchyCheck.jrag:174
    {
      java.util.Set<ASTNode> contributors = _map.get(_root);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) _root, contributors);
      }
      contributors.add(this);
    }
    super.collect_contributors_CompilationUnit_problems(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    for (Problem value : typeHierarchyProblems()) {
      collection.add(value);
    }
  }
}
