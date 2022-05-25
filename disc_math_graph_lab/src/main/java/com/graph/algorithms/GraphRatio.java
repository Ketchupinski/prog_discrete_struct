package com.graph.algorithms;

import com.graph.matrix.AdjacencyMatrix;

public class GraphRatio {
    private final boolean isSymmetrical;
    private final boolean isTransitive;

    public GraphRatio(AdjacencyMatrix aMatrix) {
        this.isSymmetrical = checkSymmetrical(aMatrix);
        this.isTransitive = checkTransitive(aMatrix);
    }

    private boolean checkSymmetrical(AdjacencyMatrix aMatrix) {
        int[][] matrix = aMatrix.getMatrix();
        int n = aMatrix.getN();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((matrix[i][j] == 1 && matrix[j][i] == 0)
                        ||
                   (matrix[j][i] == 1 && matrix[i][j] == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkTransitive(AdjacencyMatrix aMatrix) {
        int[][] matrix = aMatrix.getMatrix();
        int n = aMatrix.getN();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
            {
                if (i == j) continue;
                if (matrix[i][j] == 0) continue;
                for(int k = 1; k <= n; k++)
                {
                    if (k == i || k == j) continue;
                    if (matrix[j][k] == 0) continue;

                    if (matrix[i][k] == 0) { return false; }
                }
            }
        return true;
    }


    public boolean isSymmetrical() {
        return isSymmetrical;
    }

    public boolean isTransitive() {
        return isTransitive;
    }
}
