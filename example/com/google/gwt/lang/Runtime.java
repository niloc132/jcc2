package com.google.gwt.lang;

public class Runtime {
  public static native String toString(Object object) /*-{
    return object.toString();
  }-*/;
}

