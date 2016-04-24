package com.company.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class DateCalculator {
    public static Date add(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }
}
