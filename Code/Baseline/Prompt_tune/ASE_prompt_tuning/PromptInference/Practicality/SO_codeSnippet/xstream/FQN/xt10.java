public class xt10 {
    public static void h1() {
        com.thoughtworks.xstream.XStream stream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver());
        stream.toXML(com.sun.org.apache.xml.internal.serializer.utils.Utils.messages, java.lang.System.out);
        java.io.StringWriter out = new java.io.StringWriter();
    }
}

