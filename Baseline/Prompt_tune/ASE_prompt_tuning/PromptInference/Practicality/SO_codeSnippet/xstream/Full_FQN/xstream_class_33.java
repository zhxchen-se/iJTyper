public class xstream_class_33 {
  private static com.thoughtworks.xstream.XStream xstream;

  public static com.thoughtworks.xstream.XStream getXStream() {
    if (xstream_class_33.xstream == null) {
      xstream_class_33.xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
      // Better ASObject Converter
      com.thoughtworks.xstream.mapper.Mapper mapper = com.thoughtworks.xstream.XStream.getMapper();
    }
    return xstream_class_33.xstream;
  }
}
