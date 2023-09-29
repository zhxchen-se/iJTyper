public class xstream_class_36 {
    public class MapTest {
        private java.util.Map<java.lang.String, java.lang.String> mapList;

        public MapTest() {
            mapList = new java.util.HashMap<java.lang.String, java.lang.String>();
        }

        public void setServicesHealth(java.lang.String id, java.lang.String name) {
            mapList.put(id, name);
        }
    }

    public static void main(java.lang.String[] arg) {
        xstream.xstream_class_36.MapTest services = null;
        services.setServicesHealth("ID01", "Jack");
        services.setServicesHealth("ID02", "Neil");
        com.thoughtworks.xstream.XStream stream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver());
        stream.alias("MapTest", xstream.xstream_class_36.MapTest.class);
        stream.addImplicitMap(xstream.xstream_class_36.MapTest.class, "map", "id", java.lang.String.class, "name");
        java.lang.String xmlStr = stream.toXML(services);
        java.lang.System.out.println(xmlStr);
    }
}

