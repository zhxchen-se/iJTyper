public class xstream_class_41 {
  public static void main(java.lang.String[] arg) {
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver());
    com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
    com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
    java.lang.String s = new java.lang.String("<data>\n" + ((("\t<i Name=\'asia\' type=\'continent\' id=\'11\'></i>\n" + "\t<i Name=\'africa\' type=\'continent\' id=\'12\'></i>\n") + "\t<i Name=\'japan\' type=\'country\' id=\'13\'></i>\n") + "</data>"));
    java.io.PrintStream.println(java.lang.String)
    xstream_class_41.DetList data = com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
  }

  public class DetList {
    private java.util.List<xstream_class_41.Details> detlist;

    public java.util.List<xstream_class_41.Details> getDetlist() {
      return detlist;
    }

    public void setDetlist(java.util.List<xstream_class_41.Details> detlist) {
      this.detlist = detlist;
    }
  }

  // Getters and Setters are here.
  public class Details {
    private java.lang.String Name;

    private java.lang.String type;

    private java.lang.String id;
  }
}
