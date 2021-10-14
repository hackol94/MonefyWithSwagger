package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateIso8601 {
    public static String fromCalendar(final Calendar calendar) {
        Date date = calendar.getTime();
        String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .format(date);
        return formatted.substring(0, 22) + ":" + formatted.substring(22);
    }

    public static String now() {
        return fromCalendar(GregorianCalendar.getInstance());
    }
}
