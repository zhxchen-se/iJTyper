public class xstream_class_15 {
    public static void main(java.lang.String[] arg) {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        xs.registerConverter(new com.thoughtworks.xstream.converters.collections.CollectionConverter(xs.getMapper()) {
            @java.lang.Override
            public void marshal(java.lang.Object source, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
                org.hibernate.collection.PersistentSet ps = null;
                super.marshal(new java.util.HashSet(ps), writer, context);
            }

            @java.lang.Override
            public boolean canConvert(java.lang.Class type) {
                return type.isAssignableFrom(org.hibernate.collection.PersistentSet.class);
            }
        }, XStream.PRIORITY_VERY_HIGH);
        java.lang.Object processInstance = null;
        java.lang.String s = xs.toXML(processInstance);
    }
}

