package com.ll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calc {

    static int pos = 0;

    public static int run(String str) {
        List<String> strList = Arrays.stream(str.split(" ")).collect(Collectors.toList());

        Integer rst = null;

        rst = cal(strList);
        pos = 0;

        return rst;
    }

    private static int cal(List<String> strList) {
        int num = mul(strList);

        while (pos < strList.size() && ((strList.get(pos).equals("+") || strList.get(pos).equals("-")))) {
            String oper = strList.get(pos++);
            System.out.println("pos = " + pos);
            int next = mul(strList);
            if (oper.equals("+")) {
                num = sum(num, next);
            } else if (oper.equals("-")) {
                num = minus(num, next);
            }

        }
        return num;
    }

    private static int mul(List<String> strList) {
        int num = Integer.parseInt(strList.get(pos++));
        while (pos < strList.size() && strList.get(pos).equals("*")) {
            pos++;
            int next = Integer.parseInt(strList.get(pos++));
            num = mul(num, next);
        }
        return num;
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }

    private static int minus(int num1, int num2) {
        return num1 - num2;
    }

    private static int mul(int num1, int num2) {
        return num1 * num2;
    }
}
