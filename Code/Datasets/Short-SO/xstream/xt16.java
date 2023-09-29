package java.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.dom4j.persistence.DocumentMarshalling;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringWriter;

public class xt16 {
    public static Object Load(String xmlPath) {
        File FileIn = new File(xmlPath);
        if(FileIn.exists()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            return null;
        }
        return null;
    }
}