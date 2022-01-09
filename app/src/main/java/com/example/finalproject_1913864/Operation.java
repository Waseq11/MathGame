package com.example.finalproject_1913864;

import java.util.Random;

public class Operation {

    private int leftVal;
    private int rightVal;
    private Operator operator;
    private final Random randomGenerator = new Random();
    private static final int MIN_OPERATION_ELEMENT_VALUE = 1;
    private static final int MAX_OPERATION_ELEMENT_VALUE = 100;

    public Operation() {
        this.leftVal = getRandomIntegerInRange(MIN_OPERATION_ELEMENT_VALUE, MAX_OPERATION_ELEMENT_VALUE);
        this.operator = Operator.values()[randomGenerator.nextInt(Operator.values().length)];
        this.rightVal = getRandomIntegerInRange(MIN_OPERATION_ELEMENT_VALUE, MAX_OPERATION_ELEMENT_VALUE);
    }

    public int getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(int value) {
        this.leftVal = value;
    }

    public int getRightVal() {
        return rightVal;
    }

    public void setRightVal(int value) {
        this.rightVal = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getOperatorDisplayValue() {
        return operator.getDisplayOperation();
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    private int getRandomIntegerInRange(int min, int max) {
        return randomGenerator.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        return getLeftVal() + (operator == null ? "" : " " + getOperatorDisplayValue()) + " " + getRightVal();
    }
}
