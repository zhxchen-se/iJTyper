public class jdk18 {
    private static java.io.InputStream inputStream;

    public static java.lang.String h1() throws java.io.IOException {
        java.io.StringWriter writer = new java.io.StringWriter();
        org.apache.commons.io.IOUtils.copy(java.jdk.jdk18.inputStream, writer, "UTF-8");
        return writer.toString();
    }
}

