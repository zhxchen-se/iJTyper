public class xstream_class_39 {
  private static com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream() {
    public com.thoughtworks.xstream.io.HierarchicalStreamWriter createWriter(java.io.Writer out) {
      return new com.thoughtworks.xstream.io.xml.PrettyPrintWriter(out) {
        // Add CDATA block
        boolean cdata;// I need to add cdata for some fields only


        boolean isNeedUpper;// only some will need this


        protected void writeText(com.thoughtworks.xstream.core.util.QuickWriter writer, java.lang.String text) {
          if (cdata) {
            com.thoughtworks.xstream.core.util.QuickWriter.write(java.lang.String)
            com.thoughtworks.xstream.core.util.QuickWriter.write(java.lang.String)
            com.thoughtworks.xstream.core.util.QuickWriter.write(java.lang.String)
          } else if (isNeedUpper) {
            com.thoughtworks.xstream.core.util.QuickWriter.write(java.lang.String)
          } else
            com.thoughtworks.xstream.core.util.QuickWriter.write(java.lang.String)

        }
      };
    }
  };
}
