public class xt1 {
  public static void h1() {
    com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder nameCoder = new com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder("ddd", "_");
    com.thoughtworks.xstream.XStream xmlStream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.Dom4JDriver(nameCoder));
  }
}
