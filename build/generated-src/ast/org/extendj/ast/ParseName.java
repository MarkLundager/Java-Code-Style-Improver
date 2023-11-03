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
 * An unclassified parse name.
 * 
 * <p>Parse names are classified automatically using the JastAdd rewrite
 * mechanism.
 * @ast node
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\grammar\\Java.ast:135
 * @astdecl ParseName : Access;
 * @production ParseName : {@link Access};

 */
public class ParseName extends Access implements Cloneable {
  /**
   * @aspect DumpTree
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\DumpTree.jadd:117
   */
  @Override
  public String getTokens() {
    return " " + name();
  }
  /**
   * @aspect Java4PrettyPrint
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PrettyPrint.jadd:536
   */
  public void prettyPrint(PrettyPrinter out) {
    out.print(name());
  }
  /**
   * @aspect PrettyPrintUtil
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\PrettyPrintUtil.jrag:117
   */
  @Override public String toString() {
    return name();
  }
  /**
   * @aspect QualifiedNames
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:218
   */
  public Access qualifiesAccess(Access access) {
    if (access instanceof ParseName) {
      ParseName name = (ParseName) access;
      ArrayList<NamePart> parts = new ArrayList<NamePart>(nameParts);
      parts.addAll(name.nameParts);
      return new ParseName(parts);
    } else {
      Access result = new Dot(this, access);
      result.setStart(getStart());
      result.setEnd(access.getEnd());
      return result;
    }
  }
  /**
   * @aspect QualifiedNames
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:439
   */
  private ArrayList<NamePart> nameParts = new ArrayList<NamePart>();
  /**
   * @aspect QualifiedNames
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:441
   */
  public ParseName(ArrayList<NamePart> nameParts) {
    this.nameParts.addAll(nameParts);
  }
  /**
   * @aspect QualifiedNames
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:445
   */
  public ParseName(Symbol name) {
    nameParts.add(new NamePart(name));
  }
  /**
   * @aspect QualifiedNames
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:457
   */
  public Access buildMethodAccess(List<Expr> arguments) {
    if (nameParts.isEmpty()) {
      throw new Error("Cannot build method access using empty parse name!");
    }
    int num = nameParts.size();
    NamePart methodName = nameParts.get(nameParts.size() - 1);
    ArrayList<NamePart> head = new ArrayList<NamePart>();
    for (int i = 0; i < nameParts.size() - 1; ++i) {
      head.add(nameParts.get(i));
    }
    MethodAccess call = new MethodAccess(methodName.toString(), arguments);
    if (head.isEmpty()) {
      return call;
    } else {
      return new Dot(new ParseName(head), call);
    }
  }
  /**
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:509
   */
  protected NamePart resolvePackageOrTypeName(NamePart qualifier, NamePart name) {
    if (qualifier.isPackageQualifier()) {
      if (!qualifier.hasType(this, name)) {
        return new NamePart.Package(qualifier, name);
      }
    }
    return new NamePart.Type(qualifier, name);
  }
  /**
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:518
   */
  protected NamePart resolveAmbiguousName(NamePart qualifier, NamePart name) {
    if (qualifier == NamePart.EMPTY) {
      SimpleSet<Variable> var = lookupVariable(name.toString());
      if (!var.isEmpty()) {
        return new NamePart.VarName(qualifier, name);
      }
    } else {
      TypeDecl hostType = qualifier.lookupType(this);
      if (hostType != null) {
        SimpleSet<Variable> var = hostType().keepAccessibleFields(hostType,
            hostType.memberFields(name.toString()));
        if (!var.isEmpty()) {
          return new NamePart.VarName(qualifier, name);
        }
      }
    }
    return resolvePackageOrTypeName(qualifier, name);
  }
  /**
   * @declaredat ASTNode:1
   */
  public ParseName() {
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
    return true;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    rewrittenNode_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public ParseName clone() throws CloneNotSupportedException {
    ParseName node = (ParseName) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public ParseName copy() {
    try {
      ParseName node = (ParseName) clone();
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
   * @declaredat ASTNode:56
   */
  @Deprecated
  public ParseName fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:66
   */
  public ParseName treeCopyNoTransform() {
    ParseName tree = (ParseName) copy();
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
   * @declaredat ASTNode:86
   */
  public ParseName treeCopy() {
    ParseName tree = (ParseName) copy();
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
   * @declaredat ASTNode:100
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:624
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeScopePropagation", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupType.jrag:628")
  public SimpleSet<TypeDecl> qualifiedLookupType(String name) {
    SimpleSet<TypeDecl> qualifiedLookupType_String_value = emptySet();
    return qualifiedLookupType_String_value;
  }
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupVariable.jrag:259
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="VariableScope", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\LookupVariable.jrag:264")
  public SimpleSet<Variable> qualifiedLookupVariable(String name) {
    SimpleSet<Variable> qualifiedLookupVariable_String_value = emptySet();
    return qualifiedLookupVariable_String_value;
  }
  /**
   * @attribute syn
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:496
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameResolution", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:494")
  public boolean isParseName() {
    boolean isParseName_value = true;
    return isParseName_value;
  }
  /**
   * @attribute syn
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:498
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameResolution", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:498")
  public String name() {
    {
        StringBuilder sb = new StringBuilder();
        for (NamePart part : nameParts) {
          if (sb.length() != 0) {
            sb.append(".");
          }
          sb.append(part.toString());
        }
        return sb.toString();
      }
  }
  /**
   * @attribute syn
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:563
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameResolution", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:556")
  public boolean containsParseName() {
    boolean containsParseName_value = true;
    return containsParseName_value;
  }
  /**
   * A parse name can only be disambiguated if it is not qualified by an
   * expression containing another unresolved parse name.
   * @attribute inh
   * @aspect NameResolution
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:541
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameResolution", declaredAt="C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:541")
  public boolean canResolve() {
    boolean canResolve_value = getParent().Define_canResolve(this, null);
    return canResolve_value;
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    // Declared at C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:569
    if (canResolve()) {
      return rewriteRule0();
    }
    return super.rewriteTo();
  }
  /**
   * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:569
   * @apilevel internal
   */
  private Access rewriteRule0() {
{
      NamePart name = NamePart.EMPTY;
      switch (nameType()) {
        case PACKAGE_NAME:
          for (NamePart next : nameParts) {
            name = new NamePart.Package(name, next);
          }
          break;
        case TYPE_NAME:
          // The first part of the name is the package part.
          for (int i = 0; i < nameParts.size() - 1; ++i) {
            name = resolvePackageOrTypeName(name, nameParts.get(i));
          }
          // The rest of the name is the type name.
          name = new NamePart.Type(name, nameParts.get(nameParts.size() - 1));
          break;
        case PACKAGE_OR_TYPE_NAME:
          for (NamePart next : nameParts) {
            name = resolvePackageOrTypeName(name, next);
          }
          break;
        case AMBIGUOUS_NAME:
          for (NamePart next : nameParts) {
            name = resolveAmbiguousName(name, next);
          }
          break;
        case EXPRESSION_NAME:
          // The first part of the name is the package part.
          for (int i = 0; i < nameParts.size() - 1; ++i) {
            name = resolveAmbiguousName(name, nameParts.get(i));
          }
          name = new NamePart.VarName(name, nameParts.get(nameParts.size() - 1));
          break;
        case NOT_CLASSIFIED:
        default:
          throw new Error("Failure in name classification: unknown name type encountered");
      }
      Access result = null;
      while (name != NamePart.EMPTY) {
        if (result == null) {
          result = name.buildAccess();
        } else {
          result = new Dot(name.buildAccess(), result);
        }
        name = name.pred;
      }
      return result;
    }  }
  /** @apilevel internal */
  public boolean canRewrite() {
    // Declared at C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\ResolveAmbiguousNames.jrag:569
    if (canResolve()) {
      return true;
    }
    return false;
  }
  /** @apilevel internal */
  private void rewrittenNode_reset() {
    rewrittenNode_computed = false;
    rewrittenNode_initialized = false;
    rewrittenNode_value = null;
    rewrittenNode_cycle = null;
  }
/** @apilevel internal */
protected ASTState.Cycle rewrittenNode_cycle = null;
  /** @apilevel internal */
  protected boolean rewrittenNode_computed = false;

  /** @apilevel internal */
  protected ASTNode rewrittenNode_value;
  /** @apilevel internal */
  protected boolean rewrittenNode_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="", declaredAt=":0")
  public ASTNode rewrittenNode() {
    if (rewrittenNode_computed) {
      return rewrittenNode_value;
    }
    ASTState state = state();
    if (!rewrittenNode_initialized) {
      rewrittenNode_initialized = true;
      rewrittenNode_value = this;
      if (rewrittenNode_value != null) {
        rewrittenNode_value.setParent(getParent());
      }
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        rewrittenNode_cycle = state.nextCycle();
        ASTNode new_rewrittenNode_value = rewrittenNode_value.rewriteTo();
        if (new_rewrittenNode_value != rewrittenNode_value || new_rewrittenNode_value.canRewrite()) {
          state.setChangeInCycle();
        }
        rewrittenNode_value = new_rewrittenNode_value;
        if (rewrittenNode_value != null) {
          rewrittenNode_value.setParent(getParent());
        }
      } while (state.testAndClearChangeInCycle());
      rewrittenNode_computed = true;
      state.startLastCycle();
      ASTNode $tmp = rewrittenNode_value.rewriteTo();

      state.leaveCircle();
    } else if (rewrittenNode_cycle != state.cycle()) {
      rewrittenNode_cycle = state.cycle();
      if (state.lastCycle()) {
        rewrittenNode_computed = true;
        ASTNode new_rewrittenNode_value = rewrittenNode_value.rewriteTo();
        return new_rewrittenNode_value;
      }
      ASTNode new_rewrittenNode_value = rewrittenNode_value.rewriteTo();
      if (new_rewrittenNode_value != rewrittenNode_value || new_rewrittenNode_value.canRewrite()) {
        state.setChangeInCycle();
      }
      rewrittenNode_value = new_rewrittenNode_value;
      if (rewrittenNode_value != null) {
        rewrittenNode_value.setParent(getParent());
      }
    } else {
    }
    return rewrittenNode_value;
  }
}
