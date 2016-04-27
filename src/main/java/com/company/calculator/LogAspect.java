package com.company.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Yevhen on 26.04.2016.
 */

@Aspect
public class LogAspect {
    @Around("execution ( * SimpleCalculator.execute(..))")
    public String onExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogAspect: Around execution of: ");

        return (String)pjp.proceed();
    }
}
