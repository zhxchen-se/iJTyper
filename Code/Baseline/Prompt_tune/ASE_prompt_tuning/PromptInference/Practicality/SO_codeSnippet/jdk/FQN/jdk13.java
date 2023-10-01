public class jdk13 {
    public static boolean isMac() {
        java.lang.String os = java.lang.System.getProperty("os.name");
        return os.contains("mac");
    }
}

