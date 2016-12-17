package com.google.gwt.lang;

import com.google.gwt.core.client.JavaScriptObject;

public final class Cast
{
  private static JavaScriptObject stringCastMap;
  private static JavaScriptObject doubleCastMap;
  private static JavaScriptObject booleanCastMap;
  public static native String charToString(char x) /*-{ }-*/;
  public static Object castTo(Object src, int dstId) { return src;}
  public static Object castToAllowJso(Object src, int dstId) { return src;}
  public static Object castToArray(Object src) { return src;}
  public static Object castToJsoArray(Object src) { return src;}
  public static Object castToJsArray(Object src) { return src;}
  public static Object castToJso(Object src) { return src;}
  public static Object castToString(Object src) { return src;}
  public static Object castToDouble(Object src) { return src;}
  public static Object castToBoolean(Object src) { return src;}
  public static Object castToNative(Object src, JavaScriptObject type) { return src;}
  public static Object castToUnknownNative(Object src) { return src;}
  public static Object castToFunction(Object src) { return src; }
  public static Object castToJsObject(Object src) { return src; }
  public static Class<?> getClass(Object src) { return null; }
  public static boolean hasJavaObjectVirtualDispatch(Object o) { return true; }
  public static boolean instanceOf(Object src, int dstId) { return false;}
  public static boolean instanceOfString(Object o) { return true; }
  public static boolean instanceOfDouble(Object o) { return true; }
  public static boolean instanceOfBoolean(Object o) { return true; }
  public static boolean instanceOfArray(Object src) { return false;}
  public static boolean instanceOfJsoArray(Object src) { return false;}
  public static boolean instanceOfJsArray(Object src) { return false;}
  public static boolean instanceOfAllowJso(Object src, int dst) { return false;}
  public static boolean instanceOfJso(Object src) { return false;}
  public static boolean instanceOfUnknownNative(Object src)  { return false;}
  public static boolean instanceOfNative(Object src, JavaScriptObject type) {
    return false;
  }
  public static boolean instanceOfFunction(Object src) { return false; }
  public static boolean instanceOfJsObject(Object src) { return false; }
  public static boolean isArray(Object o) { return false; }
  public static boolean isJavaScriptObject(Object o) { return true; }
  public static native boolean isNull(Object a) /*-{ }-*/;
  public static native boolean isNotNull(Object a) /*-{ }-*/;
  public static native boolean jsEquals(Object a, Object b) /*-{ }-*/;
  public static native boolean jsNotEquals(Object a, Object b) /*-{ }-*/;
  public static int narrow_int(double x) { return 0; }
  public static byte narrow_long(double x) { return 0; }
}
