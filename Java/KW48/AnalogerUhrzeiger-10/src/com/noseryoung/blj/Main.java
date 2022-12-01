package com.noseryoung.blj;

public class Main {
    public static int computeHourHandAngle(int h, int m){
        double calculate = 0.5 * ( 60 * h + m);
        int result = (int)calculate;
        return result;
    }
    public static int computeMinuteHandAngle(int m){
        double calculate = 6 * m;
        int result = (int)calculate;
        return result;
    }
    public static void main(String[] args) {
        int hour = 11;
        int minute = 15;

        int resultHour = computeHourHandAngle(hour, minute);
        System.out.println(resultHour + "°");

        int resultMin = computeMinuteHandAngle(minute);
        System.out.println(resultMin + "°");

    }

}
