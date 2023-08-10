public class xstream_class_11 {
    public java.util.List<java.lang.String> tags = new java.util.ArrayList<java.lang.String>();

    public java.util.List<java.lang.String> notags = new java.util.ArrayList<java.lang.String>();

    public xstream_class_11(java.lang.String tag, java.lang.String tag2) {
        tags.add(tag);
        tags.add(tag2);
        notags.add(tag);
        notags.add(tag2);
    }

    public static void main(java.lang.String[] args) {
        xstream_class_11 test = new xstream_class_11("foo", "bar");
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
        com.thoughtworks.xstream.mapper.ClassAliasingMapper mapper = new com.thoughtworks.xstream.mapper.ClassAliasingMapper(xstream.getMapper());
        mapper.addClassAlias("tag", java.lang.String.class);
        xstream.registerLocalConverter(xstream_class_11.class, "tags", new com.thoughtworks.xstream.converters.collections.CollectionConverter(mapper));
        java.lang.System.out.println(xstream.toXML(test));
    }
}

