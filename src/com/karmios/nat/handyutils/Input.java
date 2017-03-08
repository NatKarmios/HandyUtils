package com.karmios.nat.handyutils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static com.karmios.nat.handyutils.Constants.*;

@SuppressWarnings({"WeakerAccess", "unused", "SameParameterValue"})
public final class Input {

    private Input(){}

    private static final Scanner sc = new Scanner(System.in);

    // <editor-fold desc="input()">

    public static String input (String prompt, Predicate<String> condition) throws InputMismatchException {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (!condition.test(input)) throw new InputMismatchException();
        return input;
    }

    public static String input (Predicate<String> condition) throws InputMismatchException {
        return input("> ", condition);
    }

    public static String input (String prompt) throws InputMismatchException {
        return input(prompt, STRING_TRUE);
    }

    // <editor-fold desc="loop">

    public static String inputLoop(String prompt, String failMessage, Predicate<String> condition) {
        while (true)
            try {
                return input(prompt, condition);
            } catch (InputMismatchException e) {
                System.out.println(failMessage);
            }
    }

    public static String inputLoop(String prompt, Predicate<String> condition) {
        return inputLoop(prompt, "> ", condition);
    }

    public static String inputLoop(String prompt, String failMessage) {
        return inputLoop(prompt, failMessage, STRING_TRUE);
    }

    public static String inputLoop(String prompt) {
        return inputLoop(prompt, "Invalid input!", STRING_TRUE);
    }

    public static String inputLoop(Predicate<String> condition) {
        return inputLoop("> ", "Invalid input!", condition);
    }

    public static String inputLoop() {
        return inputLoop("> ", "Invalid input!", STRING_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="inputInt()">

    public static int inputInt(String prompt, IntPredicate condition) throws NumberFormatException {
        int input = Integer.valueOf(input(prompt));
        if (!condition.test(input)) throw new NumberFormatException();
        return input;
    }

    public static int inputInt(IntPredicate condition) throws  NumberFormatException {
        return inputInt("> ", condition);
    }

    public static int inputInt(String prompt) throws NumberFormatException {
        return inputInt(prompt, INT_TRUE);
    }

    public static int inputInt() throws NumberFormatException {
        return inputInt("> ", INT_TRUE);
    }

    // <editor-fold desc="loop">

    public static int inputIntLoop(String prompt, String failMessage, IntPredicate condition) {
        while (true)
            try {
                return inputInt(prompt, condition);
            } catch (NumberFormatException e) {
                System.out.println(failMessage);
            }
    }

    public static int inputIntLoop(String prompt, IntPredicate condition) {
        return inputIntLoop(prompt, "Invalid input!", condition);
    }

    public static int inputIntLoop(String prompt, String failMessage) {
        return inputIntLoop(prompt, failMessage, INT_TRUE);
    }

    public static int inputIntLoop(String prompt) {
        return inputIntLoop(prompt, "Invalid input!", INT_TRUE);
    }

    public static int inputIntLoop(IntPredicate condition) {
        return inputIntLoop("> ", "Invalid input!", condition);
    }

    public static int inputIntLoop() {
        return inputIntLoop("> ", "Invalid input!", INT_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="inputDouble()">

    public static double inputDouble(String prompt, DoublePredicate condition) throws NumberFormatException {
        double input = Double.valueOf(input(prompt));
        if (!condition.test(input)) throw new NumberFormatException();
        return input;
    }

    public static double inputDouble(DoublePredicate condition) throws  NumberFormatException {
        return inputDouble("> ", condition);
    }

    public static double inputDouble(String prompt) throws NumberFormatException {
        return inputDouble(prompt, DOUBLE_TRUE);
    }

    public static double inputDouble() throws NumberFormatException {
        return inputDouble("> ", DOUBLE_TRUE);
    }

    // <editor-fold desc="loop">

    public static double inputDoubleLoop(String prompt, String failMessage, DoublePredicate condition) {
        while (true)
            try {
                return inputDouble(prompt, condition);
            } catch (NumberFormatException e) {
                System.out.println(failMessage);
            }
    }

    public static double inputDoubleLoop(String prompt, DoublePredicate condition) {
        return inputDoubleLoop(prompt, "Invalid input!", condition);
    }

    public static double inputDoubleLoop(String prompt, String failMessage) {
        return inputDoubleLoop(prompt, failMessage, DOUBLE_TRUE);
    }

    public static double inputDoubleLoop(String prompt) {
        return inputDoubleLoop(prompt, "Invalid input!", DOUBLE_TRUE);
    }

    public static double inputDoubleLoop(DoublePredicate condition) {
        return inputDoubleLoop("> ", "Invalid input!", condition);
    }

    public static double inputDoubleLoop() {
        return inputDoubleLoop("> ", "Invalid input!", DOUBLE_TRUE);
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="inputBool()">

    public static boolean inputBool(String prompt, boolean addYN) throws InputMismatchException {
        if (addYN) {
            if (prompt.endsWith(": "))
                prompt = prompt.substring(0, prompt.length() - 2) + " (Y/N)" + ": ";
            else
                prompt = prompt + "(Y/N) ";
        }
        System.out.print(prompt);
        String input = sc.nextLine().trim().toUpperCase();
        if (input.startsWith("Y") || input.startsWith("N")) return input.startsWith("Y");
        else throw new InputMismatchException();
    }

    public static boolean inputBool(String prompt) throws InputMismatchException {
        return inputBool(prompt, false);
    }

    public static boolean inputBool(boolean addYN) {
        return inputBool("> ", addYN);
    }

    public static boolean inputBool() {
        return inputBool("> ", false);
    }

    // <editor-fold desc="loop">

    public static boolean inputBoolLoop(String prompt, String failMessage, boolean addYN) {
        while (true) {
            try {
                return inputBool(prompt, addYN);
            }
            catch (InputMismatchException e) {
                System.out.println(failMessage);
            }
        }
    }

    public static boolean inputBoolLoop(String prompt, String failMessage) {
        return inputBoolLoop(prompt, failMessage, false);
    }

    public static boolean inputBoolLoop(String prompt, boolean addYN) {
        return inputBoolLoop(prompt, "Invalid input!");
    }

    public static boolean inputBoolLoop(String prompt) {
        return inputBoolLoop(prompt, "Invalid input!", false);
    }

    public static boolean inputBoolLoop(boolean addYN) {
        return inputBoolLoop("> ", "Invalid input!", addYN);
    }

    public static boolean inputBoolLoop() {
        return inputBoolLoop("> ", "Invalid input!", false);
    }

    // </editor-fold>

    // </editor-fold>

}
