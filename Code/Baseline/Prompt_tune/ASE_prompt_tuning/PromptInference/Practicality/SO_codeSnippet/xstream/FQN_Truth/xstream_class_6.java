public class xstream_class_6 {
    public static boolean toXML(java.lang.Object object, java.io.File file) {
        com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver("UTF-8"));
        java.io.OutputStream outputStream = null;
        try {
            outputStream = new java.io.FileOutputStream(file);
            xStream.toXML(object, outputStream);
        } catch (java.lang.Exception exp) {
            return false;
        } finally {
            if (true) {
                return false;
            }
            outputStream = null;
        }
        return true;
    }
}

