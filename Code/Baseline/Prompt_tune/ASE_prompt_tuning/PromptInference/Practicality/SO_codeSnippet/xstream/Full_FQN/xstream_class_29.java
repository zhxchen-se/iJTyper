public class xstream_class_29 {
  private static void createXmlEmail() {
    com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
    com.thoughtworks.xstream.XStream.setMode()
    com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
    com.thoughtworks.xstream.XStream.alias(java.lang.String,java.lang.Class)
    xstream_class_29.EmailPojo ep = new xstream_class_29.EmailPojo();
    java.util.List<xstream_class_29.Recipient> toRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
    java.util.List.add(java.lang.Object)
    java.util.List.add(java.lang.Object)
    java.util.List<xstream_class_29.Recipient> ccRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
    java.util.List.add(java.lang.Object)
    java.util.List.add(java.lang.Object)
    java.util.List<xstream_class_29.Recipient> bccRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
    java.util.List.add(java.lang.Object)
    java.util.List.add(java.lang.Object)
    xstream_class_29$EmailPojo.setTo(java.util.List)
    xstream_class_29$EmailPojo.setCc(java.util.List)
    xstream_class_29$EmailPojo.setBcc(java.util.List)
    xstream_class_29$EmailPojo.setSubject(java.lang.String)
    xstream_class_29$EmailPojo.setBody(java.lang.String)
    java.lang.String xml = com.thoughtworks.xstream.XStream.toXML(xstream_class_29$EmailPojo);
    java.io.PrintStream.println(java.lang.String)
  }

  public static class EmailPojo {
    private java.util.List<xstream_class_29.Recipient> to;

    private java.util.List<xstream_class_29.Recipient> cc;

    private java.util.List<xstream_class_29.Recipient> bcc;

    private java.lang.String subject;

    private java.lang.String body;

    public java.util.List<xstream_class_29.Recipient> getTo() {
      return to;
    }

    public void setTo(java.util.List<xstream_class_29.Recipient> to) {
      this.to = to;
    }

    public java.util.List<xstream_class_29.Recipient> getCc() {
      return cc;
    }

    public void setCc(java.util.List<xstream_class_29.Recipient> cc) {
      this.cc = cc;
    }

    public java.util.List<xstream_class_29.Recipient> getBcc() {
      return bcc;
    }

    public void setBcc(java.util.List<xstream_class_29.Recipient> bcc) {
      this.bcc = bcc;
    }

    public java.lang.String getSubject() {
      return subject;
    }

    public void setSubject(java.lang.String subject) {
      this.subject = subject;
    }

    public java.lang.String getBody() {
      return body;
    }

    public void setBody(java.lang.String body) {
      this.body = body;
    }
  }

  public static class Recipient {
    private java.lang.String recipient;

    public Recipient(java.lang.String recipient) {
      this.recipient = recipient;
    }

    public java.lang.String getRecipient() {
      return recipient;
    }

    public void setRecipient(java.lang.String recipient) {
      this.recipient = recipient;
    }
  }
}
