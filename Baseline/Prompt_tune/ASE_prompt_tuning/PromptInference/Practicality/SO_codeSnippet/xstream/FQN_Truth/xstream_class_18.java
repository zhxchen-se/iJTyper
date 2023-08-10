public class xstream_class_18 {
    public class MapToAttributesConverter implements com.thoughtworks.xstream.converters.Converter {
        public MapToAttributesConverter() {
        }

        @java.lang.Override
        public boolean canConvert(java.lang.Class type) {
            return java.util.Map.class.isAssignableFrom(type);
        }

        @java.lang.Override
        public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
            java.util.Map<java.lang.String, java.lang.String> map = ((java.util.Map<java.lang.String, java.lang.String>) (source));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                writer.addAttribute(entry.getKey(), entry.getValue().toString());
            }
        }

        @java.lang.Override
        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
            java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();
            for (int i = 0; i < reader.getAttributeCount(); i++) {
                java.lang.String key = reader.getAttributeName(i);
                java.lang.String value = reader.getAttribute(key);
                map.put(key, value);
            }
            return map;
        }
    }
}

