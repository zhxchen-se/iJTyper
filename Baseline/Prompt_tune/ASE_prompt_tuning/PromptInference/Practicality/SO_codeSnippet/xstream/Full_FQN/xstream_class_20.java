public class xstream_class_20 {
  @java.lang.SuppressWarnings("unchecked")
  public static <A> A fromXML(java.lang.Class c, java.io.File file) {
    // Don't ever try to use DomDriver. They are VERY slow.
    com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream();
    java.io.InputStream inputStream = null;
    java.io.Reader reader = null;
    try {
      inputStream = new java.io.FileInputStream(file);
      reader = new java.io.InputStreamReader(inputStream, java.nio.charset.Charset.forName(java.lang.String));
      java.lang.Object object = com.thoughtworks.xstream.XStream.fromXML(java.io.Reader);
      if (java.lang.Class.isInstance(java.lang.Object)) {
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
