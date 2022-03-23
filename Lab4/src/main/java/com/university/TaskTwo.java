package com.university;

import java.util.Arrays;

/**
 * Задано натуральне число n і невід’ємне ціле число r (r ≤ n). Навести в
 * лексикографічному порядку всі r-сполучення без повторень з елементів множини
 * {1, 2, ... , n}.
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskTwo {
    public static void resolveTask(int n, int r) throws Exception {
        if (r > n && r < 0) {
            throw new Exception("r must be <= n and > 0");
        }
        // використання методу з першого завдання, щоб не повторюватись
        int[] nSet = TaskOne.createSet(n);
        System.out.println("n set: " + Arrays.toString(nSet));
        int[] rSet = TaskOne.createSet(r);
        System.out.println("r set: " + Arrays.toString(rSet));

        int k = getK(n, r);
        lexicOrder(k, n, r, rSet);

    }

    // кількість сполучень
    public static int getK(int n, int r) {
        return TaskOne.getFactorial(n) / (TaskOne.getFactorial(r) * TaskOne.getFactorial(n - r));
    }

    public static void lexicOrder(int k, int n, int r, int[] set) {
        for (int i = 2; i <= k; i++) {
            for (int j = set.length - 1; j >= 0; j--) {
                if (set[j] != n - r + j + 1) {
                    set[j]++;

                    if (j + 1 <= set.length - 1 && set[j] != n - r + j + 1) {
                        checkSet(set, j);
                    }
                    System.out.println(Arrays.toString(set));
                    break;
                }
            }
        }
    }

    public static int[] checkSet(int[] set, int j) {
        for (int i = set.length - 1; i > j; i--) {
            set[i]--;
        }
        return set;
    }

}
