package com.example.vermietungstoolfx.exceptions;

public class LeaseLengthCollisionException
        extends Exception {
    public LeaseLengthCollisionException() {
        super("Date already booked");
    }
}