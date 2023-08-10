public class xstream_class_10 {
    private java.lang.String generateResponse(final com.thoughtworks.xstream.XStream xStream) {
        java.io.StringWriter writer = new java.io.StringWriter();
        xStream.marshal(this, new com.thoughtworks.xstream.io.xml.PrettyPrintWriter(writer) {
            @java.lang.Override
            public void addAttribute(final java.lang.String key, final java.lang.String value) {
                if (!key.equals("class")) {
                    super.addAttribute(key, value);
                }
            }
        });
        return writer.toString();
    }
}

