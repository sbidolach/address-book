package com.gumtree.book.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    private final static  String DATE_FORMAT = "dd/MM/yy";

    public static Date parseDateString(String stringDate) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(stringDate);
        } catch (Exception ex) {
            return null;
        }
    }

    public static long caculateDaysBetweenTwoDates(Date d1, Date d2) {
        long diff = d1.getTime() - d2.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}
