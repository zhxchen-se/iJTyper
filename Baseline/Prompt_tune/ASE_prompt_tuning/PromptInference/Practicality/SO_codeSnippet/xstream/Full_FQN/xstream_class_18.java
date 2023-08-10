public class xstream_class_18 {
  public class MapToAttributesConverter implements com.thoughtworks.xstream.converters.Converter {
    public MapToAttributesConverter() {
    }

    @java.lang.Override
    public boolean canConvert(java.lang.Class type) {
      return java.lang.Class.isAssignableFrom(java.lang.Class);
    }

    @java.lang.Override
    public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      java.util.Map<java.lang.String, java.lang.String> map = ((java.util.Map<java.lang.String, java.lang.String>) (source));
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : java.util.Map.entrySet()) {
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.addAttribute(java.lang.String,java.lang.String)
      }
    }

    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();
      for (int i = 0; i < com.thoughtworks.xstream.io.HierarchicalStreamReader.getAttributeCount(); i++) {
        java.lang.String key = com.thoughtworks.xstream.io.HierarchicalStreamReader.getAttributeName(int);
        java.lang.String value = com.thoughtworks.xstream.io.HierarchicalStreamReader.getAttribute(java.lang.String);
        java.util.Map.put(java.lang.Object,java.lang.Object)
      }
      return map;
    }
  }
}
