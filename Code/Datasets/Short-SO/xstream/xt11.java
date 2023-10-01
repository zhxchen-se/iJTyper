package java.xstream;

import org.w3c.dom.Node;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class xt11 {
    public static void h1(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Node doc = null;
        Source xmlSource = new DOMSource(doc);
    }
}
