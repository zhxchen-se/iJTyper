public class xstream_class_27 {
  private class ObjectContentConverter implements com.thoughtworks.xstream.converters.Converter {
    com.thoughtworks.xstream.XStream xStream;

    private ObjectContentConverter(com.thoughtworks.xstream.XStream xStream) {
      this.xStream = xStream;
    }

    @java.lang.Override
    public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      java.lang.String className = org.apache.commons.lang.WordUtils.uncapitalize(java.lang.String);
      com.thoughtworks.xstream.XStream.aliasField(java.lang.String,java.lang.Class,java.lang.String)
      com.thoughtworks.xstream.XStream.marshal(java.lang.Object,com.thoughtworks.xstream.io.HierarchicalStreamWriter)
    }

    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      return null;// To change body of implemented methods use File | Settings | File Templates.

    }

    @java.lang.Override
    public boolean canConvert(java.lang.Class type) {
      return true;// To change body of implemented methods use File | Settings | File Templates.

    }
  }
}
