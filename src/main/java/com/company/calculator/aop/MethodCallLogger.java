package com.company.calculator.aop;

import com.company.util.Util;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import static com.company.util.Util.getApplicationMainClass;

/**
 * Created by Yevhen on 27.04.2016.
 */
public class MethodCallLogger {
    private static final String MESSAGE_PATTERN = "%s.%s";
    private static final String LOG4J_CONFIG_FILENAME = "log4j.properties";

    private static MethodCallLogger instance;
    private static Logger logger;

    private MethodCallLogger() {
    }

    private static void initLogger() {
        logger = Logger.getLogger(getApplicationMainClass());

        // Configure logger from ${resourcePath}/LOG4J_CONFIG_FILENAME file
        System.out.println("initLogger 0");
        PropertyConfigurator.configure(Util.getResourceFilePath(LOG4J_CONFIG_FILENAME));
        System.out.println("initLogger 1");
        PropertyConfigurator.configure(LOG4J_CONFIG_FILENAME);
        System.out.println("initLogger 2");
    }

    public static MethodCallLogger getInstance() {
        if (instance == null) {
            instance = new MethodCallLogger();
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

  //      String s = Util.getApplicationName();

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
