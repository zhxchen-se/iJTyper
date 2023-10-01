package java.jdk;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class jdk5 {
    public static void f1() throws MalformedURLException {
        File jar = new File("");
        URLClassLoader loader = new
                URLClassLoader(new URL[]{jar.toURI().toURL()});
    }
}

