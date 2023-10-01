public class jdk6 {
  private static boolean h1() {
    boolean hasPermission = true;
    java.lang.SecurityManager sm = java.lang.System.getSecurityManager();
    if (sm != null) {
      java.lang.SecurityManager.checkPermission(java.security.Permission)
    }
    return hasPermission;
  }
}
