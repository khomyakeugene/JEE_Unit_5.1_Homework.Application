package com.company.calculator;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class SquareRoot extends UnaryNumberOperation implements Operation {
    @Override
    protected String calculate() {
        return Double.toString(Math.sqrt(getDoubleOperand(0)));
    }
}
