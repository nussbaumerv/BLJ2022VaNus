package com.noseryoung.blj;

public class Main {
    public static String CheckWeekDay(int day, int month, int year) {
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
        String WeekDay = "Montag";
        return WeekDay;
    }

    public static void main(String[] args) {
        int day = 2;
        int month = 4;
        int year = 2012;
        String result = CheckWeekDay(day, month, year);
        System.out.println(result);

    }
}

