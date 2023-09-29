public class xstream_class_37 {
    public class FieldDtoConvertor implements com.thoughtworks.xstream.converters.Converter {
        public boolean canConvert(java.lang.Class clazz) {
            return clazz.equals(xstream_class_37.FieldDto.class);
        }

        public void marshal(final java.lang.Object value, final com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, final com.thoughtworks.xstream.converters.MarshallingContext context) {
            final xstream_class_37.FieldDto fieldDto = ((xstream_class_37.FieldDto) (value));
            for (int i = 0; i < fieldDto.getSize(); i++) {
                writer.addAttribute(fieldDto.getAttributeName(i), fieldDto.getAttributeValue(i));
            }
            writer.setValue(fieldDto.getText());
        }

        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
            xstream_class_37.FieldDto fieldDto = new xstream_class_37.FieldDto();
            for (int i = 0; i < reader.getAttributeCount(); i++) {
                fieldDto.addAttribute(reader.getAttributeName(i), reader.getAttribute(i));
            }
            fieldDto.setText(reader.getValue());
            return fieldDto;
        }
    }

    public class FieldDto {
        private java.util.ArrayList<java.lang.String> attributeName = null;

        private java.util.ArrayList<java.lang.String> attributeValue = null;

        private java.lang.String text;

        public FieldDto() {
            attributeName = new java.util.ArrayList<java.lang.String>();
            attributeValue = new java.util.ArrayList<java.lang.String>();
        }

        public java.lang.String getAttributeName(int index) {
            return attributeName.get(index);
        }

        public void addAttribute(java.lang.String attributeName, java.lang.String attributeValue) {
            this.attributeName.add(attributeName);
            this.attributeValue.add(attributeValue);
        }

        public java.lang.String getAttributeValue(int index) {
            return attributeValue.get(index);
        }

        public java.lang.String getText() {
            return text;
        }

        public void setText(java.lang.String text) {
            this.text = text;
        }

        public int getSize() {
            return attributeName.size();
        }
    }
}

