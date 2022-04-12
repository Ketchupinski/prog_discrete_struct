package com.graph.search;

import com.graph.matrix.AdjacencyMatrix;

public interface SearchAlgorithmI {
    public void matrixSearch(AdjacencyMatrix matrix, int top);
    public void printResult();
    public String[][] getResultTable();
}
