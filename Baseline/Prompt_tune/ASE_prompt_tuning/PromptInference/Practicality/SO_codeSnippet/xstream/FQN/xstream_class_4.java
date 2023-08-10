public class xstream_class_4 {
    public static void main(java.lang.String[] args) {
        java.util.ArrayList<java.lang.Class<?>> classes = new java.util.ArrayList<java.lang.Class<?>>();
        classes.add(java.lang.Integer.class);
        classes.add(java.lang.Long.class);
        classes.add(java.lang.Double.class);
        classes.add(java.lang.Float.class);
        java.util.ArrayList<java.lang.Number> numbers = new java.util.ArrayList<java.lang.Number>();
        numbers.add(new java.lang.Integer(3));
        numbers.add(new java.lang.Long(3));
        numbers.add(new java.lang.Double(3));
        numbers.add(new java.lang.Float(3));
        com.thoughtworks.xstream.XStream xml = new com.thoughtworks.xstream.XStream();
        xml.alias("inty", java.lang.Integer.class);
        xml.aliasType("inty", java.lang.Integer.class);
        xml.aliasPackage("jl", "java.lang");
        java.lang.System.out.println(xml.toXML(classes));
        java.lang.System.out.println(xml.toXML(numbers));
    }
}

