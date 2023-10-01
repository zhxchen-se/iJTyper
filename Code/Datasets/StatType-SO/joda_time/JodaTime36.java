package jodatime;
//ID = 10154428
import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class JodaTime36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PeriodFormatter pf = new PeriodFormatterBuilder().append(ISOPeriodFormat.standard()).toFormatter();

		Period period = pf.parsePeriod("PT01H00M");
	}

}
