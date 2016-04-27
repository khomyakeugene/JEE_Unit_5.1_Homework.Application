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
        Logger logger = Logger.getLogger(getApplicationMainClass());

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

        return String.format(MESSAGE_PATTERN, signature.getDeclaringTypeName(),
                signature.getName());
   }

    // printing methods:
    public void trace(JoinPoint joinPoint) {
        getLogger().trace(logMessage(joinPoint));
    }


    public void debug(JoinPoint joinPoint) {
        getLogger().debug(logMessage(joinPoint));
    }

    public void info(JoinPoint joinPoint) {
        getLogger().info(logMessage(joinPoint));
    }

    public void warn(JoinPoint joinPoint) {
        getLogger().warn(logMessage(joinPoint));
    }

    public void error(JoinPoint joinPoint) {
        getLogger().error(logMessage(joinPoint));
    }

    public void fatal(JoinPoint joinPoint) {
        getLogger().fatal(logMessage(joinPoint));
    }

    // generic printing method
    public void log(Level l, JoinPoint joinPoint) {
        getLogger().log(l, logMessage(joinPoint));
    }
}
