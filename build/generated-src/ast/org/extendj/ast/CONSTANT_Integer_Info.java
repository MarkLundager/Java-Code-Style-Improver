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
 * @ast class
 * @aspect BytecodeCONSTANT
 * @declaredat C:\\Users\\Mark_\\Documents\\EDAN70\\extendj\\java4\\frontend\\BytecodeCONSTANT.jrag:173
 */
 class CONSTANT_Integer_Info extends CONSTANT_Info {
  
    public int value;

  

    public CONSTANT_Integer_Info(AbstractClassfileParser parser) throws IOException {
      super(parser);
      value = p.readInt();
    }

  

    @Override
    public String toString() {
      return "IntegerInfo: " + Integer.toString(value);
    }

  

    @Override
    public Expr expr() {
      return Literal.buildIntegerLiteral(value);
    }

  

    @Override
    public Expr exprAsBoolean() {
      return Literal.buildBooleanLiteral(value == 0);
    }


}
