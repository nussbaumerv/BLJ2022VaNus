package com.noseryoung.blj;

public class Main {
    public static boolean CheckLeapYear(int year) {
        boolean result = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    result = true;
                else
                    result = false;
            } else
                result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        int year = 2012;
        boolean result = CheckLeapYear(year);
        System.out.println(result);

    }
}
