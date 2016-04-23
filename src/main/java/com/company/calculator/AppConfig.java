package com.company.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yevhen on 23.04.2016.
 */

@Configuration
public class AppConfig {
    @Bean
    public SimpleCalculator simpleCalculator () {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        return simpleCalculator;
    }
}


