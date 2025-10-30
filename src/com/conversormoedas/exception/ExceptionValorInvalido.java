package com.conversormoedas.exception;

public class ExceptionValorInvalido extends RuntimeException {
    private final String message;

    public ExceptionValorInvalido(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
