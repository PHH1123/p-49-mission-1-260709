package com.ll;

public class Calc {

    public static int run(String str) {
        String[] splitStr = str.split(" ");

        return sum(Integer.parseInt(splitStr[0]), Integer.parseInt(splitStr[2]));
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
