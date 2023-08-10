package java.xstream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;


public class xt1 {
    public static void h1(){
        XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("ddd", "_");
        XStream xmlStream = new XStream(new Dom4JDriver(nameCoder));
    }
}
