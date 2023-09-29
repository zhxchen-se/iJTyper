public class xstream_class_24 {
  public class DetailDollarsConverter extends com.thoughtworks.xstream.converters.reflection.ReflectionConverter {
    public DetailDollarsConverter(com.thoughtworks.xstream.mapper.Mapper mapper, com.thoughtworks.xstream.converters.reflection.ReflectionProvider reflectionProvider) {
      java.lang.Object.java.lang.Object()
    }

    @java.lang.Override
    public void marshal(java.lang.Object obj, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
      com.thoughtworks.xstream.converters.reflection.ReflectionConverter.marshal(java.lang.Object,com.thoughtworks.xstream.io.HierarchicalStreamWriter,com.thoughtworks.xstream.converters.MarshallingContext)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.startNode(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.endNode()
    }

    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      return com.thoughtworks.xstream.converters.reflection.ReflectionConverter.unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader,com.thoughtworks.xstream.converters.UnmarshallingContext);
    }

    @java.lang.SuppressWarnings("unchecked")
    @java.lang.Override
    public boolean canConvert(java.lang.Class clazz) {
      java.lang.Object o = null;
      return java.lang.Object.equals(java.lang.Object);
    }
  }
}
