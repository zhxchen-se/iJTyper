package jodatime;

import java.util.Date;

import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.ReadableInstant;

//ID = 7471775
public class JodaTime19 
{
	public static void main(String[] args) {
			Instant now = new Instant(new Date().getTime());
			Interval i2 = new Interval(now, (ReadableInstant) null);
			Interval i1 = new Interval(now, (ReadableInstant) null);
			boolean overlapping = i2.overlaps(i1);
	}
}
