package jodatime;
//5451152
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

public class JodaTime15 {
	public static void main(String[] args) 
	{
		MutableDateTime now = new MutableDateTime();
		now.setHourOfDay(2);
		now.setMinuteOfHour(0);
		now.setSecondOfMinute(0);
		now.setMillisOfSecond(0);
		DateTime myDate = now.toDateTime();
	}
}
