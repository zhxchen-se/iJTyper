package jodatime;
//ID = 4034388
import java.util.concurrent.TimeUnit;

import org.joda.time.Period;
import org.joda.time.PeriodType;

public class JodaTime08 {
	 public boolean testIfJodaTimePeriodsHandlesPeriodTypesOtherThanMinutesAndHours() {
		  long twentyDaysInMillis = TimeUnit.MILLISECONDS.convert(20, TimeUnit.DAYS);
		  Period twoWeeks = new Period(twentyDaysInMillis, PeriodType.weeks());
		  return (2 == twoWeeks.getWeeks()) ? true : false; 
		 }
}
