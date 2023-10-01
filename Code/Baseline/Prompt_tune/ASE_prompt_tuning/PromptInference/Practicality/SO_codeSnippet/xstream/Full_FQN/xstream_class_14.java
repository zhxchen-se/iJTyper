public class xstream_class_14 {
  public class SingleValueEnumConverter extends com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter {
    @java.lang.SuppressWarnings("rawtypes")
    private final java.lang.Class enumType;

    public SingleValueEnumConverter(java.lang.Class type) {
      this.enumType = type;
    }

    public boolean canConvert(java.lang.Class c) {
      return java.lang.Object.equals(java.lang.Object);
    }

    public java.lang.Object fromString(java.lang.String value) {
      return java.lang.Enum.valueOf(java.lang.Class,java.lang.String);
    }
  }
}
