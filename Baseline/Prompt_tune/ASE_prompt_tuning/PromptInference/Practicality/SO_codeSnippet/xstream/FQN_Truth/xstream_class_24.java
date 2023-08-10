public class xstream_class_24 {
    public class DetailDollarsConverter extends com.thoughtworks.xstream.converters.reflection.ReflectionConverter {
        public DetailDollarsConverter(com.thoughtworks.xstream.mapper.Mapper mapper, com.thoughtworks.xstream.converters.reflection.ReflectionProvider reflectionProvider) {
            super(mapper, reflectionProvider);
        }

        @java.lang.Override
        public void marshal(java.lang.Object obj, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
            super.marshal(obj, writer, context);
            writer.startNode("node4");
            writer.setValue(java.lang.Double.toString(20));
            writer.endNode();
        }

        @java.lang.Override
        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
            return super.unmarshal(reader, context);
        }

        @java.lang.SuppressWarnings("unchecked")
        @java.lang.Override
        public boolean canConvert(java.lang.Class clazz) {
            java.lang.Object o = null;
            return clazz.equals(o);
        }
    }
}

