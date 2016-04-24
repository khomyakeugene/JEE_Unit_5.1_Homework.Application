package com.company.calculator;

import com.company.util.DateCalculator;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class DateAdditionOperationTest extends OperationTest {
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    private Date firstOperand;
    private Integer secondOperand;

    @BeforeClass
    public static void setUpClass() throws Exception {
        setOperation(new DateAdditionOperation());
    }

    @Override
    protected void initOperands() {
        firstOperand = Util.generateDate();
        secondOperand = Util.getRandomInteger();

        operands.add(new SimpleDateFormat(DATE_PATTERN).format(firstOperand));
        operands.add(secondOperand.toString());
    }

    @Override
    protected String expectedResult() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        ((DateOperation)getOperation()).initOperationData(getOperands());

        return simpleDateFormat.format(DateCalculator.add(firstOperand, secondOperand));
    }
}