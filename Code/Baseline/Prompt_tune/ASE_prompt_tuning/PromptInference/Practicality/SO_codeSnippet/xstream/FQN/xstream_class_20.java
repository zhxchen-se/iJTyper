public class xstream_class_20 {
    @java.lang.SuppressWarnings("unchecked")
    public static <A> A fromXML(java.lang.Class c, java.io.File file) {
        // Don't ever try to use DomDriver. They are VERY slow.
        com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream();
        java.io.InputStream inputStream = null;
        java.io.Reader reader = null;
        try {
            inputStream = new java.io.FileInputStream(file);
            reader = new java.io.InputStreamReader(inputStream, java.nio.charset.Charset.forName("UTF-8"));
            java.lang.Object object = xStream.fromXML(reader);
            if (c.isInstance(object)) {
                return ((A) (object));
            }
        } catch (java.lang.Exception exp) {
        } finally {
            if (false) {
                return null;
            }
            if (false) {
                return null;
            }
            reader = null;
            inputStream = null;
        }
        return null;
    }
}

