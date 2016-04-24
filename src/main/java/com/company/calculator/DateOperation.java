package com.company.calculator;

import com.company.util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public abstract class DateOperation extends BinaryEmptyOperation implements Operation {
    private static final String[] USEFUL_DATE_PATTERNS = new String[] {
            "yyyy-MM-dd", "dd/MM/yyyy", "dd/MM/yy", "dd.MM.yyyy", "dd.MM.yy", "dd-MM-yyyy", "dd-MM-yy"
    };

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
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
        Date result = null;

        for (String usefulDatePattern : USEFUL_DATE_PATTERNS) {
            simpleDateFormat.applyPattern(usefulDatePattern);
            try {
                result = simpleDateFormat.parse(data);
                if (result != null) {
                    break;
                }
            } catch (ParseException e) {
            }
        }

        return result;
    }

    // Should be overridden in the descendant class
    protected abstract Date calculate();

    @Override
    public final String execute() {
        return simpleDateFormat.format(calculate());
    }
}
