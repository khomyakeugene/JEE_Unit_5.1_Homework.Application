package com.company.calculator;

import com.company.util.Utils;

import java.util.Date;
import java.util.List;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class DateAdditionOperation extends DateOperation implements Operation {
    private Date dateOperand;
    private Integer daysOperand;

    @Override
    public boolean initOperationData(List<String> operandList) {
        boolean result = super.initOperationData(operandList);

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
                daysOperand = firstOperandIntegerRepresentation;
            }
        }

        return result;
    }

    @Override
    protected Date calculate() {
        return  Utils.add(dateOperand, daysOperand);
    }
}
