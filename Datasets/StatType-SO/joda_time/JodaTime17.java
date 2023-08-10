package jodatime;
//ID = 6922964
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTime17 {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss.SSS z");

	    String dts = dtf.print(System.currentTimeMillis());

	    System.out.println(dts);

	    DateTime dt = dtf.parseDateTime(dts);

	}

}
