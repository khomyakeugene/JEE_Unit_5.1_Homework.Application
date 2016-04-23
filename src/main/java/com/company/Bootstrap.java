package com.company;

import com.company.calculator.AppConfig;
import com.company.calculator.CalculatorLauncher;
import com.company.calculator.SimpleCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
    private final static String CALCULATOR_BEAN_NAME = "simpleCalculator";

    public static void main(String[] args) {
        new CalculatorLauncher().interactiveCalculation(
                new AnnotationConfigApplicationContext(AppConfig.class).
                        getBean(CALCULATOR_BEAN_NAME, SimpleCalculator.class));
    }
}