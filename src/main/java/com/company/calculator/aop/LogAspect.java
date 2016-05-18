package com.company.calculator.aop;

import com.company.util.Util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.HashMap;

/**
 * Created by Yevhen on 26.04.2016.
 */

@Aspect
public class LogAspect {
    private HashMap<String, Long> executionTimeMap = new HashMap<>();

    private String methodFullName(JoinPoint joinPoint) {
        return AOPLogger.methodFullName(joinPoint);
    }

    private Long methodExecutionTime(JoinPoint joinPoint) {
        return executionTimeMap.get(methodFullName(joinPoint));
    }

    @Before("execution (public * com.company.calculator.library..*(..))")
    public void onBefore(JoinPoint joinPoint) throws Throwable {
        // Calculate all temporary data beforehand of <before time> fixing because of needful precision of <before time>
        String methodFullName = methodFullName(joinPoint);
        // Store <before time>
        executionTimeMap.put(methodFullName, Util.getNanoTime());
    }

    @After("execution (public * com.company.calculator.library..*(..))")
    public void onAfter(JoinPoint joinPoint) throws Throwable {
        // Fix <after time> (before of all other calculation)
        Long afterTime = Util.getNanoTime();
        // Get <full method name>
        String methodFullName = methodFullName(joinPoint);
        // Get <before time>
        Long beforeTime = executionTimeMap.get(methodFullName);
        // Store execution time for this method
        if (beforeTime != null) {
            executionTimeMap.put(methodFullName, afterTime - beforeTime);
        }
    }

    @AfterReturning(pointcut = "execution (public * com.company.calculator.library..*(..))", returning = "result")
    public void onAfterReturning(JoinPoint joinPoint, Object result) throws Throwable {
        AOPLogger.info(joinPoint, result, methodExecutionTime(joinPoint));
    }

    @AfterThrowing(pointcut = "execution (public * com.company.calculator.library..*(..))", throwing = "throwable")
    public void onAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        AOPLogger.error(joinPoint, throwable, methodExecutionTime(joinPoint));
    }
}
