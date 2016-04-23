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

    @Bean
    public SimpleCalculator simpleCalculator () {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        simpleCalculator.addOperation(MULTIPLICATION_OPERATION_CODE, new NumberMultiplication());
        simpleCalculator.addOperation(DIVIDING_OPERATION_CODE, new NumberDividing());
        simpleCalculator.addOperation(SQUARE_ROOT_CODE, new SquareRoot());

        return simpleCalculator;
    }
}


