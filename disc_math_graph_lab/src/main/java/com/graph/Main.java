package com.graph;

import com.graph.algorithms.GraphRatio;
import com.graph.file.FileService;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

import com.graph.algorithms.ColoringGraph;

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

        // Coloring graph
        System.out.println("Coloring graph:");
        int[][] fileInfo = file.getGraphFromFile(Path.of("graph_01_1.txt"));
        AdjacencyMatrix colorMatrix = new AdjacencyMatrix(fileInfo);
        mService.printMatrix(colorMatrix.getMatrix());
        System.out.println("\n");
        ColoringGraph coloringGraph = new ColoringGraph(colorMatrix);
        System.out.println(coloringGraph.getColorsMap().toString());

        // Graph ratio
        System.out.println("\n\nGraph ratio:");
        fileInfo = file.getGraphFromFile(Path.of("graph_ratio_02.txt"));
        AdjacencyMatrix ratioMatrix = new AdjacencyMatrix(fileInfo);
        mService.printMatrix(ratioMatrix.getMatrix());
        GraphRatio ratio = new GraphRatio(ratioMatrix);
        System.out.println("Is graph transitive: " + ratio.isTransitive());
        System.out.println("Is graph symmetrical: " + ratio.isSymmetrical());
    }
}
