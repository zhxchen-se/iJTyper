package java.jdk;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class jdk18 {
    private static InputStream inputStream;
    public static String h1() throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();

    }
}
