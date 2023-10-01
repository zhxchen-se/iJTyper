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

    private static final java.lang.Class<? extends java.util.prefs.Preferences> userClass = Class_.Class_16.userRoot.getClass();

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
            regOpenKey = userClass.getDeclaredMethod("WindowsRegOpenKey", new java.lang.Class[]{ int.class, byte[].class, int.class });
            regOpenKey.setAccessible(true);
            regCloseKey = userClass.getDeclaredMethod("WindowsRegCloseKey", new java.lang.Class[]{ int.class });
            regCloseKey.setAccessible(true);
            regQueryValueEx = userClass.getDeclaredMethod("WindowsRegQueryValueEx", new java.lang.Class[]{ int.class, byte[].class });
            regQueryValueEx.setAccessible(true);
            regEnumValue = userClass.getDeclaredMethod("WindowsRegEnumValue", new java.lang.Class[]{ int.class, int.class, int.class });
            regEnumValue.setAccessible(true);
            regQueryInfoKey = userClass.getDeclaredMethod("WindowsRegQueryInfoKey1", new java.lang.Class[]{ int.class });
            regQueryInfoKey.setAccessible(true);
            regEnumKeyEx = userClass.getDeclaredMethod("WindowsRegEnumKeyEx", new java.lang.Class[]{ int.class, int.class, int.class });
            regEnumKeyEx.setAccessible(true);
            regCreateKeyEx = userClass.getDeclaredMethod("WindowsRegCreateKeyEx", new java.lang.Class[]{ int.class, byte[].class });
            regCreateKeyEx.setAccessible(true);
            regSetValueEx = userClass.getDeclaredMethod("WindowsRegSetValueEx", new java.lang.Class[]{ int.class, byte[].class, byte[].class });
            regSetValueEx.setAccessible(true);
            regDeleteValue = userClass.getDeclaredMethod("WindowsRegDeleteValue", new java.lang.Class[]{ int.class, byte[].class });
            regDeleteValue.setAccessible(true);
            regDeleteKey = userClass.getDeclaredMethod("WindowsRegDeleteKey", new java.lang.Class[]{ int.class, byte[].class });
            regDeleteKey.setAccessible(true);
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
            return Class_.Class_16.readString(Class_.Class_16.systemRoot, hkey, key, valueName);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            return Class_.Class_16.readString(Class_.Class_16.userRoot, hkey, key, valueName);
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
            return Class_.Class_16.readStringValues(Class_.Class_16.systemRoot, hkey, key);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            return Class_.Class_16.readStringValues(Class_.Class_16.userRoot, hkey, key);
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
            return Class_.Class_16.readStringSubKeys(Class_.Class_16.systemRoot, hkey, key);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            return Class_.Class_16.readStringSubKeys(Class_.Class_16.userRoot, hkey, key);
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
            ret = Class_.Class_16.createKey(Class_.Class_16.systemRoot, hkey, key);
            Class_.Class_16.regCloseKey.invoke(Class_.Class_16.systemRoot, new java.lang.Object[]{ new java.lang.Integer(ret[0]) });
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            ret = Class_.Class_16.createKey(Class_.Class_16.userRoot, hkey, key);
            Class_.Class_16.regCloseKey.invoke(Class_.Class_16.userRoot, new java.lang.Object[]{ new java.lang.Integer(ret[0]) });
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
            Class_.Class_16.writeStringValue(Class_.Class_16.systemRoot, hkey, key, valueName, value);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            Class_.Class_16.writeStringValue(Class_.Class_16.userRoot, hkey, key, valueName, value);
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
            rc = Class_.Class_16.deleteKey(Class_.Class_16.systemRoot, hkey, key);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            rc = Class_.Class_16.deleteKey(Class_.Class_16.userRoot, hkey, key);
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
            rc = Class_.Class_16.deleteValue(Class_.Class_16.systemRoot, hkey, key, value);
        } else if (hkey == Class_.Class_16.HKEY_CURRENT_USER) {
            rc = Class_.Class_16.deleteValue(Class_.Class_16.userRoot, hkey, key, value);
        }
        if (rc != Class_.Class_16.REG_SUCCESS) {
            throw new java.lang.IllegalArgumentException((((("rc=" + rc) + "  key=") + key) + "  value=") + value);
        }
    }

    // =====================
    private static int deleteValue(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        int[] handles = ((int[]) (Class_.Class_16.regOpenKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key), new java.lang.Integer(Class_.Class_16.KEY_ALL_ACCESS) })));
        if (handles[1] != Class_.Class_16.REG_SUCCESS) {
            return handles[1];// can be REG_NOTFOUND, REG_ACCESSDENIED

        }
        int rc = ((java.lang.Integer) (Class_.Class_16.regDeleteValue.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]), Class_.Class_16.toCstr(value) }))).intValue();
        Class_.Class_16.regCloseKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) });
        return rc;
    }

    private static int deleteKey(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        int rc = ((java.lang.Integer) (Class_.Class_16.regDeleteKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key) }))).intValue();
        return rc;// can REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS

    }

    private static java.lang.String readString(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        int[] handles = ((int[]) (Class_.Class_16.regOpenKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key), new java.lang.Integer(Class_.Class_16.KEY_READ) })));
        if (handles[1] != Class_.Class_16.REG_SUCCESS) {
            return null;
        }
        byte[] valb = ((byte[]) (Class_.Class_16.regQueryValueEx.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]), Class_.Class_16.toCstr(value) })));
        Class_.Class_16.regCloseKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) });
        return valb != null ? new java.lang.String(valb).trim() : null;
    }

    private static java.util.Map<java.lang.String, java.lang.String> readStringValues(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.util.HashMap<java.lang.String, java.lang.String> results = new java.util.HashMap<java.lang.String, java.lang.String>();
        int[] handles = ((int[]) (Class_.Class_16.regOpenKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key), new java.lang.Integer(Class_.Class_16.KEY_READ) })));
        if (handles[1] != Class_.Class_16.REG_SUCCESS) {
            return null;
        }
        int[] info = ((int[]) (Class_.Class_16.regQueryInfoKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) })));
        int count = info[0];// count

        int maxlen = info[3];// value length max

        for (int index = 0; index < count; index++) {
            byte[] name = ((byte[]) (Class_.Class_16.regEnumValue.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]), new java.lang.Integer(index), new java.lang.Integer(maxlen + 1) })));
            java.lang.String value = Class_.Class_16.readString(hkey, key, new java.lang.String(name));
            results.put(new java.lang.String(name).trim(), value);
        }
        Class_.Class_16.regCloseKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) });
        return results;
    }

    private static java.util.List<java.lang.String> readStringSubKeys(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.util.List<java.lang.String> results = new java.util.ArrayList<java.lang.String>();
        int[] handles = ((int[]) (Class_.Class_16.regOpenKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key), new java.lang.Integer(Class_.Class_16.KEY_READ) })));
        if (handles[1] != Class_.Class_16.REG_SUCCESS) {
            return null;
        }
        int[] info = ((int[]) (Class_.Class_16.regQueryInfoKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) })));
        int count = info[0];// Fix: info[2] was being used here with wrong results. Suggested by davenpcj, confirmed by Petrucio

        int maxlen = info[3];// value length max

        for (int index = 0; index < count; index++) {
            byte[] name = ((byte[]) (Class_.Class_16.regEnumKeyEx.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]), new java.lang.Integer(index), new java.lang.Integer(maxlen + 1) })));
            results.add(new java.lang.String(name).trim());
        }
        Class_.Class_16.regCloseKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) });
        return results;
    }

    private static int[] createKey(java.util.prefs.Preferences root, int hkey, java.lang.String key) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((int[]) (Class_.Class_16.regCreateKeyEx.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key) })));
    }

    private static void writeStringValue(java.util.prefs.Preferences root, int hkey, java.lang.String key, java.lang.String valueName, java.lang.String value) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        int[] handles = ((int[]) (Class_.Class_16.regOpenKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(hkey), Class_.Class_16.toCstr(key), new java.lang.Integer(Class_.Class_16.KEY_ALL_ACCESS) })));
        Class_.Class_16.regSetValueEx.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]), Class_.Class_16.toCstr(valueName), Class_.Class_16.toCstr(value) });
        Class_.Class_16.regCloseKey.invoke(root, new java.lang.Object[]{ new java.lang.Integer(handles[0]) });
    }

    // utility
    private static byte[] toCstr(java.lang.String str) {
        byte[] result = new byte[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            result[i] = ((byte) (str.charAt(i)));
        }
        result[str.length()] = 0;
        return result;
    }
}

