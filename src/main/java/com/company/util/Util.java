package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by Yevgen on 06.01.2016.
 */

public class Util {
    private final static String PLEASE_REPEAT_ENTER =
            "%s was generated with data \"%s\". Please, repeat enter action";

    private static void printLine(String message) {
        System.out.print(message);
    }

    public static void printMessage(String message) {
        printLine(message + "\n");
    }

    public static String readInputString(String enterMessageInvitation) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        printMessage(enterMessageInvitation);

        do {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                printMessage(String.format(PLEASE_REPEAT_ENTER, e.getClass().getName(), e.getMessage()));
            }
        } while (true);
    }

    public static Integer parseInt(String data) {
        Integer result;

        try {
            result = Integer.parseInt(data);

        } catch (NullPointerException | NumberFormatException e) {
            result = null;
        }

        return result;
    }

    public static LocalDate DateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        return zonedDateTime.toLocalDate();
    }

    public static Date dateAdd(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }

    public static long dateSub(Date date1, Date date2) {
        return DateToLocalDate(date2).until(DateToLocalDate(date1), DAYS);
    }

    public static String getApplicationMainClassName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];

        return main.getClassName();
    }

    public static Class getApplicationMainClass() {
        Class result;

        try {
            result = Class.forName(getApplicationMainClassName());
        } catch (ClassNotFoundException e) {
            // Unfortunately, try to get it from stack directly
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            StackTraceElement main = stack[stack.length - 1];
            result = main.getClass();
        }

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        result = main.getClass();


        return result;
    }


    public static String getResourceFilePath(String fileName) {
        URL url = Util.class.getClassLoader().getResource(fileName);

        System.out.println("URL: " + url);
        try {
            System.out.println("URI: " + url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return (url != null) ? url.getPath() : null;
    }

    public static String getApplicationPath() {
        Class mainClass = getApplicationMainClass();

        ProtectionDomain protectionDomain = mainClass.getProtectionDomain();
        System.out.println("protectionDomain: " + protectionDomain);
        if (protectionDomain != null) {
            CodeSource codeSource = protectionDomain.getCodeSource();
            if (codeSource != null) {
                URL url = codeSource.getLocation();
                System.out.println("protectionDomain.codeSource.getLocation(): " + url);
            }
        }

        //String s = mainClass.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("BBBB");
/*
        System.getProperties().stringPropertyNames().forEach(s -> {
            System.out.println(s + " : " + System.getProperties().getProperty(s));

        });
*/
        return "mmm";
    }

    public static String getApplicationName() {
        // Tempro
        // return  Util.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        System.out.println(getApplicationPath());
/*
        Class mainClass = getApplicationMainClass();

        String path = mainClass.getResource(mainClass.getSimpleName() + ".class").getFile();
        URL uu = ClassLoader.getSystemClassLoader().getResource(path);
        path = uu.getFile();

        ProtectionDomain p = mainClass.getProtectionDomain();
        CodeSource cs = p.getCodeSource();
        URL location = cs.getLocation();

        String sss = location.getPath();
        String sssss= location.getFile();
        String fn = new java.io.File(sss).getName();

        String s = getResourceFilePath(getApplicationMainClassName());
*/
        return "ddd";
    }
}