package com.shop.marketplace.exception;

public class CustomConflictException extends Exception {
    private String conflict;

    public CustomConflictException(Conflict conflict) {
        super(conflict.toString());
        this.conflict = conflict.toString();
    }

    public String getErrorMessage() {
        return conflict;
    }
}
