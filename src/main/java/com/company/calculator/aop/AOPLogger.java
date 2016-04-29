package com.company.calculator.aop;

import com.company.util.Util;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * Created by Yevhen on 27.04.2016.
 */
public class AOPLogger {
    private static final String MESSAGE_EXECUTION_NANO_TIME_PATTERN = "%s (execution time: %d micro seconds)";
    private static Logger logger;

    private static void initLogger() {
        logger = Logger.getLogger(Util.getApplicationMainClass());
    }

    public static Logger getLogger() {
        if (logger == null) {
            initLogger();
        }

        return logger;
    }

    public static String methodFullName(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        return String.format("%s.%s", signature.getDeclaringTypeName(),
                signature.getName());
    }

    public static String methodParameters(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();

        String result = "";
        for (int i = 0; i < parameterNames.length; i++) {
            if (result.length() > 0) {
                result = result + ", ";
            }
            result = String.format("%s%s = %s", result, parameterNames[i], parameterValues[i]);
        }

        return result;
    }

    public static String methodResultRepresentation(JoinPoint joinPoint, Object methodResult) {
        String result = null;

        Class returnType = ((MethodSignature)joinPoint.getSignature()).getReturnType();
        if (returnType != Void.TYPE) {
            // Partly convert some types "toString"
            if (returnType.isArray()) {
                result = Arrays.toString((Object[]) methodResult);
            } else {
                // All "another" types
                result = methodResult.toString();
            }
        }

        return result;
    }

    public static String logMessage(JoinPoint joinPoint) {
        return String.format("%s(%s)", methodFullName(joinPoint), methodParameters(joinPoint));
    }

    public static String logMessage(JoinPoint joinPoint, Object result) {
        return (result == null) ? logMessage(joinPoint) :
                String.format("%s = %s", logMessage(joinPoint), methodResultRepresentation(joinPoint, result));
    }

    public static String logMessage(JoinPoint joinPoint, Object result, long executionNanoTime) {
        return String.format(MESSAGE_EXECUTION_NANO_TIME_PATTERN, logMessage(joinPoint, result),
                Util.nanoToMilliTime(executionNanoTime));
    }

    public static String logMessage(JoinPoint joinPoint, long executionNanoTime) {
        return String.format(MESSAGE_EXECUTION_NANO_TIME_PATTERN, logMessage(joinPoint),
                Util.nanoToMilliTime(executionNanoTime));
    }

    // printing methods:
    public static void info(JoinPoint joinPoint, Object result, long executionNanoTime) {
        getLogger().info(logMessage(joinPoint, result, executionNanoTime));
    }

    public static void error(JoinPoint joinPoint, Throwable throwable, long executionNanoTime) {
        getLogger().error(logMessage(joinPoint, executionNanoTime), throwable);
    }
}
