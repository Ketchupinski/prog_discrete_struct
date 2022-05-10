package com.graph.algorithms;

import com.graph.matrix.AdjacencyMatrix;

public interface TraversalAlgorithmI {
    public void matrixSearch(AdjacencyMatrix matrix, int top);
    public void printResult();
    public String[][] getResultTable();
}
