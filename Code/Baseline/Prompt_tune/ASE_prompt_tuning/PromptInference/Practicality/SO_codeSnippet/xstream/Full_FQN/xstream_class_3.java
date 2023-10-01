public class xstream_class_3 {
  public static void main(java.lang.String[] args) {
    com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver xmlDriver = new com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver();
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(xmlDriver);
    java.util.List messages = new java.util.ArrayList();
    java.lang.Object mock1 = null;
    java.util.List.add(java.lang.Object)
    java.lang.Object mock2 = null;
    java.util.List.add(java.lang.Object)
    java.lang.Object mock3 = null;
    java.util.List.add(java.lang.Object)
    java.lang.String jsonString = com.thoughtworks.xstream.XStream.toXML(java.util.List);
    java.io.PrintStream.println(java.lang.String)
    java.util.List xstreamJSONUnmarshalledMessages = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    java.io.PrintStream.println(java.lang.String)
    // Attempt to deserialize a reasonable looking JSON string
    java.lang.String jsonTest = "{" + (((((((((((((("\"list\" : [" + "{") + "\"MockMessage\" : {") + "\"val\" : 1") + "}") + "}, {") + "\"MockMessage\" : {") + "\"val\" : 1") + "}") + "}, {") + "\"MockMessageOther\" : {") + "\"otherVal\" : 1") + "}") + "} ]") + "};");
    java.util.List unmarshalledMessages = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    java.io.PrintStream.println(java.lang.String)
  }
}
