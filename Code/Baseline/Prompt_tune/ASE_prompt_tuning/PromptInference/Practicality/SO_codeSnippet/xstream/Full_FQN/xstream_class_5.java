public class xstream_class_5 {
  public class Test {
    public void main(java.lang.String[] args) throws java.io.FileNotFoundException {
      com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
      xstream_class_5.Foo f = new xstream_class_5.Foo(1, "booo", new xstream_class_5.Bar(42));
      java.io.PrintWriter pw = new java.io.PrintWriter("a.xml");
      com.thoughtworks.xstream.XStream.toXML(xstream_class_5$Foo,java.io.PrintWriter)
    }
  }

  public class Bar {
    public int id;

    public Bar(int id) {
      this.id = id;
    }
  }

  public class Foo {
    public int a;

    public java.lang.String b;

    public xstream_class_5.Bar boo;

    public Foo(int a, java.lang.String b, xstream_class_5.Bar c) {
      this.a = a;
      this.b = b;
      this.boo = c;
    }
  }
}
