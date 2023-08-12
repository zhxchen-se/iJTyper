[
  {
    "maskCode": "private <mask><mask><mask>.XStream xstream = new XStream(new DomDriver());",
    "Glob_context": "} } public class ServerHandler { private String fileName = String; private String path = String; private <mask><mask><mask>.XStream xstream = new XStream(new DomDriver()); public void readFromXML() { try { FileInputStream fis = new FileInputStream(path + fileName); ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP());"
  },
  {
    "maskCode": "private XStream xstream = new <mask><mask><mask>.XStream(new DomDriver());",
    "Glob_context": "} } public class ServerHandler { private String fileName = String; private String path = String; private XStream xstream = new <mask><mask><mask>.XStream(new DomDriver()); public void readFromXML() { try { FileInputStream fis = new FileInputStream(path + fileName); ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP());"
  },
  {
    "maskCode": "private XStream xstream = new XStream(new <mask><mask><mask>.DomDriver());",
    "Glob_context": "} } public class ServerHandler { private String fileName = String; private String path = String; private XStream xstream = new XStream(new <mask><mask><mask>.DomDriver()); public void readFromXML() { try { FileInputStream fis = new FileInputStream(path + fileName); ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP());"
  },
  {
    "maskCode": "<mask><mask><mask>.FileInputStream fis = new FileInputStream(path + fileName);",
    "Glob_context": "private String path = String; private XStream xstream = new XStream(new DomDriver()); public void readFromXML() { try { <mask><mask><mask>.FileInputStream fis = new FileInputStream(path + fileName); ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP()); System.out.println(String + server.getIp());"
  },
  {
    "maskCode": "FileInputStream fis = new <mask><mask><mask>.FileInputStream(path + fileName);",
    "Glob_context": "private String path = String; private XStream xstream = new XStream(new DomDriver()); public void readFromXML() { try { FileInputStream fis = new <mask><mask><mask>.FileInputStream(path + fileName); ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP()); System.out.println(String + server.getIp());"
  },
  {
    "maskCode": "} catch (<mask><mask><mask>.FileNotFoundException e) {",
    "Glob_context": "ServerIP server = (ServerIP) xstream.fromXML(fis, new ServerIP()); System.out.println(String + server.getIp()); } catch (<mask><mask><mask>.FileNotFoundException e) { e.printStackTrace(); } } } };"
  }
]