package com.company.calculator.launcher;

import com.company.calculator.library.Operation;
import com.company.calculator.library.UnaryNumberOperation;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class SquareRootOperation extends UnaryNumberOperation implements Operation {
    @Override
    protected String calculate() {
        return Double.toString(Math.sqrt(getDoubleOperand(0)));
    }
}
