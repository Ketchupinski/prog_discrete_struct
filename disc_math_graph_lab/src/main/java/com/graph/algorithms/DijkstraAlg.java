package com.graph.algorithms;

import com.graph.matrix.MatrixService;
import com.graph.matrix.WeightedMatrix;

import java.util.*;

public class DijkstraAlg {
    private int[] minWeight;

    private int[] pathVector;
    public final int inf = Integer.MAX_VALUE;

    public DijkstraAlg(WeightedMatrix matrix, int a, int z) throws Exception {
        int[][] wMat = matrix.getMatrix();
        for (int i = 1; i < wMat.length; i++) {
            for (int j = 1; j < wMat.length; j++) {
                if (wMat[i][j] < 0) {
                    throw new Exception("This algorithm must use only positive weight!");
                }
            }
        }

        findTopsPath(matrix, 3, 7);
    }

    public void findTopsPath(WeightedMatrix matrix, int a, int z) {
        Set<Integer> M = new LinkedHashSet<>();// множина постійних вершин
        int[] T = new int[matrix.getN() + 1];  // множина тимчасових міток (T/M)
        int[][] wMatrix = matrix.getMatrix();
        int[] V = new MatrixService().fillVerticesAsSet(matrix.getN()); // множина вершин
        int[] P = new int[matrix.getN() + 1];

        M.add(a);
        T[a] = 0;
        for (int i = 1; i < matrix.getN() + 1; i++) {
            P[i] = 0;
            if (i != a) {
                T[i] = inf;
            }
        }

        int x = a; // поточна вершина
        for (int i = 1; i < matrix.getN() + 1; i++) {

            for (int v = 1; v < matrix.getN() + 1; v++) {
                if (wMatrix[x][v] > 0 && wMatrix[x][v] != inf) {
                    if (!M.contains(v)) {
                        if (T[v] > (T[x] + wMatrix[x][v])) {
                            T[v] = (T[x] + wMatrix[x][v]);
                            P[v] = x;
                        }
                    }
                }
            }

            int minWeight = inf;
            int minElement = 0;
            for (int v = 1; v < matrix.getN() + 1; v++) {
                if (!M.contains(v)) {
                    if (T[v] < minWeight) {
                        minWeight = T[v];
                        minElement = v;
                    }
                }
            }
            M.add(minElement);
            if (minElement == z) {
                this.minWeight = T;
                this.pathVector = P;
                return;
            }
            x = minElement;
        }
    }

    public int[] getMinWeight() {
        return minWeight;
    }

    public int[] getPathVector() {
        return pathVector;
    }
}
