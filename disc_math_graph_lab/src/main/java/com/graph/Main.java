package com.graph;

import com.graph.file.FileService;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

import com.graph.matrix.WeightedMatrix;
import com.graph.search.MinPathMatrix;

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
        MinPathMatrix minPathAlg = new MinPathMatrix(wMatrix);
        System.out.println("Weight matrix:");
        mService.printMatrix(minPathAlg.getMinWeightMatrix());
        System.out.println("Path matrix:");
        mService.printMatrix(minPathAlg.getPathMatrix());
        System.out.println("Path:" + minPathAlg.getPath(4, 7));
    }
}
