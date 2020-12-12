package com.scholar.social.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class TimeFormat {
    public String format(long time) {
        SimpleDateFormat recent = new SimpleDateFormat("MM月dd日 HH:mm");
        SimpleDateFormat past = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(time);
        Calendar c = Calendar.getInstance();
        Calendar n = new Calendar.Builder().setInstant(date).build();
        if (c.get(Calendar.YEAR) != n.get(Calendar.YEAR)) {
            return past.format(date);
        } else {
            return recent.format(date);
        }
    }
}
