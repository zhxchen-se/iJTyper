public class xstream_class_40 implements com.thoughtworks.xstream.converters.Converter {
  @java.lang.SuppressWarnings("rawtypes")
  @java.lang.Override
  public boolean canConvert(java.lang.Class clazz) {
    return java.lang.Object.equals(java.lang.Object);
  }

  @java.lang.Override
  public void marshal(java.lang.Object object, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
  }

  @java.lang.Override
  public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
    java.lang.String text = com.thoughtworks.xstream.io.HierarchicalStreamReader.getValue();
    java.lang.Integer number = java.lang.Integer.parseInt(java.lang.String);
    return number;
  }
}
