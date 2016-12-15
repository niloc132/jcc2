package com.google.gwt.lang;

import com.google.gwt.core.client.JavaScriptObject;

public class Cast {

  static Class<?> getClass(Object array) {
    return null;
  }

  /**
   * Returns true if Object can dispatch instance methods and does not need a compiler
   * provided trampoline.
   *
   * Java non primitive objects fall into 3 classes: Strings, arrays (of primitive or non primitive
   * types) and regular Java Objects (all others).
   *
   * Only regular Java object have dynamic instance dispatch, strings and arrays need compiler
   * generated trampolines to implement instance dispatch.
   */
  static boolean hasJavaObjectVirtualDispatch(Object src) {
    return false;
  }

  static native boolean instanceOfBoolean(Object src) /*-{
    return typeof(src) === "boolean";
  }-*/;

  static native boolean instanceOfDouble(Object src) /*-{
    return typeof(src) === "number";
  }-*/;

  static native boolean instanceOfString(Object src) /*-{
    return typeof(src) === "string";
  }-*/;

  static boolean instanceOf(Object src, JavaScriptObject dstId) {
    return false;
  }

  static Object castTo(Object src, JavaScriptObject dstId) {
    return src;
  }

  /**
   * Returns true if the object is a Java object and can be cast, or if it's a
   * non-null JSO.
   */
  static boolean instanceOfAllowJso(Object src, JavaScriptObject dstId) {
    return false;
  }

  /**
   * Allow a dynamic cast to an object, always succeeding if it's a JSO.
   */
  static Object castToAllowJso(Object src, JavaScriptObject dstId) {
    return src;
  }

  static boolean instanceOfJso(Object src) {
    return false;
  }

  /**
   * Allow a cast to JSO only if there's no type ID.
   */
  static Object castToJso(Object src) {
    return src;
  }

  /**
   * Returns true if {@code src} is Java object array or an untyped array.
   */
  static boolean instanceOfArray(Object src) {
    return false;
  }

  /**
   * Allow a cast to an java.lang.Object array, accepting also untyped arrays.
   */
  static Object castToArray(Object src) {
    return src;
  }

  /**
   * Returns true if {@code src} is Java object array or an untyped array.
   */
  static boolean instanceOfJsoArray(Object src, JavaScriptObject dstId) {
    return false;
  }

  /**
   * Allow a cast to an array of Jsos, accepting also untyped arrays.
   */
  static Object castToJsoArray(Object src, JavaScriptObject dstId) {
    return src;
  }

  static Object castToString(Object src) {
    return src;
  }

  static Object castToDouble(Object src) {
    return src;
  }

  static Object castToBoolean(Object src) {
    return src;
  }

  static boolean instanceOfNative(Object src, JavaScriptObject jsType)
  {
    return false;
  }

  /**
   * A dynamic cast that optionally checks for JsType prototypes.
   */
  static Object castToNative(Object src, JavaScriptObject jsType) {
    return src;
  }

  static boolean instanceOfUnknownNative(Object src) {
    return false;
  }

  static Object castToUnknownNative(Object src) {
    return src;
  }

  /**
   * Returns true if the object is a function.
   */
  static boolean instanceOfFunction(Object src) {
    return false;
  }

  /**
   * Returns true if the object is a JS object.
   */
  static boolean instanceOfJsObject(Object src) {
    return false;
  }

  /**
   * Allow a dynamic cast to a JsFunction interface only if it is a function.
   */
  static Object castToFunction(Object src) {
    return src;
  }

  /**
   * Allow a dynamic cast to a native GLOBAL.Object if it is JavaScript object.
   */
  static Object castToJsObject(Object src) {
    return src;
  }

  static boolean instanceOfJsArray(Object src) {
    return false;
  }

  /**
   * Allow a cast to (untyped) array. This case covers single and multidimensional JsType arrays.
   */
  static Object castToJsArray(Object src) {
    return src;
  }
}


