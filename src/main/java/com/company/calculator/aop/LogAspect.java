package com.company.calculator.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Yevhen on 26.04.2016.
 */

@Aspect
public class LogAspect {
    @Before("execution (public * com.company.calculator.library..*(..))")
    public void onExecute(JoinPoint joinPoint) throws Throwable {
        System.out.println("LogAspect: Start of Before execution of: " + System.getProperty("program.name"));
    }
}
