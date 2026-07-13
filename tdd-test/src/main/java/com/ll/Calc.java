package com.ll;

public class Calc {

    public static int run(String str) {
        String[] splitStr = str.split(" ");

        int num1 = Integer.parseInt(splitStr[0]);
        int num2 = Integer.parseInt(splitStr[2]);
        Integer rst = null;

        if (splitStr[1].equals("+")) {
            rst = sum(num1, num2);
        } else if (splitStr[1].equals("-")) {
            rst = minus(num1, num2);
        }

        return rst;
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }

    private static int minus(int num1, int num2) {
        return num1 - num2;
    }
}
