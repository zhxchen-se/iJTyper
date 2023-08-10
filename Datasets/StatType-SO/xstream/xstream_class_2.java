
//ID = 7491195
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class xstream_class_2 {
	public static  void main(String arg[]) throws IOException{
		XStream xstream = new XStream(new DomDriver()); 
		FileReader fin = new FileReader("path_to_file.xml"); 
		BufferedReader br = new BufferedReader(fin); 

		String str = null;
		while(br.ready())
		{ 
		  str += br.readLine() + "\n"; 
		} 

	}
}
