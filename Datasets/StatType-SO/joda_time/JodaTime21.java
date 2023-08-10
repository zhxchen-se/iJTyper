package jodatime;
//ID = 7868105
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

public class JodaTime21 {
	public static void main(String[] args) {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date dt = null;
	try {
		dt = formatter.parse("2011-10-23 12:00:00");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LocalDateTime ldt = new DateTime(dt).withZone(DateTimeZone.UTC).toLocalDateTime();
	System.out.println("Original date: " + ldt.toDateTime().toDate().toString());
	DateTime cvtldt = ldt.toDateTime(DateTimeZone.forID("-05:00"));
	System.out.println("Converted date: " + cvtldt.toLocalDateTime().toDateTime().toDate().toString());
}
}