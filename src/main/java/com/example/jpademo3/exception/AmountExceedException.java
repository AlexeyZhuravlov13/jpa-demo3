package com.example.jpademo3.exception;

public class AmountExceedException extends RuntimeException {
    public AmountExceedException(String s) {
        super(s);
    }
}
