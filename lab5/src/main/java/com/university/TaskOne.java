package com.university;

import java.util.Arrays;

/**
 * Дано скінчені множини А={a, b, c}, В={x, y, z}, С={0, 1}. Побудувати множину
 * ВxCxC
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskOne {
    public static void resolveTask() {
        String[] B = {"x", "y", "z"};
        String[] C = {"1", "2"};

        String[] T = cartesianProd(B, C);
        System.out.println(Arrays.toString((T)));
        String[] D = cartesianProd(T, C);
        System.out.println(Arrays.toString(D));
    }

    public static String[] cartesianProd(String[] B, String[] C) {
        String[] D = new String[B.length * C.length];
        int j = 0;
        for (int iB = 0; iB < B.length; iB++) {
             for (int iC = 0; iC < C.length; iC++)
             {
                D[j] = B[iB] + C[iC];
                j++;
            }
        }
        return D;
    }
}
