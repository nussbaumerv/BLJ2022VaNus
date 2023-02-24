package com.example.vermietungstoolfx.exceptions;

public class MinorAgeException
        extends Exception {
    public MinorAgeException() {
        super("Invalid Age");
    }
}