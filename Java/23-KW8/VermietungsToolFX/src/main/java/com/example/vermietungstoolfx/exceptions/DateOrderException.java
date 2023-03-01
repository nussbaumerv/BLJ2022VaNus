package com.example.vermietungstoolfx.exceptions;

public class DateOrderException
        extends Exception {
    public DateOrderException() {
        super("Enddate is before Startdate");
    }
}