package java.xstream;

import com.google.android.gms.plus.model.people.Person;
import com.thoughtworks.xstream.XStream;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xt17 {
    public static void h1(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        File FileIn = new File(xmlPath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    }
}
