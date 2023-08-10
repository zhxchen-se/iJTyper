package java.joda_time;


import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;

public class jt2 {
   public static void f1(){
       Date past = new Date(110, 5, 20); // June 20th, 2010
       Date today = new Date(110, 6, 24); // July 24th
       int days = Days.daysBetween(new DateTime(past), new DateTime(today)).getDays(); // => 34
   }

}
