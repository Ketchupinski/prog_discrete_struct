package com.university;

/**
 * Second task from lab 1:
 * Задано два бітові рядки довжиною n.
 * Знайти результати виконання порозрядних операцій OR, AND, XOR цих рядків.
 * @version 1
 * @author Arsen Savshak
 */
public class TaskTwo {
    private static final String a = "101011100";
    private static final String b = "010011010";
    private static final int n = a.length();
    private static final StringBuilder r = new StringBuilder("");

    static
    {
        System.out.println("Fields: \n" + a + "\n" + b);
    }

    /**
     * This method find result of logic conjunction from
     * string <code>a</code> and <code>b</code>
     * @return string with result of conjunction
     */
    public static String findLogicConjunction() {
        r.delete(0, r.length());

        for (int i = 0; i < n; i++) {
            int one = Integer.parseInt(String.valueOf(a.charAt(i)));
            int two = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (one == 1 && two == 1) {
                r.append("1");
            } else {
                r.append("0");
            }
        }
        return r.toString();
    }

    /**
     * This method find result of logic disjunction from
     * string <code>a</code> and <code>b</code>
     * @return string with result of disjunction
     */
    public static String findLogicDisjunction() {
        r.delete(0, r.length());

        for (int i = 0; i < n; i++) {
            int one = Integer.parseInt(String.valueOf(a.charAt(i)));
            int two = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (one == 1 || two == 1) {
                r.append("1");
            } else {
                r.append("0");
            }
        }
        return r.toString();
    }

    /**
     * This method find result of logic strict disjunction from
     * string <code>a</code> and <code>b</code>
     * @return string with result of strict disjunction
     */
    public static String findStrictDisjunction() {
        r.delete(0, r.length());

        for (int i = 0; i < n; i++) {
            int one = Integer.parseInt(String.valueOf(a.charAt(i)));
            int two = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (one == 1 ^ two == 1) {
                r.append("1");
            } else {
                r.append("0");
            }
        }
        return r.toString();
    }

    public static void printResult() {
        System.out.println("Result: ");
        System.out.println("Logic conjunction:\n" + findLogicConjunction());
        System.out.println("Logic disjunction:\n" + findLogicDisjunction());
        System.out.println("Logic strict disjunction:\n" + findStrictDisjunction());
    }

}
