package jodatime;
//ID = 9503771
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JodaTime30 {

	public static void main(String[] args) {
		DateTimeZone dtz = DateTimeZone.forOffsetHours(0);

		DateTime dt = new DateTime(dtz);

		System.out.println(dt);
		System.out.println(dt.toDate());

	}

}
