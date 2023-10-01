public class xt20 {
  public static void h1() {
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
    com.thoughtworks.xstream.mapper.ClassAliasingMapper mapper = new com.thoughtworks.xstream.mapper.ClassAliasingMapper(com.thoughtworks.xstream.XStream.getMapper());
    com.thoughtworks.xstream.XStream.registerLocalConverter(java.lang.Class,java.lang.String,com.thoughtworks.xstream.converters.collections.CollectionConverter)
  }
}
