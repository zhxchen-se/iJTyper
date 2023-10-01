@com.thoughtworks.xstream.annotations.XStreamAlias("Music")
class Music {
  public enum genre {

    ROCK,
    JAZZ;}

  Music.genre type;

  @java.lang.Override
  public java.lang.String toString() {
    return ("Music [type=" + type) + "]";
  }
}public class xstream_class_31 {
  static java.lang.String xml1 = "<Music><type>rock</type></Music>";

  public static void main(java.lang.String[] args) {
    com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream();
    com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
    Music musicObject = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    java.io.PrintStream.println(java.lang.Object)
    // prints Music [type=ROCK]
  }
}
