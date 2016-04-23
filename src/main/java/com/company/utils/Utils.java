package com.company.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yevgen on 06.01.2016.
 */

public class Utils {
    public final static String PLEASE_REPEAT_ENTER =
            "%s was generated with data \"%s\". Please, repeat enter action";

    public static void printLine(String message) {
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
}