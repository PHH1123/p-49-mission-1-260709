package com.ll;

public class Calc {

    public static int run(String str) {
        String[] splitStr = str.split(" ");

        Integer rst = null;

        for (int i=0; i < splitStr.length-2;i+=2) {
            int num1 = Integer.parseInt(splitStr[i]);
            int num2 = Integer.parseInt(splitStr[i+2]);

            if (splitStr[i+1].equals("+")) {
                rst = sum(num1, num2);
            } else if (splitStr[i+1].equals("-")) {
                rst = minus(num1, num2);
            }
            splitStr[i+2] = String.valueOf(rst);
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
