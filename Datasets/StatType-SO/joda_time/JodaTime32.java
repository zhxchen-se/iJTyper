package jodatime;

//ID = 9598675
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

public class JodaTime32 {

	public static void main(String[] args) {
		DateTimeFormatter dtf = null;
		// TODO Auto-generated method stub
		final DateTime date1 = dtf.parseDateTime("1979-04-29");
		final DateTime date2 = dtf.parseDateTime("1979-05-12");
		final DateTime date3 = dtf.parseDateTime("1979-04-02");
		final DateTime date4 = dtf.parseDateTime("1979-04-15");
		System.err.println(date1.toString());
		System.err.println(date2.toString());
		System.err.println(date3.toString());
		System.err.println(date4.toString());
	}

}
