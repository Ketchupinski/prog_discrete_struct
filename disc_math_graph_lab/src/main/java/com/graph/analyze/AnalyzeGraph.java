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

    public int isHomogeneous(int[][] inDeg, int[][] outDeg) {
        for(int i = 1; i < inDeg.length; i++) {
            if ((i + 1) < inDeg.length) {
                if((inDeg[i][1] != inDeg[i+1][1])
                    ||
                   (outDeg[i][1] != outDeg[i+1][1])
                    ||
                   (inDeg[i][1] != outDeg[i][1])) {
                    return 0;
                }
            }
        }
        return inDeg[0][1];
    }

    public int[] getHangingTops(int[][] inDeg, int[][] outDeg) {
        int[] hanging = new int[inDeg.length];
        for (int i = 1; i < inDeg.length; i++) {
            if (inDeg[i][1] == 1 && outDeg[i][1] == 0) {
                hanging[i] = 1;
            }
            else {
                hanging[i] = 0;
            }
        }
        return hanging;
    }

    public int[] getIsolatedTops(int[][] inDeg, int[][] outDeg) {
        int[] isolated = new int[inDeg.length];
        for (int i = 1; i < inDeg.length; i++) {
            if (inDeg[i][1] == 0 && outDeg[i][0] == 0) {
                isolated[i] = 1;
            }
            else {
                isolated[i] = 0;
            }
        }
        return isolated;
    }
}
