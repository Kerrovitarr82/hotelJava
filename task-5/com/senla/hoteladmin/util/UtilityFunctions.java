package com.senla.hoteladmin.util;

import java.util.Collection;

public class UtilityFunctions {
    public static void printFunc(Collection collection) {
        for (Object item : collection) {
            System.out.println(item);
        }
    }
}
