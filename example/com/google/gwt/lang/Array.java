package com.google.gwt.lang;

import com.google.gwt.core.client.JavaScriptObject;

public class Array {
  static boolean isJavaArray(Object src) {
    return false;
  }

  public static Object setCheck(Object array, int index, Object value) {
    return null;
  }

  public static Object initUnidimensionalArray(Class<?> leafClassLiteral,
      JavaScriptObject castableTypeMap, JavaScriptObject elementTypeId, int length,
      int elementTypeCategory, int dimensions) {
    return null;
  }

  public static Object initMultidimensionalArray(Class<?> leafClassLiteral,
      JavaScriptObject[] castableTypeMapExprs,
      JavaScriptObject[] elementTypeIds, int leafElementTypeCategory, int[] dimExprs, int count) {
    return null;
  }

  public static Object stampJavaTypeInfo(Class<?> arrayClass, JavaScriptObject castableTypeMap,
      JavaScriptObject elementTypeId, int elementTypeCategory, Object array) {
    return array;
  }
}

