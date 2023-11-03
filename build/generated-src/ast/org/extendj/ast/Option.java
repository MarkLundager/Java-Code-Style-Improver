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
 * An option type, for representing a nullable object with a non-null
 * reference.
 * 
 * <p>The main benefit in using this type is that the Java type checker
 * disallows direct dereference, and you instead have to decide to use
 * either the get() or getOrElse() methods.
 * @ast class
 * @aspect OptionType
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java8\\frontend\\Option.jadd:41
 */
public abstract class Option<T> extends java.lang.Object {
  
    protected static final Option NONE = new Option() {
      @Override public Object get() {
        throw new NullPointerException();
      }

      @Override public Object getOrElse(Object v) {
        return v;
      }

      @Override public boolean hasValue() {
        return false;
      }
    };

  

    protected static class OptionSome<V> extends Option<V> {
      private final V value;

      public OptionSome(V value) {
        assert (value != null);
        this.value = value;
      }

      @Override public V get() {
        return value;
      }

      @Override public V getOrElse(V v) {
        return value;
      }

      @Override public boolean hasValue() {
        return true;
      }
    }

  

    protected Option() { }

  

    /**
     * Get the contained value.
     * Throws an error if there is no object.
     */
    public abstract T get();

  

    /**
     * Get the contained value.
     * If there is no value, the argument is returned.
     */
    public abstract T getOrElse(T v);

  

    /** Test if there is a value in this option object. */
    public abstract boolean hasValue();

  

    /**
     * Convert a nullable object to an option.
     */
    public static <U> Option<U> maybe(U u) {
      if (u != null) {
        return new OptionSome(u);
      } else {
        return (Option<U>) NONE;
      }
    }

  

    /**
     * Convert a nullable object to an option.
     */
    public static <U> Option<U> some(U u) {
      if (u == null) {
        throw new Error("Can't create an option containing null using Option.some(). "
            + "Use Option.none() or Option.maybe() instead.");
      }
      return new OptionSome(u);
    }

  

    /**
     * Returns the empty option object.
     */
    public static <U> Option<U> none() {
      return (Option<U>) NONE;
    }


}
