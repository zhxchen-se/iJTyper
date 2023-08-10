public class xstream_class_37 {
  public class FieldDtoConvertor implements com.thoughtworks.xstream.converters.Converter {
    public boolean canConvert(java.lang.Class clazz) {
      return java.lang.Object.equals(java.lang.Object);
    }

    public void marshal(final java.lang.Object value, final com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, final com.thoughtworks.xstream.converters.MarshallingContext context) {
      final xstream_class_37.FieldDto fieldDto = ((xstream_class_37.FieldDto) (value));
      for (int i = 0; i < xstream_class_37$FieldDto.getSize(); i++) {
        com.thoughtworks.xstream.io.HierarchicalStreamWriter.addAttribute(java.lang.String,java.lang.String)
      }
      com.thoughtworks.xstream.io.HierarchicalStreamWriter.setValue(java.lang.String)
    }

    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
      xstream_class_37.FieldDto fieldDto = new xstream_class_37.FieldDto();
      for (int i = 0; i < com.thoughtworks.xstream.io.HierarchicalStreamReader.getAttributeCount(); i++) {
        xstream_class_37$FieldDto.addAttribute(java.lang.String,java.lang.String)
      }
      xstream_class_37$FieldDto.setText(java.lang.String)
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
      return java.util.ArrayList.get(int);
    }

    public void addAttribute(java.lang.String attributeName, java.lang.String attributeValue) {
      java.util.ArrayList.add(java.lang.Object)
      java.util.ArrayList.add(java.lang.Object)
    }

    public java.lang.String getAttributeValue(int index) {
      return java.util.ArrayList.get(int);
    }

    public java.lang.String getText() {
      return text;
    }

    public void setText(java.lang.String text) {
      this.text = text;
    }

    public int getSize() {
      return java.util.ArrayList.size();
    }
  }
}
