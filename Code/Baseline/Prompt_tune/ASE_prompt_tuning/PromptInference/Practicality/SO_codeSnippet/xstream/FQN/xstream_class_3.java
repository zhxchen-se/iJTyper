public class xstream_class_3 {
    public static void main(java.lang.String[] args) {
        com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver xmlDriver = new com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver();
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(xmlDriver);
        java.util.List messages = new java.util.ArrayList();
        java.lang.Object mock1 = null;
        messages.add(mock1);
        java.lang.Object mock2 = null;
        messages.add(mock2);
        java.lang.Object mock3 = null;
        messages.add(mock3);
        java.lang.String jsonString = xstream.toXML(messages);
        // JSON list format is non-intuitive single element array with class name fields
        java.lang.System.out.println(jsonString);
        java.util.List xstreamJSONUnmarshalledMessages = ((java.util.List) (xstream.fromXML(jsonString)));
        // This will print 3 messages unmarshalled
        java.lang.System.out.println("XStream format JSON Number of messages unmarshalled: " + xstreamJSONUnmarshalledMessages.size());
        // Attempt to deserialize a reasonable looking JSON string
        java.lang.String jsonTest = "{" + (((((((((((((("\"list\" : [" + "{") + "\"MockMessage\" : {") + "\"val\" : 1") + "}") + "}, {") + "\"MockMessage\" : {") + "\"val\" : 1") + "}") + "}, {") + "\"MockMessageOther\" : {") + "\"otherVal\" : 1") + "}") + "} ]") + "};");
        java.util.List unmarshalledMessages = ((java.util.List) (xstream.fromXML(jsonTest)));
        // We expect 3 messages but XStream only deserializes one
        java.lang.System.out.println("Normal format JSON Number of messages unmarshalled: " + unmarshalledMessages.size());
    }
}

