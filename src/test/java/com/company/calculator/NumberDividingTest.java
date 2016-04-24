package com.company.calculator;

import org.junit.BeforeClass;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class NumberDividingTest  extends NumberTest {
    @BeforeClass
    public static void setUpClass() throws Exception {
        setOperation(new NumberDividingOperation());
    }

    @Override
    protected double calcExpected(double operand_1, double operand_2) {
        return operand_1 / operand_2;
    }
}