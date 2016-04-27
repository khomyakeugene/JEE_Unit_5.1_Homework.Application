package com.company;

import com.company.calculator.AppConfig;
import com.company.calculator.CalculatorLauncher;
import com.company.calculator.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
    private final static String CALCULATOR_BEAN_NAME = "simpleCalculator";

    @Autowired
    private SimpleCalculator sc;

    public static void main(String[] args) {
        new CalculatorLauncher().interactiveCalculation(
                new AnnotationConfigApplicationContext(AppConfig.class).
                        getBean(CALCULATOR_BEAN_NAME, SimpleCalculator.class));
    }
}