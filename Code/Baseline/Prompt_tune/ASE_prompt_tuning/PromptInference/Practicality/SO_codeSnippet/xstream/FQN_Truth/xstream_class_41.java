public class xstream_class_41 {
    public static void main(java.lang.String[] arg) {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.StaxDriver());
        xstream.alias("data", xstream_class_41.DetList.class);
        xstream.alias("i", xstream_class_41.Details.class);
        java.lang.String s = new java.lang.String("<data>\n" + ((("\t<i Name=\'asia\' type=\'continent\' id=\'11\'></i>\n" + "\t<i Name=\'africa\' type=\'continent\' id=\'12\'></i>\n") + "\t<i Name=\'japan\' type=\'country\' id=\'13\'></i>\n") + "</data>"));
        java.lang.System.out.println(s);
        xstream_class_41.DetList data = ((xstream_class_41.DetList) (xstream.fromXML(s)));
    }

    public class DetList {
        private java.util.List<xstream.xstream_class_41.Details> detlist;

        public java.util.List<xstream.xstream_class_41.Details> getDetlist() {
            return detlist;
        }

        public void setDetlist(java.util.List<xstream.xstream_class_41.Details> detlist) {
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

