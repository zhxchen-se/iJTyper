public class xstream_class_25 {
  public static void main(java.lang.String[] arg) {
    @com.thoughtworks.xstream.annotations.XStreamAlias("Object")
    @com.thoughtworks.xstream.annotations.XStreamConverter(value = com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter.class, strings = { "value" })
    class ResponseObject {
      @com.thoughtworks.xstream.annotations.XStreamAlias("Type")
      private java.lang.String type;

      private java.lang.String value;

      public ResponseObject() {
      }

      public java.lang.String getType() {
        return type;
      }

      public java.lang.String getValue() {
        return value;
      }
    }
  }
}
