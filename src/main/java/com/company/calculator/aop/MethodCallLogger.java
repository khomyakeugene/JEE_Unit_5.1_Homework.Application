package com.company.calculator.aop;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static com.company.util.Util.getApplicationMainClass;

/**
 * Created by Yevhen on 27.04.2016.
 */
public class MethodCallLogger {
    private static final String MESSAGE_PATTERN = "%s.%s";

    private static Logger logger;

    private MethodCallLogger() {
    }

    private static void initLogger() {
        logger = Logger.getLogger(getApplicationMainClass());
    }

    public static Logger getLogger() {
        if (logger == null) {
            initLogger();
        }

        return logger;
    }

    public static String logMessage(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        String fullMethodName = String.format(MESSAGE_PATTERN, signature.getDeclaringTypeName(),
                signature.getName());

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();

        for(Object argument : joinPoint.getArgs()) {
            //I can get the parameter values here
            System.out.println("Argument: " + argument);
        }

        try {
            Method declaredMethod = joinPoint.getTarget().getClass()
                    .getDeclaredMethod(methodName, parameterTypes);
            method = declaredMethod;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println("annotations[i] :" + annotations[i]);
            for (int j = 0; j < annotations[i].length; j++) {
                System.out.println("annotations[i][j] :" + annotations[i][j]);
            }
        }


        return fullMethodName;
    }

    // printing methods:
    public static void trace(JoinPoint joinPoint) {
        getLogger().trace(logMessage(joinPoint));
    }

    public static void debug(JoinPoint joinPoint) {
        getLogger().debug(logMessage(joinPoint));
    }

    public static void info(JoinPoint joinPoint) {
        getLogger().info(logMessage(joinPoint));
    }

    public static void warn(JoinPoint joinPoint) {
        getLogger().warn(logMessage(joinPoint));
    }

    public static void error(JoinPoint joinPoint) {
        getLogger().error(logMessage(joinPoint));
    }

    public static void fatal(JoinPoint joinPoint) {
        getLogger().fatal(logMessage(joinPoint));
    }

    // generic printing method
    public static void log(Level l, JoinPoint joinPoint) {
        getLogger().log(l, logMessage(joinPoint));
    }
}
