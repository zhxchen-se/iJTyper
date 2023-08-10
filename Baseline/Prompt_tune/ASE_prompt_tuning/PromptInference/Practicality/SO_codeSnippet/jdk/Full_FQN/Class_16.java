public class Class_16 {
  public static final int HKEY_CURRENT_USER = 0x80000001;

  public static final int HKEY_LOCAL_MACHINE = 0x80000002;

  public static final int REG_SUCCESS = 0;

  public static final int REG_NOTFOUND = 2;

  public static final int REG_ACCESSDENIED = 5;

  private static final int KEY_ALL_ACCESS = 0xf003f;

  private static final int KEY_READ = 0x20019;

  private static final java.util.prefs.Preferences userRoot = java.util.prefs.Preferences.userRoot();

  private static final java.util.prefs.Preferences systemRoot = java.util.prefs.Preferences.systemRoot();

  private static final java.lang.Class<? extends java.util.prefs.Preferences> userClass = java.lang.Object.getClass();

  private static final java.lang.reflect.Method regOpenKey;

  private static final java.lang.reflect.Method regCloseKey;

  private static final java.lang.reflect.Method regQueryValueEx;

  private static final java.lang.reflect.Method regEnumValue;

  private static final java.lang.reflect.Method regQueryInfoKey;

  private static final java.lang.reflect.Method regEnumKeyEx;

  private static final java.lang.reflect.Method regCreateKeyEx;

  private static final java.lang.reflect.Method regSetValueEx;

  private static final java.lang.reflect.Method regDeleteKey;

  private static final java.lang.reflect.Method regDeleteValue;

  static {
    try {
      Class_.Class_16.regOpenKey = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regCloseKey = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regQueryValueEx = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regEnumValue = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regQueryInfoKey = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regEnumKeyEx = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regCreateKeyEx = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regSetValueEx = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regDeleteValue = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
      Class_.Class_16.regDeleteKey = java.lang.Class.getDeclaredMethod(java.lang.String,java.lang.Class[]);
      java.lang.reflect.AccessibleObject.setAccessible(boolean)
    } catch (java.lang.Exception e) {
      throw new java.lang.RuntimeException(e);
    }
  }

  private Class_16() {
  }

  /**
   * Read a value from key and value name
   *
   * @param hkey
   * 		HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key
   * 		
   * @param valueName
   * 		
   * @return the value
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static java.lang.String readString(int hkey, java.lang.String key, java.lang.String valueName) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      return Class_.Class_16.readString(java.util.prefs.Preferences,int,java.lang.String,java.lang.String);
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      return Class_.Class_16.readString(java.util.prefs.Preferences,int,java.lang.String,java.lang.String);
    } else {
      throw new java.lang.IllegalArgumentException("hkey=" + hkey);
    }
  }

  /**
   * Read value(s) and value name(s) form given key
   *
   * @param hkey
   * 		HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key
   * 		
   * @return the value name(s) plus the value(s)
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static java.util.Map<java.lang.String, java.lang.String> readStringValues(int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      return Class_.Class_16.readStringValues(java.util.prefs.Preferences,int,java.lang.String);
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      return Class_.Class_16.readStringValues(java.util.prefs.Preferences,int,java.lang.String);
    } else {
      throw new java.lang.IllegalArgumentException("hkey=" + hkey);
    }
  }

  /**
   * Read the value name(s) from a given key
   *
   * @param hkey
   * 		HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key
   * 		
   * @return the value name(s)
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static java.util.List<java.lang.String> readStringSubKeys(int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      return Class_.Class_16.readStringSubKeys(java.util.prefs.Preferences,int,java.lang.String);
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      return Class_.Class_16.readStringSubKeys(java.util.prefs.Preferences,int,java.lang.String);
    } else {
      throw new java.lang.IllegalArgumentException("hkey=" + hkey);
    }
  }

  /**
   * Create a key
   *
   * @param hkey
   * 		HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
   * @param key
   * 		
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static void createKey(int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int[] ret;
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      ret = Class_.Class_16.createKey(java.util.prefs.Preferences,int,java.lang.String);
      java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      ret = Class_.Class_16.createKey(java.util.prefs.Preferences,int,java.lang.String);
      java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    } else {
      throw new java.lang.IllegalArgumentException("hkey=" + hkey);
    }
    if (ret[1] != Class_.Class_16.REG_SUCCESS) {
      throw new java.lang.IllegalArgumentException((("rc=" + ret[1]) + "  key=") + key);
    }
  }

  /**
   * Write a value in a given key/value name
   *
   * @param hkey
   * 		
   * @param key
   * 		
   * @param valueName
   * 		
   * @param value
   * 		
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static void writeStringValue(int hkey, java.lang.String key, java.lang.String valueName, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      Class_.Class_16.writeStringValue(java.util.prefs.Preferences,int,java.lang.String,java.lang.String,java.lang.String)
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      Class_.Class_16.writeStringValue(java.util.prefs.Preferences,int,java.lang.String,java.lang.String,java.lang.String)
    } else {
      throw new java.lang.IllegalArgumentException("hkey=" + hkey);
    }
  }

  /**
   * Delete a given key
   *
   * @param hkey
   * 		
   * @param key
   * 		
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static void deleteKey(int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int rc = -1;
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      rc = Class_.Class_16.deleteKey(java.util.prefs.Preferences,int,java.lang.String);
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      rc = Class_.Class_16.deleteKey(java.util.prefs.Preferences,int,java.lang.String);
    }
    if (rc != Class_.Class_16.REG_SUCCESS) {
      throw new java.lang.IllegalArgumentException((("rc=" + rc) + "  key=") + key);
    }
  }

  /**
   * delete a value from a given key/value name
   *
   * @param hkey
   * 		
   * @param key
   * 		
   * @param value
   * 		
   * @throws IllegalArgumentException
   * 		
   * @throws IllegalAccessException
   * 		
   * @throws InvocationTargetException
   * 		
   */
  public static void deleteValue(int hkey, java.lang.String key, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int rc = -1;
    if (hkey == Class_.Class_16.HKEY_LOCAL_MACHINE) {
      rc = Class_.Class_16.deleteValue(java.util.prefs.Preferences,int,java.lang.String,java.lang.String);
    } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
      rc = Class_.Class_16.deleteValue(java.util.prefs.Preferences,int,java.lang.String,java.lang.String);
    }
    if (rc != Class_.Class_16.REG_SUCCESS) {
      throw new java.lang.IllegalArgumentException((((("rc=" + rc) + "  key=") + key) + "  value=") + value);
    }
  }

  // =====================
  private static int deleteValue(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int[] handles = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    if (handles[1] != Class_.Class_16.REG_SUCCESS) {
      return handles[1];// can be REG_NOTFOUND, REG_ACCESSDENIED

    }
    int rc = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])###java.lang.Integer.intValue();
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    return rc;
  }

  private static int deleteKey(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int rc = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])###java.lang.Integer.intValue();
    return rc;// can REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS

  }

  private static java.lang.String readString(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int[] handles = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    if (handles[1] != Class_.Class_16.REG_SUCCESS) {
      return null;
    }
    byte[] valb = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    return valb != null ? java.lang.String.trim() : null;
  }

  private static java.util.Map<java.lang.String, java.lang.String> readStringValues(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    java.util.HashMap<java.lang.String, java.lang.String> results = new java.util.HashMap<java.lang.String, java.lang.String>();
    int[] handles = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    if (handles[1] != Class_.Class_16.REG_SUCCESS) {
      return null;
    }
    int[] info = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    int count = info[0];// count

    int maxlen = info[3];// value length max

    for (int index = 0; index < count; index++) {
      byte[] name = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
      java.lang.String value = Class_.Class_16.readString(int,java.lang.String,java.lang.String);
      java.util.HashMap.put(java.lang.Object,java.lang.Object)
    }
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    return results;
  }

  private static java.util.List<java.lang.String> readStringSubKeys(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    java.util.List<java.lang.String> results = new java.util.ArrayList<java.lang.String>();
    int[] handles = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    if (handles[1] != Class_.Class_16.REG_SUCCESS) {
      return null;
    }
    int[] info = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    int count = info[0];// Fix: info[2] was being used here with wrong results. Suggested by davenpcj, confirmed by Petrucio

    int maxlen = info[3];// value length max

    for (int index = 0; index < count; index++) {
      byte[] name = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
      java.util.List.add(java.lang.Object)
    }
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    return results;
  }

  private static int[] createKey(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    return java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
  }

  private static void writeStringValue(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String valueName, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
    int[] handles = java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[]);
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
    java.lang.reflect.Method.invoke(java.lang.Object,java.lang.Object[])
  }

  // utility
  private static byte[] toCstr(java.lang.String str) {
    byte[] result = new byte[java.lang.String.length() + 1];
    for (int i = 0; i < java.lang.String.length(); i++) {
      result[i] = java.lang.String.charAt(int);
    }
    result[java.lang.String.length()] = 0;
    return result;
  }
}
