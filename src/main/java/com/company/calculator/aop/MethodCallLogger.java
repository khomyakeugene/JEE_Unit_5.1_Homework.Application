package com.company.calculator.aop;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import static com.company.util.Util.getApplicationMainClass;


/**
 * Created by Yevhen on 27.04.2016.
 */
public class MethodCallLogger {
    private static final String MESSAGE_PATTERN = "%s.%s";

    private static MethodCallLogger instance;
    private static Logger logger;

    private MethodCallLogger() {
    }

    private static void initLogger() {
        logger = Logger.getLogger(getApplicationMainClass());

        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();
    }

    public static MethodCallLogger getInstance() {
        if (instance == null) {
            instance = new MethodCallLogger();
            initLogger();
        }

        return instance;
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
        String message = logMessage(joinPoint);

        getLogger().info(message);
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
