package com.company.calculator;

import com.company.util.Utils;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yevhen on 25.04.2016.
 */
public class DateSubtractDateAndDateOperationTest extends DateOperationTest {
    private Date firstOperand;
    private Date secondOperand;

    @BeforeClass
    public static void setUpClass() throws Exception {
        setOperation(new DateSubtractOperation());
    }

    @Override
    protected void initOperands() {
        firstOperand = Util.generateDate();
        secondOperand = Util.generateDate();

        operands.add(new SimpleDateFormat(DATE_PATTERN).format(firstOperand));
        operands.add(new SimpleDateFormat(DATE_PATTERN).format(secondOperand));
    }

    @Override
    protected String expectedResult() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        ((DateOperation)getOperation()).initOperationData(getOperands());

        return Long.toString(Utils.dateSub(firstOperand, secondOperand));
    }
}