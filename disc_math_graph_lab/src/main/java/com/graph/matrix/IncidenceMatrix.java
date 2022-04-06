package com.graph.matrix;

public class IncidenceMatrix {
    private final int[][] Matrix;
    private final int n;
    private final int m;

    public int[][] getMatrix() {
        return Matrix;
    }

    public IncidenceMatrix(int[][] E) {
        this.n = E[0][0];
        this.m = E[0][1];
        MatrixService mService = new MatrixService();

        int[] V = mService.fillVerticesAsSet(n + 1);

        int[][] M = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int v = E[j][0]; // beginning of graph
                int u = E[j][1]; // end of graph

                if (V[i] == v && v == u) {
                    M[i][j] = 2;
                } else if (V[i] == u) {
                    M[i][j] = -1;
                } else if (V[i] == v) {
                    M[i][j] = 1;
                } else {
                    M[i][j] = 0;
                }
            }
        }
        this.Matrix = M;
    }

    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
}
