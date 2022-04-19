package com.graph.matrix;

public class MatrixService {
    private final int inf = Integer.MAX_VALUE;

    public int[] fillVerticesAsSet(int n) {
        int[] vertices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vertices[i] = i;
        }
        return vertices;
    }

    public void printMatrix(int[][] M) {
        int[] temp = M[0];
        int hL = M.length;
        int wL = temp.length;
        System.out.print("   | ");
        for (int i = 1; i < wL; i++){
            System.out.printf("%-2d | ", i);
        }
        System.out.println();
        for (int i = 1; i < hL; i++) {
            System.out.printf("%-2d | ", i);
            for (int j = 1; j < wL; j++) {
                if (M[i][j] != inf) {
                    System.out.printf("%-2d | ", M[i][j]);
                }
                else {
                    char symbol = 0x221E;
                    System.out.printf("%-2c | ", symbol);
                }
            }
            System.out.println();
        }
    }

    public void printTopsResult(int[][] result, String string) {
        System.out.print(string + ": ");
        for (int i = 1; i < result.length; i++) {
            System.out.print("{V" + i + ": " + result[i][1] + "} ");
        }
        System.out.println();
    }

    public void printTopsResult(int[] result, String string) {
        System.out.print(string + ": ");
        for (int i = 1; i < result.length; i++) {
            System.out.print("{V" + i + ": " + result[i] + "} ");
        }
        System.out.println();
    }
}
