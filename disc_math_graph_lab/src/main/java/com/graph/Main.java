package com.graph;

import com.graph.file.FileService;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

import com.graph.search.BFS;
import com.graph.search.SearchAlgorithmI;
import com.graph.search.DFS;

/**
 * Вивід матриць інцидентності та суміжності. За вимогою користувача програма
 * повинна виводити матриці інцидентності та суміжності (окремі функції) на екран
 * та у текстовий файл, який вказує користувач.
 * @author Arsen Savshak
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        FileService file = new FileService();
        MatrixService mService = new MatrixService();
        int[][] matrixInfo = file.getGraphFromFile(Path.of("graph_01_1.txt"));

        AdjacencyMatrix aMatrix = new AdjacencyMatrix(matrixInfo);
        mService.printMatrix(aMatrix.getMatrix());

        SearchAlgorithmI dSearch = new DFS();
        dSearch.matrixSearch(aMatrix, 4);
        dSearch.printResult();

        System.out.println("\n");
        SearchAlgorithmI bSearch = new BFS();
        bSearch.matrixSearch(aMatrix, 4);
        bSearch.printResult();
    }
}
