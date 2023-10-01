package java.gwt;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class gt9 {
    public String format(Date date)
    {
        return DateTimeFormat.getFormat("yyyyMMdd").format(date);
    }
}
