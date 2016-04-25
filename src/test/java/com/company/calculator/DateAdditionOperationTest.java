package com.company.calculator;

import com.company.util.Util;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class DateAdditionOperationTest extends DateOperationTest {
    private Date firstOperand;
    private Integer secondOperand;

    @BeforeClass
    public static void setUpClass() throws Exception {
        setOperation(new DateAdditionOperation());
    }

    @Override
    protected void initOperands() {
        firstOperand = com.company.calculator.Util.generateDate();
        secondOperand = com.company.calculator.Util.getRandomInteger();

        operands.add(new SimpleDateFormat(DATE_PATTERN).format(firstOperand));
        operands.add(secondOperand.toString());
    }

    @Override
    protected String expectedResult() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        ((DateOperation)getOperation()).initOperationData(getOperands());

        return simpleDateFormat.format(Util.dateAdd(firstOperand, secondOperand));
    }
}