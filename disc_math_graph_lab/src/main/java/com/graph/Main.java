package com.graph;

import com.graph.file.FileService;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.IncidenceMatrix;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

import com.graph.matrix.WeightedMatrix;
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

        int[][] fileInfo = file.getWeightedGraphFromFile(Path.of("weighted_graph_01.txt"));
        WeightedMatrix wMatrix = new WeightedMatrix(fileInfo);
        mService.printMatrix(wMatrix.getMatrix());
        file.writeMatrixToFile("wMatrix", wMatrix.getMatrix());
    }
}
