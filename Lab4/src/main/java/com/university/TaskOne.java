package com.university;

import java.util.Arrays;

/**
 * Задано натуральне число n. Навести в лексикографічному порядку всі
 * перестановки елементів множини {1, 2, ... , n}.
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskOne {

    public static void resolveTask(int n) {
        int[] set = createSet(n);
        System.out.println(Arrays.toString(set));
        permutateSet(set);
    }

    public static int[] permutateSet(int[] set) {
        int n = set.length;
        int fact = getFactorial(n);

        for (int i = 1; i < fact; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (set[j] < set[j + 1]) {
                    int pos = findMinHigher(set, j);

                    int temp = set[j];
                    set[j] = set[pos];
                    set[pos] = temp;

                    // якщо після перестановки є більше 1 елемента після j,
                    // то ці елементи сортуються у висхідному порядку
                    if (set.length - j > 1) { ascendingSort(set, j); }
                    System.out.println(Arrays.toString(set));
                    break;
                }
            }
        }
        return set;
    }

    public static int[] createSet(int n) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i + 1;
        }
        return set;
    }

    public static int getFactorial(int num) {
        int P = 1;
        for (int i = 1; i <= num; i++) {
            P *= i;
        }
        return P;
    }

    /**
     * Метод передає позицію числа, яке найменьшим з більших за j чисел після j.
     * @param set множина чисел
     * @param j позиція числа, від якого потрібно знайти найменьше більше число
     * @return позиція найменьшого більшого числа
     */
    public static int findMinHigher(int[] set, int j) {
        int min = j + 1;
        for (int i = j + 1; i < set.length; i++) {
            if(set[i] > set[j] && set[i] < set[min]) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Сортування у висхідному порядку методом бульбашки
     * @param set множина чисел
     * @param j позиція числа від якого буде сортування
     * @return посортовані у висхідному порядку числа після j
     */
    public static int[] ascendingSort(int[] set, int j) {
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;
            for (int i = j + 1; i < set.length - 1; i++) {
                if (set[i] > set[i + 1] ) {
                    isSorted = false;
                    int temp = set[i];
                    set[i] = set[i + 1];
                    set[i + 1] = temp;
                }
                }
            }
        return set;
        }
}
