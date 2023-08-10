public class jdk5 {
    public static void f1() throws java.net.MalformedURLException {
        java.io.File jar = new java.io.File("");
        java.net.URLClassLoader loader = new java.net.URLClassLoader(new java.net.URL[]{ jar.toURI().toURL() });
    }
}

