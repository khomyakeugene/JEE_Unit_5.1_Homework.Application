package com.company.calculator;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class NumberMultiplication extends BinaryNumberOperation implements Operation {
    @Override
    protected String calculate() {
        return Double.toString(getDoubleOperand(0) * getDoubleOperand(1));
    }
}
