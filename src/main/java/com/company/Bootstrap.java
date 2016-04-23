package com.company;

import com.company.calculator.CalculatorLauncher;
import com.company.calculator.SimpleCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        SimpleCalculator simpleCalculator = applicationContext.getBean("simpleCalculator", SimpleCalculator.class);

        new CalculatorLauncher().interactiveCalculation(simpleCalculator);
    }
}