package com.university;

import java.util.Arrays;

/**
 *Дано цілочисельні множини А та В, які являють собою підмножини n-
 * елементного універсуму. За допомогою бітових рядків визначити
 * -A, A AND B, A OR B, A \ B, A XOR B.
 * @author Arsen Savshak
 * @version 1.0
 */
public class TaskTwo {
    public static void resolveTask(int kU, int kA, int kB) {
        int[] U = new int[kU];
        fillArray(U);
        int[] A = new int[kA];
        fillArray(A);
        int[] B = new int[kB];
        fillArray(B);

        int[] bA = createBitString(A, U);
        int[] bB = createBitString(B, U);
        System.out.println("U: " + Arrays.toString(U));
        System.out.println("bA: " + Arrays.toString(bA));
        System.out.println("bB: " + Arrays.toString(bB));

        System.out.println("-bA: " + Arrays.toString(findLogicNegation(bA)));
        System.out.println("bA or bB: " + Arrays.toString(findLogicUnion(bA, bB)));
        System.out.println("bA and bB: " + Arrays.toString(findLogicInsertion(bA, bB)));
        System.out.println("bA / bB: " + Arrays.toString(findLogicDifference(bA, bB)));
        System.out.println("bA xor bB: " + Arrays.toString(findLogicStrict(bA, bB)));
    }

    public static int[] fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] createBitString(int[] arr, int[] U) {
        int[] bitArr = new int[U.length];
        for (int i = 0; i < U.length && i < arr.length; i++) {
            if (U[i] == arr[i]) {
                bitArr[i] = 1;
            } else {
                bitArr[i] = 0;
            }
        }
        return bitArr;
    }

    public static int[] findLogicNegation(int[] A) {
        int[] D = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                D[i] = 0;
            }
            else {
                D[i] = 1;
            }
        }
        return D;
    }

    public static int[] findLogicInsertion(int[] A, int[] B) {
        int[] D = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1 && B[i] == 1) {
                D[i] = 1;
            }
            else {
                D[i] = 0;
            }
        }
        return D;
    }

    public static int[] findLogicUnion(int[] A, int[] B) {
        int[] D = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1 || B[i] == 1) {
                D[i] = 1;
            }
            else {
                D[i] = 0;
            }
        }
        return D;
    }

    public static int[] findLogicDifference(int[] A, int[] B) {
        int[] D = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1 && B[i] == 0) {
                D[i] = 1;
            }
            else {
                D[i] = 0;
            }
        }
        return D;
    }

    public static int[] findLogicStrict(int[] A, int[] B) {
        int[] D = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1 && B[i] == 0
                ||
                A[i] == 0 && B[i] == 1) {
                D[i] = 1;
            }
            else {
                D[i] = 0;
            }
        }
        return D;
    }
}
