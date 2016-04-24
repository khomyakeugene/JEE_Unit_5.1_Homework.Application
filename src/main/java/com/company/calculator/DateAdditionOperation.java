package com.company.calculator;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class DateAdditionOperation extends DateOperation implements Operation {
    private Date dateOperand;
    private Integer daysOperand;

    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        boolean result = super.isThisOperation(inputExpression, parseResult);

        if (result) {
            // It is possible only to add Date and Integer(days count)
            // Also initialize <dateOperand> and <daysOperand> using further in the method <execute>
            if (firstOperandDateRepresentation != null) {
                result = secondOperandIntegerRepresentation != null;
                if (result) {
                    dateOperand = firstOperandDateRepresentation;
                    daysOperand = secondOperandIntegerRepresentation;
                }
            } else {
                // In this case it is guaranteed by <super.isThisOperation> that <secondOperandDateRepresentation>
                // and <secondOperandIntegerRepresentation> are correctly initialized
                dateOperand = secondOperandDateRepresentation;
                daysOperand = secondOperandIntegerRepresentation;
            }
        }

        return result;
    }

    @Override
    protected Date calculate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOperand);
        calendar.add(Calendar.DATE, daysOperand);

        return calendar.getTime();
    }
}
