package com.company.calculator;

import com.company.utils.Utils;

import java.util.Arrays;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class CalculatorLauncher {
    private static final String PROMPT_MESSAGE = "You can execute the following operations: %s. Please, enter a formula (or press only <Enter> to stop):";
    private static final String FAREWELL_MESSAGE = "Thank you for use our calculator";
    private static final String RESULT_PATTERN = "%s = %s";

    public void interactiveCalculation(SimpleCalculator simpleCalculator) {
        String expression;

        do {
            expression = Utils.readInputString(String.format(PROMPT_MESSAGE,
                    Arrays.toString(simpleCalculator.operationCodeList())));
            if (!expression.isEmpty()) {
                try {
                    Utils.printMessage(String.format(RESULT_PATTERN, expression, simpleCalculator.execute(expression)));
                } catch (IllegalArgumentException e) {
                    Utils.printMessage(e.getMessage());
                }
            }
        } while (!expression.isEmpty());

        Utils.printMessage(FAREWELL_MESSAGE);
    }
}
