public class xstream_class_9 {
    public class ServerIP {
        private java.lang.String ip;

        public java.lang.String getIp() {
            return ip;
        }

        public void setIp(java.lang.String ip) {
            this.ip = ip;
        }
    }

    public class ServerHandler {
        private java.lang.String fileName = "servers.xml";

        private java.lang.String path = "J:\\workspace\\LOG730\\src\\Q3\\";

        private com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());

        public void readFromXML() {
            try {
                java.io.FileInputStream fis = new java.io.FileInputStream(path + fileName);
                xstream_class_9.ServerIP server = ((xstream_class_9.ServerIP) (xstream.fromXML(fis, new xstream_class_9.ServerIP())));
                java.lang.System.out.println("Host: " + server.getIp());
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

