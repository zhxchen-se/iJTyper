public class xstream_class_19 {
    public class CustomConverter implements com.thoughtworks.xstream.converters.Converter {
        public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
            // TODO: Get annotation value from object 'source' with name of tag via Reflection.
            // Or add a method to the AnimalConfig interface giving you tag name to put to serialization output.
        }

        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
            java.lang.Class canConvert = null;
            // TODO: use reflection to create animal object based on what you xml tag you have at hahd.
            return context.convertAnother(context.currentObject(), canConvert);
        }

        public boolean canConvert(java.lang.Class type) {
            return true;
        }
    }
}

