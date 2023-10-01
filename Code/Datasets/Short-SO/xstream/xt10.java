package java.xstream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.StringWriter;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import static java.lang.System.out;

public class xt10 {
    public static void h1(){
        XStream stream = new XStream(new StaxDriver());
        stream.toXML(messages, out);
        StringWriter out = new StringWriter();
    }
}
