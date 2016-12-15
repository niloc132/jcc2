package com.google.gwt.lang;

import com.google.gwt.core.client.JavaScriptObject;

public class Runtime {
  public static native String toString(Object object) /*-{
    return object.toString();
  }-*/;

  public static native void bootstrap() /*-{
    // Do polyfills for all methods expected in a modern browser.
    // Patch up Array.isArray for browsers that don't support the fast native check.
  }-*/;

  public static void defineClass(JavaScriptObject typeId,
      JavaScriptObject superTypeIdOrPrototype, JavaScriptObject castableTypeMap)
  {

  }

  public static JavaScriptObject getClassPrototype(JavaScriptObject typeId)
  {
    return null;
  }
}

