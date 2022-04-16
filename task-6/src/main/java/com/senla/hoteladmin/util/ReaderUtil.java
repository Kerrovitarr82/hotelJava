package com.senla.hoteladmin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ReaderUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        int readNum = scanner.nextInt();
        scanner.nextLine();
        return readNum;
    }

    public static String readLine() {
        String readStr = scanner.nextLine();
        return readStr;
    }

    public static Long readLong() {
        Long readLong = scanner.nextLong();
        scanner.nextLine();
        return readLong;
    }

    public static Calendar dateReadInDdMmYyyyFormat() throws ParseException {
        String str = ReaderUtil.readLine();
        Calendar calendar = DateParserUtil.dateParseInDdMmYyyyFormat(str);
        return calendar;
    }
}
