package com.company.calculator;

import com.company.util.Utils;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yevhen on 25.04.2016.
 */
public class DateSubtractDateAndIntegerOperationTest extends DateOperationTest {
    private Date firstOperand;
    private Integer secondOperand;

    @BeforeClass
    public static void setUpClass() throws Exception {
        setOperation(new DateSubtractOperation());
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

        return simpleDateFormat.format(Utils.dateAdd(firstOperand, -secondOperand));
    }
}