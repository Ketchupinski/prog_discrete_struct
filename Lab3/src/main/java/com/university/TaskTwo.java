package com.university;

/**
 * Побудувати таблицю для чисел Стірлінга другого роду та
 * числа Белла для n = 14;
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskTwo {

    public static void resolveTask(int n) {
        int[][] F = fillTable(n);
        completeTable(F);
        printResult(F);
    }

    /**
     * Заповнення таблиці одиницями
     * @param n розмір таблиці
     * @return таблиця для чисел Стірлінга другого роду з одиницями.
     */
    public static int[][] fillTable(int n) {
        int[][] F = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                F[j][j] = 1;
                F[j][0] = 1;
            }
        }
        return F;
    }

    /**
     * Заповнення таблиці чисел Стірлінга потрібними значеннями
     * @param F заповнена одиницями таблиця
     * @return заповнену таблицю для чисел Стірлінга
     */
    public static int[][] completeTable(int[][] F) {
        int n = F.length;

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                F[i][j] = F[i - 1][j - 1] + (j + 1) * F[i - 1][j];
            }
        }
        return F;
    }

    /**
     * Виведення таблиці чисел Стірлінга з результатами
     * @param F таблиця чисел Стірлінга
     */
    public static void printResult(int[][] F) {
        int n = F.length;
        int t = 10 * n;
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%-2d | ", i + 1);

            for (int j = 0; j < n; j++) {
                if (j <= i) {
                    System.out.printf("%-12d", F[i][j]);
                }
            }
            System.out.print("  | " + getBelle(i, F) + "\n");
        }
    }

    /**
     * Знаходження числа Белла
     * @param i рядок в таблиці чисел Стірлінга
     * @param F таблиця чисел Стірлінга
     * @return число Белла рядка таблиці Стірлінга
     */
    public static int getBelle(int i, int[][] F) {
        int bNum = 0;
        for(int j = 0; j < F.length; j++) {
            bNum += F[i][j];
        }
        return bNum;
    }
}
