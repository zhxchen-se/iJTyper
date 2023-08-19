[
  {
    "maskCode": "private static final <mask><mask><mask>.Preferences userRoot = Preferences.userRoot();",
    "Glob_context": "private static final int KEY_ALL_ACCESS = 0xf003f; private static final int KEY_READ = 0x20019; private static final <mask><mask><mask>.Preferences userRoot = java.util.prefs.Preferences.userRoot(); private static final java.util.prefs.Preferences systemRoot = java.util.prefs.Preferences.systemRoot(); private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass();"
  },
  {
    "maskCode": "private static final Preferences userRoot = <mask><mask><mask>.Preferences.userRoot();",
    "Glob_context": "private static final int KEY_ALL_ACCESS = 0xf003f; private static final int KEY_READ = 0x20019; private static final java.util.prefs.Preferences userRoot = <mask><mask><mask>.Preferences.userRoot(); private static final java.util.prefs.Preferences systemRoot = java.util.prefs.Preferences.systemRoot(); private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass();"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Preferences systemRoot = Preferences.systemRoot();",
    "Glob_context": "private static final int KEY_READ = 0x20019; private static final java.util.prefs.Preferences userRoot = java.util.prefs.Preferences.userRoot(); private static final <mask><mask><mask>.Preferences systemRoot = java.util.prefs.Preferences.systemRoot(); private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass(); private static final java.lang.reflect.Method regOpenKey;"
  },
  {
    "maskCode": "private static final Preferences systemRoot = <mask><mask><mask>.Preferences.systemRoot();",
    "Glob_context": "private static final int KEY_READ = 0x20019; private static final java.util.prefs.Preferences userRoot = java.util.prefs.Preferences.userRoot(); private static final java.util.prefs.Preferences systemRoot = <mask><mask><mask>.Preferences.systemRoot(); private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass(); private static final java.lang.reflect.Method regOpenKey;"
  },
  {
    "maskCode": "private static final Class<? extends <mask><mask><mask>.Preferences> userClass = userRoot.getClass();",
    "Glob_context": "private static final java.util.prefs.Preferences userRoot = java.util.prefs.Preferences.userRoot(); private static final java.util.prefs.Preferences systemRoot = java.util.prefs.Preferences.systemRoot(); private static final Class<? extends <mask><mask><mask>.Preferences> userClass = userRoot.getClass(); private static final java.lang.reflect.Method regOpenKey; private static final java.lang.reflect.Method regCloseKey;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regOpenKey;",
    "Glob_context": "private static final java.util.prefs.Preferences systemRoot = java.util.prefs.Preferences.systemRoot(); private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass(); private static final <mask><mask><mask>.Method regOpenKey; private static final java.lang.reflect.Method regCloseKey; private static final java.lang.reflect.Method regQueryValueEx;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regCloseKey;",
    "Glob_context": "private static final Class<? extends java.util.prefs.Preferences> userClass = userRoot.getClass(); private static final java.lang.reflect.Method regOpenKey; private static final <mask><mask><mask>.Method regCloseKey; private static final java.lang.reflect.Method regQueryValueEx; private static final java.lang.reflect.Method regEnumValue;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regQueryValueEx;",
    "Glob_context": "private static final java.lang.reflect.Method regOpenKey; private static final java.lang.reflect.Method regCloseKey; private static final <mask><mask><mask>.Method regQueryValueEx; private static final java.lang.reflect.Method regEnumValue; private static final java.lang.reflect.Method regQueryInfoKey;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regEnumValue;",
    "Glob_context": "private static final java.lang.reflect.Method regCloseKey; private static final java.lang.reflect.Method regQueryValueEx; private static final <mask><mask><mask>.Method regEnumValue; private static final java.lang.reflect.Method regQueryInfoKey; private static final java.lang.reflect.Method regEnumKeyEx;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regQueryInfoKey;",
    "Glob_context": "private static final java.lang.reflect.Method regQueryValueEx; private static final java.lang.reflect.Method regEnumValue; private static final <mask><mask><mask>.Method regQueryInfoKey; private static final java.lang.reflect.Method regEnumKeyEx; private static final java.lang.reflect.Method regCreateKeyEx;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regEnumKeyEx;",
    "Glob_context": "private static final java.lang.reflect.Method regEnumValue; private static final java.lang.reflect.Method regQueryInfoKey; private static final <mask><mask><mask>.Method regEnumKeyEx; private static final java.lang.reflect.Method regCreateKeyEx; private static final java.lang.reflect.Method regSetValueEx;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regCreateKeyEx;",
    "Glob_context": "private static final java.lang.reflect.Method regQueryInfoKey; private static final java.lang.reflect.Method regEnumKeyEx; private static final <mask><mask><mask>.Method regCreateKeyEx; private static final java.lang.reflect.Method regSetValueEx; private static final java.lang.reflect.Method regDeleteKey;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regSetValueEx;",
    "Glob_context": "private static final java.lang.reflect.Method regEnumKeyEx; private static final java.lang.reflect.Method regCreateKeyEx; private static final <mask><mask><mask>.Method regSetValueEx; private static final java.lang.reflect.Method regDeleteKey; private static final java.lang.reflect.Method regDeleteValue;"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regDeleteKey;",
    "Glob_context": "private static final java.lang.reflect.Method regCreateKeyEx; private static final java.lang.reflect.Method regSetValueEx; private static final <mask><mask><mask>.Method regDeleteKey; private static final java.lang.reflect.Method regDeleteValue; static { try { regOpenKey = userClass.getDeclaredMethod(String, new Class[] { int.class, byte[].class, int.class });"
  },
  {
    "maskCode": "private static final <mask><mask><mask>.Method regDeleteValue;",
    "Glob_context": "private static final java.lang.reflect.Method regSetValueEx; private static final java.lang.reflect.Method regDeleteKey; private static final <mask><mask><mask>.Method regDeleteValue; static { try { regOpenKey = userClass.getDeclaredMethod(String, new Class[] { int.class, byte[].class, int.class }); regOpenKey.setAccessible(true);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "public static <mask><mask><mask>.Map<String, String> readStringValues(int hkey, String key)",
    "Glob_context": "} else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey); } } /** * Read value(s) and value name(s) form given key * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @return the value name(s) plus the value(s) * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static <mask><mask><mask>.Map<String, String> readStringValues(int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readStringValues(systemRoot, hkey, key); } else if (hkey == HKEY_CURRENT_USER) { return readStringValues(userRoot, hkey, key); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "public static <mask><mask><mask>.List<String> readStringSubKeys(int hkey, String key)",
    "Glob_context": "} else if (hkey == HKEY_CURRENT_USER) { return readStringValues(userRoot, hkey, key); } else { throw new IllegalArgumentException(String + hkey); } } /** * Read the value name(s) from a given key * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @return the value name(s) * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static <mask><mask><mask>.List<String> readStringSubKeys(int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readStringSubKeys(systemRoot, hkey, key); } else if (hkey == HKEY_CURRENT_USER) { return readStringSubKeys(userRoot, hkey, key); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "private static int deleteValue(<mask><mask><mask>.Preferences root, int hkey, String key, String value)",
    "Glob_context": "} else if (hkey == HKEY_CURRENT_USER) { rc = deleteValue(userRoot, hkey, key, value); } if (rc != REG_SUCCESS) { throw new IllegalArgumentException(String + rc + String + key + String + value); } } // ===================== private static int deleteValue(<mask><mask><mask>.Preferences root, int hkey, String key, String value) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) }); if (handles[1] != REG_SUCCESS) { return handles[1]; // can be REG_NOTFOUND, REG_ACCESSDENIED } int rc = ((Integer) regDeleteValue.invoke(root, new Object[] { new Integer(handles[0]), toCstr(value) })) .intValue(); regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) });"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "private static int deleteKey(<mask><mask><mask>.Preferences root, int hkey, String key)",
    "Glob_context": "regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return rc; } private static int deleteKey(<mask><mask><mask>.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int rc = ((Integer) regDeleteKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key) })).intValue(); return rc; // can REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS } private static String readString(java.util.prefs.Preferences root, int hkey, String key, String value) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "private static String readString(<mask><mask><mask>.Preferences root, int hkey, String key, String value)",
    "Glob_context": "return rc; } private static int deleteKey(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int rc = ((Integer) regDeleteKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key) })).intValue(); return rc; // can REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS } private static String readString(<mask><mask><mask>.Preferences root, int hkey, String key, String value) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null; } byte[] valb = (byte[]) regQueryValueEx.invoke(root, new Object[] { new Integer(handles[0]), toCstr(value) });"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "private static <mask><mask><mask>.Map<String, String> readStringValues(Preferences root, int hkey, String key)",
    "Glob_context": "regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return (valb != null ? new String(valb).trim() : null); } private static <mask><mask><mask>.Map<String, String> readStringValues(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.HashMap<String, String> results = new java.util.HashMap<String, String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "private static Map<String, String> readStringValues(<mask><mask><mask>.Preferences root, int hkey, String key)",
    "Glob_context": "regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return (valb != null ? new String(valb).trim() : null); } private static java.util.Map<String, String> readStringValues(<mask><mask><mask>.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.HashMap<String, String> results = new java.util.HashMap<String, String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "<mask><mask><mask>.HashMap<String, String> results = new HashMap<String, String>();",
    "Glob_context": "regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return (valb != null ? new String(valb).trim() : null); } private static java.util.Map<String, String> readStringValues(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { <mask><mask><mask>.HashMap<String, String> results = new java.util.HashMap<String, String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "HashMap<String, String> results = new <mask><mask><mask>.HashMap<String, String>();",
    "Glob_context": "regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return (valb != null ? new String(valb).trim() : null); } private static java.util.Map<String, String> readStringValues(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.HashMap<String, String> results = new <mask><mask><mask>.HashMap<String, String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "private static <mask><mask><mask>.List<String> readStringSubKeys(Preferences root, int hkey, String key)",
    "Glob_context": "} regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return results; } private static <mask><mask><mask>.List<String> readStringSubKeys(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.List<String> results = new java.util.ArrayList<String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "private static List<String> readStringSubKeys(<mask><mask><mask>.Preferences root, int hkey, String key)",
    "Glob_context": "} regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return results; } private static java.util.List<String> readStringSubKeys(<mask><mask><mask>.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.List<String> results = new java.util.ArrayList<String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "<mask><mask><mask>.List<String> results = new ArrayList<String>();",
    "Glob_context": "} regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return results; } private static java.util.List<String> readStringSubKeys(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { <mask><mask><mask>.List<String> results = new java.util.ArrayList<String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "List<String> results = new <mask><mask><mask>.ArrayList<String>();",
    "Glob_context": "} regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return results; } private static java.util.List<String> readStringSubKeys(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { java.util.List<String> results = new <mask><mask><mask>.ArrayList<String>(); int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); if (handles[1] != REG_SUCCESS) { return null;"
  },
  {
    "maskCode": "private static int[] createKey(<mask><mask><mask>.Preferences root, int hkey, String key)",
    "Glob_context": "} regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); return results; } private static int[] createKey(<mask><mask><mask>.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { return (int[]) regCreateKeyEx.invoke(root, new Object[] { new Integer(hkey), toCstr(key) }); } private static void writeStringValue(java.util.prefs.Preferences root, int hkey, String key, String valueName, String value) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) }); regSetValueEx.invoke(root, new Object[] { new Integer(handles[0]), toCstr(valueName), toCstr(value) });"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  },
  {
    "maskCode": "private static void writeStringValue(<mask><mask><mask>.Preferences root, int hkey, String key, String valueName, String value)",
    "Glob_context": "return results; } private static int[] createKey(java.util.prefs.Preferences root, int hkey, String key) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { return (int[]) regCreateKeyEx.invoke(root, new Object[] { new Integer(hkey), toCstr(key) }); } private static void writeStringValue(<mask><mask><mask>.Preferences root, int hkey, String key, String valueName, String value) throws IllegalArgumentException, IllegalAccessException, java.lang.reflect.InvocationTargetException { int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) }); regSetValueEx.invoke(root, new Object[] { new Integer(handles[0]), toCstr(valueName), toCstr(value) }); regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) });"
  },
  {
    "maskCode": "throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException {",
    "Glob_context": "regDeleteKey.setAccessible(true); } catch (Exception e) { throw new RuntimeException(e); } } private Class_16() { } /** * Read a value from key and value name * @param hkey HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE * @param key * @param valueName * @return the value * @throws IllegalArgumentException * @throws IllegalAccessException * @throws java.lang.reflect.InvocationTargetException */ public static String readString(int hkey, String key, String valueName) throws IllegalArgumentException, IllegalAccessException, <mask><mask><mask>.InvocationTargetException { if (hkey == HKEY_LOCAL_MACHINE) { return readString(systemRoot, hkey, key, valueName); } else if (hkey == HKEY_CURRENT_USER) { return readString(userRoot, hkey, key, valueName); } else { throw new IllegalArgumentException(String + hkey);"
  }
]