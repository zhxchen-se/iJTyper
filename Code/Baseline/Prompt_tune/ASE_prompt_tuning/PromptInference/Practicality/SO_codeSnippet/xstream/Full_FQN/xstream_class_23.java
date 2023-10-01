public class xstream_class_23 {
  @com.thoughtworks.xstream.annotations.XStreamAlias("test")
  public class TestObject {
    private java.lang.String foo;

    public java.lang.String getFoo() {
      // return foo; -- Adjusted for EDIT#2
      return java.lang.String.toLowerCase();
    }

    public void setFoo(java.lang.String foo) {
      this.foo = foo;
    }
  }

  public void test() throws java.lang.Exception {
    com.thoughtworks.xstream.XStream x = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.XppDriver());
    com.thoughtworks.xstream.XStream.autodetectAnnotations(boolean)
    com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
    com.thoughtworks.xstream.XStream.registerConverter(com.thoughtworks.xstream.converters.javabean.JavaBeanConverter)
    xstream_class_23.TestObject o = new xstream_class_23.TestObject();
    xstream_class_23$TestObject.setFoo(java.lang.String)
    java.lang.String xml = com.thoughtworks.xstream.XStream.toXML(xstream_class_23$TestObject);
    java.io.PrintStream.println(java.lang.String)
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
