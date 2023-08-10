public class xstream_class_1 implements com.thoughtworks.xstream.converters.Converter {
    @java.lang.Override
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            java.lang.String a;
            if (reader.getNodeName().equals("a")) {
                a = reader.getValue();
            } else if (reader.getNodeName().equals("b")) {
                java.lang.Object b = ((java.lang.Object) (context.convertAnother(reader, java.lang.Object.class)));
            } else if (reader.getNodeName().equals("c")) {
                a = reader.getValue();
            }
        } 
        return context;
    }

    @java.lang.Override
    public boolean canConvert(java.lang.Class arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @java.lang.Override
    public void marshal(java.lang.Object arg0, com.thoughtworks.xstream.io.HierarchicalStreamWriter arg1, com.thoughtworks.xstream.converters.MarshallingContext arg2) {
        // TODO Auto-generated method stub
    }
}

