package com.university;

/**
 * Lab 2 task:
 * Побудувати таблицю істинності для функції  fn, заданої формулою (n – номер варіанту)
 *   p → (q ˄ r)
 *       ==
 * (-p ˅ q) ˄ (-p ˅ r)
 * @version 1.0
 * @author Arsen Savshak
 */
public class Task {
    private static final int[][] table = new int[8][7];

    /**
     * This method create standard binary table and put into
     * the class field <code>table</code>.
     */
    public static void genBinaryTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = (i / (int) Math.pow(2, j)) % 2;
            }
        }
    }

    /**
     * This method modify class field <code>table</code>
     * solving operations and put result to <code>table</code>.
     * Also, this method call's another class method <code>getBinaryTable</code>.
     */
    public static void SolveOperations() {
        genBinaryTable();
        for (int i = 0; i < 8; i++) {
            int p = table[i][0];
            int q = table[i][1];
            int r = table[i][2];

            table[i][3] = (!(p == 1)) ? 1 : 0; // -p
            table[i][4] = ((table[i][3] == 1 || q == 1) ? 1 : 0); // (-p ˅ q)
            table[i][5] = ((table[i][3] == 1 || r == 1) ? 1 : 0); // (-p ˅ r)
            table[i][6] = ((table[i][4] == 1 && table[i][5] == 1) ? 1 : 0); // (-p ˅ q) ˄ (-p ˅ r)
        }
    }

    /**
     * This method call's and print result
     * of another methods <code>SolveOperations</code>
     * and <code>getBinaryTable</code>
     */
    public static void PrintTable() {
        SolveOperations();
        System.out.println("p\t|\tq\t|\tr\t|\t-p\t|-p ˅ q |-p ˅ r |(-p ˅ q) ˄ (-p ˅ r)|");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (j < 6) {
                    System.out.print(table[i][j] + "\t|\t");
                }
                if (j == 6) {
                    System.out.print("\t  " + table[i][j] + "\t\t\t|");
                }
            }
            System.out.println();
        }

    }
}
