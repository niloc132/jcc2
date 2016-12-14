/*
 * Copyright 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package java.lang;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Generally unsupported. This class is provided so that the GWT compiler can
 * choke down class literal references.
 * <p>
 * NOTE: The code in this class is very sensitive and should keep its dependencies upon other
 * classes to a minimum.
 *
 * @param <T> the type of the object
 */
public final class Class<T> {

  public String getName() {
    return "ObjMasd";
  }

  /**
   * Create a Class object for a class.
   *
   * @skip
   */
  static <T> Class<T> createForClass(String packageName, String compoundClassName,
      JavaScriptObject typeId, Class<? super T> superclass) {
    return null;
  }
}

