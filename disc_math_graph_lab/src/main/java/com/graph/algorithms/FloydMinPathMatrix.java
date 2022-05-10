package com.graph.algorithms;

import com.graph.matrix.MatrixService;
import com.graph.matrix.WeightedMatrix;

public class FloydMinPathMatrix {
    private final int[][][] minWeightMatrix;
    private final int[][] pathMatrix;
    public final int inf = Integer.MAX_VALUE;
    public FloydMinPathMatrix(WeightedMatrix w) {
        int n = w.getN();
        int[][][] matrix = new int[n + 1][n + 1][n + 1];
        for(int i = 0; i < w.getN(); i++) {
            matrix[i] = w.getMatrix();
        }
        int[][] pMatrix = createPathMatrix(n);
        MatrixService mService = new MatrixService();
        mService.printMatrix(matrix[0]);
        System.out.println();
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    if (matrix[k - 1][i][k] != inf && matrix[k - 1][k][j] != inf) {
                        if ((matrix[k - 1][i][k] + matrix[k - 1][k][j]) < matrix[k - 1][i][j]) {
                            matrix[k][i][j] = (matrix[k - 1][i][k] + matrix[k - 1][k][j]);
                            pMatrix[i][j] = k;
                        }
                    }
                }
            }
            System.out.println("k: " + k);
            mService.printMatrix(matrix[k]);
        }

        this.minWeightMatrix = matrix;
        this.pathMatrix = pMatrix;
    }

    private int[][] createPathMatrix(int n) {
        int[][] T = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                if (i == j) {
                    T[i][j] = 0;
                }
                else {
                    T[i][j] = i;
                }
            }
        }
        return T;
    }

    /**
     * Find path from <code>v</code> to <code>u</code>
     * @param v start top
     * @param u end top
     * @return min path
     */
    public String getPath(int v, int u) {
        if (pathMatrix[v][u] == v) {
            return " " + v;
        }

        int n = this.pathMatrix.length;
        StringBuilder path = new StringBuilder();
        int next = u;
        for(int j = 1; j < n; j++) {
            if (pathMatrix[v][next] != v) {
                path.append(next).append(" ");
                next = pathMatrix[v][next];
            }
            else {
                path.append(next).append(" ").append(v).append(" ");
                return path.reverse().toString();
            }
        }
        return ""; // unreal scenario
    }

    public int[][][] getMinWeightMatrix() {
        return minWeightMatrix;
    }

    public int[][] getPathMatrix() {
        return pathMatrix;
    }
}
