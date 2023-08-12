package java.xstream;

import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;

public class xt9 {
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	Result outputTarget = new StreamResult(outputStream);
	Transformer t = TransformerFactory.newInstance().newTransformer();

	public xt9() throws TransformerConfigurationException {
	}
}