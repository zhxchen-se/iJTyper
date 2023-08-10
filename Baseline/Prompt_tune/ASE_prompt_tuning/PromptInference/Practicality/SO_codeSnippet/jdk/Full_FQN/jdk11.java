public class jdk11 {
  private static boolean h1() {
    boolean hasPermission = true;
    java.lang.SecurityManager sm = java.lang.System.getSecurityManager();
    if (sm != null) {
      hasPermission = false;
    }
    return hasPermission;
  }
}
