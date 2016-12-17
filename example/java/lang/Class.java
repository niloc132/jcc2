package java.lang;

import com.google.gwt.core.client.JavaScriptObject;

public final class Class<T> {
  
  static <T> Class<T> createForArray(String packageName, String className, String typeId, Class<?> componentType)
  {
    return new Class<T>();
  }
  
  static <T> Class<T> createForClass(String packageName, String className, String typeId, Class<? super T> superclass)
  {
    return new Class<T>();
  }

  static <T> Class<T> createForEnum(String packageName, String className, String typeId, Class<? super T> superclass, JavaScriptObject enumConstantsFunc, JavaScriptObject enumValueOfFunc)
  {
    return new Class<T>();
  }
  
  static <T> Class<T> createForInterface(String packageName, String className)
  {
    return new Class<T>();
  }

  static <T> Class<T> createForPrimitive(String className, String jni)
  {
    return new Class<T>();
  }
  
  static boolean isClassMetadataEnabled()
  {
    return true;
  }

  public boolean desiredAssertionStatus()
  {
    return true;
  }
  
  public String getName()
  {
    return null;
  }
}