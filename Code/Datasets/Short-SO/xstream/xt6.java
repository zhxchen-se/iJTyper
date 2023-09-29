package java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class xt6 {
    public static void h1(){
        JettisonMappedXmlDriver xmlDriver = new JettisonMappedXmlDriver();
        XStream xstream = new XStream(xmlDriver);
    }
}
