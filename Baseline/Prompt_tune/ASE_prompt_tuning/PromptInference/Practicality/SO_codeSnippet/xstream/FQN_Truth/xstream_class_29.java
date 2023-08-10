public class xstream_class_29 {
	private static void createXmlEmail() {
		com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
		xstream.setMode(com.thoughtworks.xstream.XStream.NO_REFERENCES);
		xstream.alias("email", EmailPojo.class);
		xstream.alias("recipient", Recipient.class);

		EmailPojo ep = new EmailPojo();

		java.util.List<Recipient> toRecipient = new java.util.ArrayList<Recipient>();
		toRecipient.add(new Recipient("user1@somecompany.com"));
		toRecipient.add(new Recipient("user2@somecompany.com"));

		java.util.List<Recipient> ccRecipient = new java.util.ArrayList<Recipient>();
		ccRecipient.add(new Recipient("user3@somecompany.com"));
		ccRecipient.add(new Recipient("user4@somecompany.com"));

		java.util.List<Recipient> bccRecipient = new java.util.ArrayList<Recipient>();
		bccRecipient.add(new Recipient("user5@somecompany.com"));
		bccRecipient.add(new Recipient("user6@somecompany.com"));

		ep.setTo(toRecipient);
		ep.setCc(ccRecipient);
		ep.setBcc(bccRecipient);
		ep.setSubject("subject test");
		ep.setBody("body test");

		String xml = xstream.toXML(ep);
		System.out.println(xml);
	}

	public static class EmailPojo {
		private java.util.List<Recipient> to;
		private java.util.List<Recipient> cc;
		private java.util.List<Recipient> bcc;
		private String subject;
		private String body;

		public java.util.List<Recipient> getTo() {
			return to;
		}

		public void setTo(java.util.List<Recipient> to) {
			this.to = to;
		}

		public java.util.List<Recipient> getCc() {
			return cc;
		}

		public void setCc(java.util.List<Recipient> cc) {
			this.cc = cc;
		}

		public java.util.List<Recipient> getBcc() {
			return bcc;
		}

		public void setBcc(java.util.List<Recipient> bcc) {
			this.bcc = bcc;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
	}

	public static class Recipient {
		private String recipient;

		public Recipient(String recipient) {
			this.recipient = recipient;
		}

		public String getRecipient() {
			return recipient;
		}

		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
	}
}