package com.google.gwt.lang;

public class Exceptions {
  static Object toJava(Object e) {
    // Although this is impossible to happen in code generated from Java (as we always unwrap
    // before throwing), there are code out there where the Java exception is instantiated and
    // thrown in native code, hence we may receive it already wrapped.
    return null;
  }  

  static Object toJs(Object t) {
    return null;
  }
}

