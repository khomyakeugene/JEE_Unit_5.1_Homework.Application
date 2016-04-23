package com.company.calculator;

import com.company.utils.Utils;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class CalculatorLauncher {
    private static final String PROMPT_MESSAGE = "Please, enter a formula:";

    public void interactiveCalculation() {
        String expression;

        do {
            expression = Utils.readInputString(PROMPT_MESSAGE);

        } while (!expression.isEmpty());
    }
}
