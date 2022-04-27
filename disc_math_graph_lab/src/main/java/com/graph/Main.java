package com.graph;

import com.graph.file.FileService;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.Arrays;

import com.graph.matrix.WeightedMatrix;
import com.graph.search.DijkstraAlg;
import com.graph.search.FloydMinPathMatrix;

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
//        file.writeMatrixToFile("wMatrix", wMatrix.getMatrix());
          FloydMinPathMatrix floydAlg = new FloydMinPathMatrix(wMatrix);
          int[][][] mat = floydAlg.getMinWeightMatrix();
//        System.out.println("Weight matrix:");
         System.out.println("Path matrix:");
         mService.printMatrix(floydAlg.getPathMatrix());
//        System.out.println("Path:" + floydAlg.getPath(1, 7) + "\n\n");

        System.out.println("\n\n");
        WeightedMatrix Matrix = new WeightedMatrix(fileInfo);
        mService.printMatrix(Matrix.getMatrix());

        DijkstraAlg minWeight = new DijkstraAlg(Matrix, 3, 1);
        mService.printTopsResult(minWeight.getMinWeight(), "minWeight");
        mService.printTopsResult(minWeight.getPathVector(), "pathVector");
    }
}
