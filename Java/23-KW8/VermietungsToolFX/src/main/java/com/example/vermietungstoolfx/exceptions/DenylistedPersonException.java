package com.example.vermietungstoolfx.exceptions;

public class DenylistedPersonException
        extends Exception {
    public DenylistedPersonException() {
        super("Deny listed");
    }
}