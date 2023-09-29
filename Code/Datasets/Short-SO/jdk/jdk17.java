package java.jdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class jdk17 {
    private static InputStream stream;
    public static void h1() throws IOException {
        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        Reader in = new InputStreamReader(stream, StandardCharsets.UTF_8);
    }
}
