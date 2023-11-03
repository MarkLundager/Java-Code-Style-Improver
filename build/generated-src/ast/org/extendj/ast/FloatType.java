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
 * @ast node
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\grammar\\Java.ast:176
 * @astdecl FloatType : FloatingPointType ::= Modifiers <ID:String> BodyDecl*;
 * @production FloatType : {@link FloatingPointType};

 */
public class FloatType extends FloatingPointType implements Cloneable {
  /**
   * @aspect Java4PrettyPrint
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PrettyPrint.jadd:380
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print("float");
  }
  /**
   * @declaredat ASTNode:1
   */
  public FloatType() {
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
    children = new ASTNode[2];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Modifiers", "ID", "BodyDecl"},
    type = {"Modifiers", "String", "List<BodyDecl>"},
    kind = {"Child", "Token", "List"}
  )
  public FloatType(Modifiers p0, String p1, List<BodyDecl> p2) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:24
   */
  public FloatType(Modifiers p0, beaver.Symbol p1, List<BodyDecl> p2) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:36
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    boxed_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:49
   */
  public FloatType clone() throws CloneNotSupportedException {
    FloatType node = (FloatType) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:54
   */
  public FloatType copy() {
    try {
      FloatType node = (FloatType) clone();
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
   * @declaredat ASTNode:73
   */
  @Deprecated
  public FloatType fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:83
   */
  public FloatType treeCopyNoTransform() {
    FloatType tree = (FloatType) copy();
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
   * @declaredat ASTNode:103
   */
  public FloatType treeCopy() {
    FloatType tree = (FloatType) copy();
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
   * @declaredat ASTNode:117
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) && (tokenString_ID == ((FloatType) node).tokenString_ID);    
  }
  /**
   * Replaces the Modifiers child.
   * @param node The new node to replace the Modifiers child.
   * @apilevel high-level
   */
  public void setModifiers(Modifiers node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Modifiers child.
   * @return The current node used as the Modifiers child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Modifiers")
  public Modifiers getModifiers() {
    return (Modifiers) getChild(0);
  }
  /**
   * Retrieves the Modifiers child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Modifiers child.
   * @apilevel low-level
   */
  public Modifiers getModifiersNoTransform() {
    return (Modifiers) getChildNoTransform(0);
  }
  /**
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the BodyDecl list.
   * @param list The new list node to be used as the BodyDecl list.
   * @apilevel high-level
   */
  public void setBodyDeclList(List<BodyDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * @return Number of children in the BodyDecl list.
   * @apilevel high-level
   */
  public int getNumBodyDecl() {
    return getBodyDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the BodyDecl list.
   * @apilevel low-level
   */
  public int getNumBodyDeclNoTransform() {
    return getBodyDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the BodyDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the BodyDecl list.
   * @apilevel high-level
   */
  public BodyDecl getBodyDecl(int i) {
    return (BodyDecl) getBodyDeclList().getChild(i);
  }
  /**
   * Check whether the BodyDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBodyDecl() {
    return getBodyDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the BodyDecl list.
   * @param node The element to append to the BodyDecl list.
   * @apilevel high-level
   */
  public void addBodyDecl(BodyDecl node) {
    List<BodyDecl> list = (parent == null) ? getBodyDeclListNoTransform() : getBodyDeclList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addBodyDeclNoTransform(BodyDecl node) {
    List<BodyDecl> list = getBodyDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the BodyDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBodyDecl(BodyDecl node, int i) {
    List<BodyDecl> list = getBodyDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="BodyDecl")
  public List<BodyDecl> getBodyDeclList() {
    List<BodyDecl> list = (List<BodyDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclListNoTransform() {
    return (List<BodyDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the BodyDecl list without
   * triggering rewrites.
   */
  public BodyDecl getBodyDeclNoTransform(int i) {
    return (BodyDecl) getBodyDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  public List<BodyDecl> getBodyDecls() {
    return getBodyDeclList();
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclsNoTransform() {
    return getBodyDeclListNoTransform();
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:110
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:95")
  public Constant cast(Constant c) {
    Constant cast_Constant_value = Constant.create(c.floatValue());
    return cast_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:127
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:118")
  public Constant plus(Constant c) {
    Constant plus_Constant_value = c;
    return plus_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:140
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:131")
  public Constant minus(Constant c) {
    Constant minus_Constant_value = Constant.create(-c.floatValue());
    return minus_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:162
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:153")
  public Constant mul(Constant c1, Constant c2) {
    Constant mul_Constant_Constant_value = Constant.create(c1.floatValue() * c2.floatValue());
    return mul_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:176
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:167")
  public Constant div(Constant c1, Constant c2) {
    Constant div_Constant_Constant_value = Constant.create(c1.floatValue() / c2.floatValue());
    return div_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:190
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:181")
  public Constant mod(Constant c1, Constant c2) {
    Constant mod_Constant_Constant_value = Constant.create(c1.floatValue() % c2.floatValue());
    return mod_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:204
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:195")
  public Constant add(Constant c1, Constant c2) {
    Constant add_Constant_Constant_value = Constant.create(c1.floatValue() + c2.floatValue());
    return add_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:221
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:212")
  public Constant sub(Constant c1, Constant c2) {
    Constant sub_Constant_Constant_value = Constant.create(c1.floatValue() - c2.floatValue());
    return sub_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:310
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:299")
  public Constant questionColon(Constant cond, Constant c1, Constant c2) {
    Constant questionColon_Constant_Constant_Constant_value = Constant.create(cond.booleanValue() ? c1.floatValue() : c2.floatValue());
    return questionColon_Constant_Constant_Constant_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:510
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:499")
  public boolean eqIsTrue(Expr left, Expr right) {
    boolean eqIsTrue_Expr_Expr_value = left.constant().floatValue() == right.constant().floatValue();
    return eqIsTrue_Expr_Expr_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:530
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:522")
  public boolean ltIsTrue(Expr left, Expr right) {
    boolean ltIsTrue_Expr_Expr_value = left.constant().floatValue() < right.constant().floatValue();
    return ltIsTrue_Expr_Expr_value;
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:544
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ConstantExpression.jrag:536")
  public boolean leIsTrue(Expr left, Expr right) {
    boolean leIsTrue_Expr_Expr_value = left.constant().floatValue() <= right.constant().floatValue();
    return leIsTrue_Expr_Expr_value;
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:210
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:209")
  public boolean isFloat() {
    boolean isFloat_value = true;
    return isFloat_value;
  }
  /**
   * @attribute syn
   * @aspect Subtyping
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:532
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Subtyping", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:527")
  public boolean supertypePrimitiveType(PrimitiveType type) {
    boolean supertypePrimitiveType_PrimitiveType_value = type.convertibleToFloat();
    return supertypePrimitiveType_PrimitiveType_value;
  }
  /**
   * @attribute syn
   * @aspect Subtyping
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:559
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Subtyping", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:553")
  public boolean convertibleToFloat() {
    boolean convertibleToFloat_value = true;
    return convertibleToFloat_value;
  }
  /**
   * @attribute syn
   * @aspect Subtyping
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:567
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Subtyping", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\TypeAnalysis.jrag:561")
  public boolean convertibleToDouble() {
    boolean convertibleToDouble_value = true;
    return convertibleToDouble_value;
  }
  /** @apilevel internal */
  private void boxed_reset() {
    boxed_computed = null;
    boxed_value = null;
  }
  /** @apilevel internal */
  protected ASTState.Cycle boxed_computed = null;

  /** @apilevel internal */
  protected TypeDecl boxed_value;

  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\AutoBoxing.jrag:67
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="AutoBoxing", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java5\\frontend\\AutoBoxing.jrag:53")
  public TypeDecl boxed() {
    ASTState state = state();
    if (boxed_computed == ASTState.NON_CYCLE || boxed_computed == state().cycle()) {
      return boxed_value;
    }
    boxed_value = lookupType("java.lang", "Float");
    if (state().inCircle()) {
      boxed_computed = state().cycle();
    
    } else {
      boxed_computed = ASTState.NON_CYCLE;
    
    }
    return boxed_value;
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
}
