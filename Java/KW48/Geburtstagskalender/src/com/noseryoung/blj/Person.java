package com.noseryoung.blj;

public class Person {
    private int year;
    private int month;
    private int day;
    private String name;
    public Person(int year, int month, int day, String name){
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return name;
    }
}
