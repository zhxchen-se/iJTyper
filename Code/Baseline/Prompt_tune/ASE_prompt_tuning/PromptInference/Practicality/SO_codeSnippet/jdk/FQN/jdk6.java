public class jdk6 {
    private static boolean h1() {
        boolean hasPermission = true;
        java.lang.SecurityManager sm = java.lang.System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new java.util.PropertyPermission("user.timezone", "write"));
        }
        return hasPermission;
    }
}

