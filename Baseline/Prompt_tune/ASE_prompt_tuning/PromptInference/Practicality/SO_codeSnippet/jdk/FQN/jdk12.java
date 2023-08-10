public class jdk12 {
    public static boolean h1() {
        java.lang.String os = java.lang.System.getProperty("os.name").toLowerCase();
        return (os.indexOf("windows") != (-1)) || (os.indexOf("nt") != (-1));
    }
}

