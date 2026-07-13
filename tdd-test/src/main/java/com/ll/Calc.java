package com.ll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calc {

    static int pos = 0;

    public static int run(String str) {
        str = str.replace("(", " ( ").replace(")", " ) ");
        List<String> strList = Arrays.stream(str.split(" "))
                .filter(s -> !s.isEmpty()).collect(Collectors.toList());

        pos = 0;

        return cal(strList);
    }

    private static int parent(List<String> strList) {
        if (strList.get(pos).equals("-")) {
            pos++;
            return -parent(strList);
        }

        if (strList.get(pos).equals("(")) {
            pos++;
            int num = cal(strList);
            pos++;
            return num;
        }

        return Integer.parseInt(strList.get(pos++));
    }

    private static int cal(List<String> strList) {
        int num = mul(strList);

        while (pos < strList.size() && (strList.get(pos).equals("+") || strList.get(pos).equals("-"))) {
            String oper = strList.get(pos++);

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
        int num = parent(strList);

        while (pos < strList.size() && strList.get(pos).equals("*")) {
            pos++;
            int next = parent(strList);
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
