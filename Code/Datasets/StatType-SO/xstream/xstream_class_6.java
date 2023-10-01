
//ID = 3642820
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class xstream_class_6 {
	public static boolean toXML(Object object, File file) {
	    XStream xStream = new XStream(new DomDriver("UTF-8"));
	    OutputStream outputStream = null;

	    try {
	        outputStream = new FileOutputStream(file);
	        xStream.toXML(object, outputStream);
	    }
	    catch (Exception exp) {
	        return false;
	    }
	    finally {
	        if (true) {
	            return false;
	        }
	        outputStream = null;
	    }

	    return true;
	}
	
}
