public class xstream_class_23 {
    @com.thoughtworks.xstream.annotations.XStreamAlias("test")
    public class TestObject {
        private java.lang.String foo;

        public java.lang.String getFoo() {
            // return foo; -- Adjusted for EDIT#2
            return foo.toLowerCase();
        }

        public void setFoo(java.lang.String foo) {
            this.foo = foo;
        }
    }

    public void test() throws java.lang.Exception {
        com.thoughtworks.xstream.XStream x = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.XppDriver());
        x.autodetectAnnotations(true);
        x.processAnnotations(xstream_class_23.TestObject.class);
        x.registerConverter(new com.thoughtworks.xstream.converters.javabean.JavaBeanConverter(x.getMapper()));
        xstream_class_23.TestObject o = new xstream_class_23.TestObject();
        // o.setFoo("bar"); -- Adjusted for EDIT#2
        o.setFoo("BAR");
        java.lang.String xml = x.toXML(o);
        java.lang.System.out.println(xml);
        /* Expecting...
        <test>
        <foo>bar</foo>
        </test>

        But instead getting...
        <test>
        <foo/>
        </test>
         */
    }
}

