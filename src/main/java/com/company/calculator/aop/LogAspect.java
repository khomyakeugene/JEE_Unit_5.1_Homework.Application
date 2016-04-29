package com.company.calculator.aop;

import com.company.util.Util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.ArrayDeque;

/**
 * Created by Yevhen on 26.04.2016.
 */

@Aspect
public class LogAspect {
    private ArrayDeque<Long> startTimeStack = new ArrayDeque<>();
    private long lastMethodExecutionMilliTime;

    @Before("execution (public * com.company.calculator.library..*(..))")
    public void onBefore(JoinPoint joinPoint) throws Throwable {
        startTimeStack.push(Util.getNanoTime());
    }

    @After("execution (public * com.company.calculator.library..*(..))")
    public void onAfter(JoinPoint joinPoint) throws Throwable {
        lastMethodExecutionMilliTime = (Util.getNanoTime() - startTimeStack.pop());
    }

    @AfterReturning(pointcut = "execution (public * com.company.calculator.library..*(..))", returning = "result")
    public void onAfterReturning(JoinPoint joinPoint, Object result) throws Throwable {
        AOPLogger.info(joinPoint, result, lastMethodExecutionMilliTime);
    }
}
