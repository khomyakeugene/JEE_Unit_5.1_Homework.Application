package com.company.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yevhen on 23.04.2016.
 */

@Configuration
public class AppConfig {
    private static final String MULTIPLICATION_OPERATION_CODE = "*";
    private static final String DIVIDING_OPERATION_CODE = "/";
    private static final String SQUARE_ROOT_CODE = "sqrt";
    private static final String LOG10_CODE = "log10";
    private static final String LOG_CODE = "log";
    private static final String INCREMENT_CODE = "++";
    private static final String DECREMENT_CODE = "--";
    private static final String FACTORIAL_CODE = "!";

    @Bean
    public SimpleCalculator simpleCalculator () {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        simpleCalculator.addOperation(MULTIPLICATION_OPERATION_CODE, new NumberMultiplication());
        simpleCalculator.addOperation(DIVIDING_OPERATION_CODE, new NumberDividing());
        simpleCalculator.addOperation(SQUARE_ROOT_CODE, new SquareRoot());
        simpleCalculator.addOperation(LOG10_CODE, new Log10Operation());
        simpleCalculator.addOperation(LOG_CODE, new LogOperation());
        simpleCalculator.addOperation(INCREMENT_CODE, new IncrementOperation());
        simpleCalculator.addOperation(DECREMENT_CODE, new DecrementOperation());
        simpleCalculator.addOperation(FACTORIAL_CODE, new FactorialOperation());

        return simpleCalculator;
    }
}


