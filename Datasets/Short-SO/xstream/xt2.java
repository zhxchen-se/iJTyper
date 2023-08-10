package java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class xt2 {
    public  static void h1(){
        XStream xstream = new XStream(new DomDriver("UTF_8", new NoNameCoder()));
    }
}
