public class xstream_class_29 {
    private static void createXmlEmail() {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("email", xstream_class_29.EmailPojo.class);
        xstream.alias("recipient", xstream_class_29.Recipient.class);
        xstream_class_29.EmailPojo ep = new xstream_class_29.EmailPojo();
        java.util.List<xstream_class_29.Recipient> toRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
        toRecipient.add(new xstream_class_29.Recipient("user1@somecompany.com"));
        toRecipient.add(new xstream_class_29.Recipient("user2@somecompany.com"));
        java.util.List<xstream_class_29.Recipient> ccRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
        ccRecipient.add(new xstream_class_29.Recipient("user3@somecompany.com"));
        ccRecipient.add(new xstream_class_29.Recipient("user4@somecompany.com"));
        java.util.List<xstream_class_29.Recipient> bccRecipient = new java.util.ArrayList<xstream_class_29.Recipient>();
        bccRecipient.add(new xstream_class_29.Recipient("user5@somecompany.com"));
        bccRecipient.add(new xstream_class_29.Recipient("user6@somecompany.com"));
        ep.setTo(toRecipient);
        ep.setCc(ccRecipient);
        ep.setBcc(bccRecipient);
        ep.setSubject("subject test");
        ep.setBody("body test");
        java.lang.String xml = xstream.toXML(ep);
        java.lang.System.out.println(xml);
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

