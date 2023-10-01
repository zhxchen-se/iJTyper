package java.xstream;

import com.thoughtworks.xstream.XStream;
import org.hibernate.envers.tools.query.Parameters;

import java.io.FileReader;
import java.util.Properties;

public class xt5 {
    public static void h1(){
        XStream xstream = new XStream();
        xstream.processAnnotations(Properties.class);
    }
}
