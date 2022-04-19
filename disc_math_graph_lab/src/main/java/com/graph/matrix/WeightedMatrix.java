package com.graph.matrix;

import java.util.Arrays;

public class WeightedMatrix {
    private final int[][] Matrix;
    private final int n;
    private final int m;

    public WeightedMatrix(int[][] E) {
        this.n = E[0][0];
        this.m = E[0][1];

        MatrixService mService = new MatrixService();
        int[] V = mService.fillVerticesAsSet(n);

        int[][] A = new int[n + 1][n + 1];
        boolean isEqual = false;
        int iter = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int[] v = {V[i], V[j]};
                for (int r = 1; r <= m; r++) {
                    int[] e = {E[r][0], E[r][1]};
                    if (Arrays.equals(v, e)) {
                        isEqual = true;
                        iter = r;
                        break;
                    }
                }
                if(isEqual) {
                    A[i][j] = E[iter][2];
                }
                else {
                    A[i][j] = 0;
                }
                isEqual = false;
            }
        }
        this.Matrix = A;
    }

    public int[][] getMatrix() {
        return Matrix;
    }

    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
}
