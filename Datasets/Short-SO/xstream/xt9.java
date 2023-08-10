package java.xstream;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class xt9 {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Result outputTarget = new StreamResult(outputStream);
    Transformer t = TransformerFactory.newInstance().newTransformer();
    public xt9() throws TransformerConfigurationException {
    }
}
