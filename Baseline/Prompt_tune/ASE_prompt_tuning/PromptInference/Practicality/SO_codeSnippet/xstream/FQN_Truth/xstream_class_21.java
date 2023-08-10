public class xstream_class_21 {
    static class MyConverter implements com.thoughtworks.xstream.converters.Converter {
        private final java.util.Map<java.lang.String, java.lang.String> attributes;

        private final java.lang.Class<?> clazz;

        private final com.thoughtworks.xstream.mapper.Mapper mapper;

        private final com.thoughtworks.xstream.converters.reflection.ReflectionProvider reflectionProvider;

        public MyConverter(com.thoughtworks.xstream.mapper.Mapper mapper, com.thoughtworks.xstream.converters.reflection.ReflectionProvider reflectionProvider, java.lang.Class<?> clazz, java.util.Map<java.lang.String, java.lang.String> attributes) {
            super();
            this.mapper = mapper;
            this.reflectionProvider = reflectionProvider;
            this.attributes = attributes;
            this.clazz = clazz;
        }

        @java.lang.Override
        public boolean canConvert(java.lang.Class cls) {
            return cls == clazz;
        }

        @java.lang.Override
        public void marshal(java.lang.Object value, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
            for (java.lang.String key : attributes.keySet()) {
                writer.addAttribute(key, attributes.get(key));
            }
            com.thoughtworks.xstream.converters.Converter converter = new com.thoughtworks.xstream.converters.reflection.ReflectionConverter(mapper, reflectionProvider);
            java.lang.Object p = null;
            context.convertAnother(p, converter);
        }

        @java.lang.Override
        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader arg0, com.thoughtworks.xstream.converters.UnmarshallingContext arg1) {
            // TODO Auto-generated method stub
            return null;
        }
    }
}

