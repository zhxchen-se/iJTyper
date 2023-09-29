// ID = 7491195
public class xstream_class_2 {
    public static void main(java.lang.String[] arg) throws java.io.IOException {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new com.thoughtworks.xstream.io.xml.DomDriver());
        java.io.FileReader fin = new java.io.FileReader("path_to_file.xml");
        java.io.BufferedReader br = new java.io.BufferedReader(fin);
        java.lang.String str = null;
        while (br.ready()) {
            str += br.readLine() + "\n";
        } 
    }
}

