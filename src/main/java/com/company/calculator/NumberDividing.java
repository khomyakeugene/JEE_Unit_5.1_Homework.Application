package com.company.calculator;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class NumberDividing extends NumberOperation  {
    @Override
    protected String calculate() {
        return Double.toString(getDoubleOperand(0) / getDoubleOperand(1));
    }
}
