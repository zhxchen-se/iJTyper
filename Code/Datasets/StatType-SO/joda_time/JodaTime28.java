package jodatime;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

//ID = 9313151
public class JodaTime28 {
	public static void main(String[] args) {
			DateTimeFormatter dateFromatter= DateTimeFormat.forPattern("MM/dd/yyyy");

			DateTime startDate= dateFromatter.parseDateTime("01/02/2012");
			DateTime endDate= dateFromatter.parseDateTime("01/31/2012");

			 List<LocalDate> dates = new ArrayList<LocalDate>();


			  int days = Days.daysBetween(startDate, endDate).getDays();
	}
}
