package com.scholar.social.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class TimeFormat {
    public static String format(Date time) {
        time = new Date(time.getTime() - 8 * 3600 * 1000L);
        SimpleDateFormat recent = new SimpleDateFormat("MM月dd日 HH:mm");
        SimpleDateFormat past = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar c = Calendar.getInstance();
        Calendar n = new Calendar.Builder().setInstant(time).build();
        if (c.get(Calendar.YEAR) != n.get(Calendar.YEAR)) {
            return past.format(time);
        } else {
            return recent.format(time);
        }
    }
}
