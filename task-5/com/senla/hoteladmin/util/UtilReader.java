package com.senla.hoteladmin.util;

import java.util.Scanner;

public class UtilReader {
    private Scanner scanner = new Scanner(System.in);

    public int readInt() {
        int readNum = scanner.nextInt();
        scanner.nextLine();
        return readNum;
    }

    public String readLine() {
        String readStr = scanner.nextLine();
        return readStr;
    }

    public Long readLong() {
        Long readLong = scanner.nextLong();
        scanner.nextLine();
        return readLong;
    }
}
