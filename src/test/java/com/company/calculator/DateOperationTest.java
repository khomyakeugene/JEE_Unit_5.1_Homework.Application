package com.company.calculator;

import java.text.SimpleDateFormat;

/**
 * Created by Yevhen on 25.04.2016.
 */
public abstract class DateOperationTest extends OperationTest {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    protected final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
}
