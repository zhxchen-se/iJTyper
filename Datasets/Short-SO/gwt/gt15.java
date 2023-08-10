package java.gwt;

import com.google.gwt.user.datepicker.client.CalendarUtil;
import java.util.Date;

public class gt15 {
    public static void h1(){
        final Date dueDate = new Date();
        CalendarUtil.addDaysToDate(dueDate, 21);
    }
}
