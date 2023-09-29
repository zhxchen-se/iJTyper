public class xstream_class_12 {
  public class ListToStringXStreamConverter implements com.thoughtworks.xstream.converters.Converter {
    private java.lang.String alias;

    public ListToStringXStreamConverter(java.lang.String alias) {
      java.lang.Object.java.lang.Object()
      this.alias = alias;
    }

    @java.lang.SuppressWarnings("rawtypes")
    @java.lang.Override
    public boolean canConvert(java.lang.Class type) {
      return true;
    }

    @java.lang.Override
    public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      @java.lang.SuppressWarnings("unchecked")
      java.util.List<java.lang.String> list = ((java.util.List<java.lang.String>) (source));
      for (java.lang.String string : list) {
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
      }
    }

    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      throw new java.lang.UnsupportedOperationException("ListToStringXStreamConverter does not offer suport for unmarshal operation");
    }
  }
}
