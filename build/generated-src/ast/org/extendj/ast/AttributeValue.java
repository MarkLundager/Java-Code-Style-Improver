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
/** Wrapper class for storing nullable attribute values. 
 * @ast class
 * @declaredat ASTState:2
 */
public class AttributeValue<T> extends java.lang.Object {
  
  /**
   * This singleton object is an illegal, unused, attribute value.
   * It represents that an attribute has not been memoized, or that
   * a circular attribute approximation has not been initialized.
   */
  public static final Object NONE = new Object();

  

  public final T value;

  

  public AttributeValue(T value) {
    this.value = value;
  }

  

  public static <V> boolean equals(AttributeValue<V> v1, AttributeValue<V> v2) {
    if (v1 == null || v2 == null) {
      return v1 == v2;
    } else {
      return equals(v1.value, v2.value);
    }
  }

  

  public static <V> boolean equals(V v1, V v2) {
    if (v1 == null || v2 == null) {
      return v1 == v2;
    } else {
      return v1 == v2 || v1.equals(v2);
    }
  }


}
