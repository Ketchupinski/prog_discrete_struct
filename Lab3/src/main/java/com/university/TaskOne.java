package com.university;

/**
 * «Обчислити кількість усіх розміщень без
 * повторень з n елементів по r».
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskOne {
    public static int resolveTask(int n, int r) {
        int P1 = getFactorial(n);
        int P2 = getFactorial(n - r);
        return P1 / P2;
    }

    /**
     * Визначення факторіалу числа
     * @param n число для визначення факторіалу
     * @return факторіал числа <code>n</code>
     */
    public static int getFactorial(int n) {
        int P = 1;
        for (int i = 1; i <= n; i++) {
            P *= i;
        }
        return P;
    }

}
