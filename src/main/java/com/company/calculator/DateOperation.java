package com.company.calculator;

import com.company.util.Utils;

import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public abstract class DateOperation extends BinaryEmptyOperation implements Operation {
    protected Date firstOperandDateRepresentation;
    protected Date secondOperandDateRepresentation;
    protected Integer firstOperandIntegerRepresentation;
    protected Integer secondOperandIntegerRepresentation;

    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        // Check that there are only two operands
        boolean result = super.isThisOperation(inputExpression, parseResult);

        if (result) {
            // Try to recognise date-signature in the operands
            String firstOperand = parseResult.operandList().get(0);
            String secondOperand = parseResult.operandList().get(1);

            firstOperandDateRepresentation = convertToDate(firstOperand);
            secondOperandDateRepresentation = convertToDate(secondOperand);
            result = (firstOperandDateRepresentation != null) || (secondOperandDateRepresentation  != null);
            if (result) {
                // One of the operands can be Integer
                if (firstOperandDateRepresentation == null) {
                    // Try to recognize first operand as Integer
                    firstOperandIntegerRepresentation = Utils.parseInt(firstOperand);
                    // Only Integer could be one of the not-date operands in date-operation
                    result = firstOperandIntegerRepresentation != null;
                }
                if (secondOperandDateRepresentation == null) {
                    // Try to recognize second operand as Integer
                    secondOperandIntegerRepresentation = Utils.parseInt(secondOperand);
                    // Only Integer could be one of the not-date operands in date-operation
                    result = secondOperandIntegerRepresentation != null;
                }
            }
        }

        return result;
    }

    protected Date convertToDate(String data) {
        return null;
    }
}
