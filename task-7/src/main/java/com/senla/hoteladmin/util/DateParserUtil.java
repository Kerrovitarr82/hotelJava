package com.senla.hoteladmin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateParserUtil {
    public static Calendar dateParseInDdMmYyyyFormat(String str) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        calendar.setTime(sdf.parse(str));
        return calendar;
    }
}
