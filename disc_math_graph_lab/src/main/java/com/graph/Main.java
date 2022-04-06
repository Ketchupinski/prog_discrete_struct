package com.graph;

import com.graph.analyze.AnalyzeGraph;
import com.graph.file.FileService;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.IncidenceMatrix;
import com.graph.matrix.MatrixService;
import java.io.IOException;
import java.nio.file.Path;

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
        IncidenceMatrix iMatrix = new IncidenceMatrix(matrixInfo);
        mService.printMatrix(iMatrix.getMatrix());
        file.writeMatrixToFile("iMatrix_file.txt", iMatrix.getMatrix());

        System.out.println("\n\n");
        AdjacencyMatrix aMatrix = new AdjacencyMatrix(matrixInfo);
        mService.printMatrix(aMatrix.getMatrix());
        file.writeMatrixToFile("aMatrix_file.txt", aMatrix.getMatrix());

        System.out.println("\n\nLab2:\n");

        AnalyzeGraph analyzer = new AnalyzeGraph();
        int[][] outDeg = analyzer.FindOutDegrees(aMatrix);
        int[][] inDeg = analyzer.FindInDegrees(aMatrix);
        int[][] degreeTops = analyzer.findDegreesOfTops(inDeg, outDeg);
        mService.printTopsResult(outDeg, "Semi-output");
        mService.printTopsResult(inDeg, "Semi-input");
        mService.printTopsResult(degreeTops, "Tops degrees");
        System.out.println("Homogenous: " + analyzer.isHomogeneous(degreeTops));
        mService.printTopsResult(analyzer.getHangingTops(degreeTops), "Hanging tops");
        mService.printTopsResult(analyzer.getIsolatedTops(degreeTops), "Isolated tops");
    }
}
