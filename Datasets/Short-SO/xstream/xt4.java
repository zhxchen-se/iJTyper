package java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;

public class xt4 {
    public static void h1(){
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.alias("entity", Entity[].class);
    }
}
