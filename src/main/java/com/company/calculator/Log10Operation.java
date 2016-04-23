package com.company.calculator;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class Log10Operation extends UnaryNumberOperation implements Operation {
    @Override
    protected String calculate() {
        return Double.toString(Math.log10(getDoubleOperand(0)));
    }
}