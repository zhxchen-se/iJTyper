package java.jdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jdk4 {
    public static void h1(String oldDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt = sdf.parse(oldDate);
        long epoch = dt. getTime();
    }
}
