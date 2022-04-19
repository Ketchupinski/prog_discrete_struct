package com.graph.file;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileService {
    private final int inf = Integer.MAX_VALUE;
    public int[][] getGraphFromFile(Path path) throws IOException {
        Scanner scanFile = new Scanner(path);
        int n = scanFile.nextInt(); // number of vertices of the graph
        int m = scanFile.nextInt(); // number of edges of the graph
        int[][] fileGraphInfo = new int[m + 1][2];
        fileGraphInfo[0][0] = n;
        fileGraphInfo[0][1] = m;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 2; j++) {
                fileGraphInfo[i][j] = scanFile.nextInt();
            }
        }
        return fileGraphInfo;
    }

    public void writeMatrixToFile(String fileName, int[][] M) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        int[] temp = M[0];
        int hL = M.length;
        int wL = temp.length;
        fileWriter.write("   | ");
        for (int i = 1; i < wL; i++) {
            String string = String.format("%-2d | ", i);
            fileWriter.write(string);
        }
        fileWriter.write("\n");
        for (int i = 1; i < hL; i++) {
            String string = String.format("%-2d | ", i);
            fileWriter.write(string);
            for (int j = 1; j < wL; j++) {
                if (M[i][j] != inf) {
                    String str = String.format("%-2d | ", M[i][j]);
                    fileWriter.write(str);
                } else {
                    char symbol = 0x221E;
                    String str = String.format("%-2c | ", symbol);
                    fileWriter.write(str);
                }

            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public int[][] getWeightedGraphFromFile(Path path) throws IOException {
        Scanner scanFile = new Scanner(path);
        int n = scanFile.nextInt(); // number of vertices of the graph
        int m = scanFile.nextInt(); // number of edges of the graph
        int[][] fileGraphInfo = new int[m + 1][3];
        fileGraphInfo[0][0] = n;
        fileGraphInfo[0][1] = m;
        fileGraphInfo[0][2] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= 2; j++) {
                fileGraphInfo[i][j] = scanFile.nextInt();
            }
        }
        return fileGraphInfo;
    }
}
