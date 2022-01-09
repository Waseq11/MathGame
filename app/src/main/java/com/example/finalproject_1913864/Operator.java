package com.example.finalproject_1913864;

public enum Operator {
    addition("+"), subtraction("-"), multiplication("*"), division("/");
    private String displayOperation;

    private Operator(String displayOperation) {
        this.displayOperation = displayOperation;
    }

    public String getDisplayOperation() {
        return displayOperation;
    }
}
