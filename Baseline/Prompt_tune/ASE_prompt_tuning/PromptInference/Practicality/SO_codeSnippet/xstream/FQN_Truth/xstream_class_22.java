@com.thoughtworks.xstream.annotations.XStreamAlias("container")
public class xstream_class_22 {
    private java.lang.String name;

    // any element named numberOfEmployees should go into this list
    @com.thoughtworks.xstream.annotations.XStreamImplicit(itemFieldName = "numberOfEmployees")
    protected java.util.List<xstream.xstream_class_22.NumberOfPersonnel> numberOfEmployees;

    public xstream_class_22(java.lang.String name, java.util.List<xstream.xstream_class_22.NumberOfPersonnel> noEmp) {
        this.name = name;
        this.numberOfEmployees = noEmp;
    }

    public java.lang.String toString() {
        return (name + ", ") + numberOfEmployees;
    }

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        xs.processAnnotations(xstream.xstream_class_22.class);
        java.lang.System.out.println("Unmarshalling:");
        java.lang.System.out.println(xs.fromXML(new java.io.File("in.xml")));
        java.lang.System.out.println("Marshalling:");
        java.lang.System.out.println(xs.toXML(new xstream.xstream_class_22("World", java.util.Arrays.asList(new xstream.xstream_class_22.NumberOfPersonnel(2001, 1000), new xstream.xstream_class_22.NumberOfPersonnel(2002, 500)))));
    }

    @com.thoughtworks.xstream.annotations.XStreamConverter(value = com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter.class, strings = { "value" })
    public static class NumberOfPersonnel {
        public NumberOfPersonnel(int year, double value) {
            this.year = year;
            this.value = value;
        }

        private int year;

        private double value;

        public java.lang.String toString() {
            return (year + ": ") + value;
        }
    }
}

