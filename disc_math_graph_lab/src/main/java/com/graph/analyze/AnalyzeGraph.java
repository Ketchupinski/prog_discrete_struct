package com.graph.analyze;

import com.graph.matrix.AdjacencyMatrix;

public class AnalyzeGraph {
    public int[][] FindOutDegrees(AdjacencyMatrix aMatrix) {
        int m = aMatrix.getM();
        int n = aMatrix.getN();

        int[][] M = aMatrix.getMatrix();
        int[][] degArr = new int[n+1][2];
        int deg;
        for (int i = 1; i <= n; i++) {
            deg = 0;
            for (int j = 1; j <= n; j++) {
                if (M[i][j] == 1) {
                    deg++;
                }
            }
            degArr[i][0] = i;
            degArr[i][1] = deg;
        }
        return degArr;
    }

    public int[][] FindInDegrees(AdjacencyMatrix aMatrix) {
        int m = aMatrix.getM();
        int n = aMatrix.getN();

        int[][] M = aMatrix.getMatrix();
        int[][] degArr = new int[n + 1][2];
        int deg;
        for (int i = 1; i <= n; i++) {
            deg = 0;
            for (int j = 1; j <= n; j++) {
                if (M[j][i] == 1) {
                    deg++;
                }
            }
            degArr[i][0] = i;
            degArr[i][1] = deg;
        }
        return degArr;
    }

    public int isHomogeneous(int[][] degreeTops) {
        for(int i = 1; i < degreeTops.length; i++) {
            if ((i + 1) < degreeTops.length) {
                if(degreeTops[i][1] != degreeTops[i+1][1]) {
                    return 0;
                }
            }
        }
        return degreeTops[0][1];
    }

    public int[][] findDegreesOfTops(int[][] degArrIn, int[][] degArrOut) {
        int[][] degree = new int [degArrIn.length][2];
        for (int i = 1; i < degree.length; i++) {
            degree[i][0] = i;
            degree[i][1] = degArrIn[i][1] + degArrOut[i][1];
        }
        return degree;
    }

    public int[] getHangingTops(int[][] degreeTops) {
        int[] hanging = new int[degreeTops.length];
        for (int i = 1; i < degreeTops.length; i++) {
            if (degreeTops[i][1] == 1) {
                hanging[i] = 1;
            }
            else {
                hanging[i] = 0;
            }
        }
        return hanging;
    }

    public int[] getIsolatedTops(int[][] degreeTops) {
        int[] isolated = new int[degreeTops.length];
        for (int i = 1; i < degreeTops.length; i++) {
            if (degreeTops[i][1] == 0) {
                isolated[i] = 1;
            }
            else {
                isolated[i] = 0;
            }
        }
        return isolated;
    }
}
