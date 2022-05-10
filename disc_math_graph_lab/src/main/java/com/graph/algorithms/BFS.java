package com.graph.algorithms;

import com.graph.matrix.AdjacencyMatrix;

import java.util.*;

/**
 * Обійти граф пошуков вшир. Реалізувати програмне застосування (програму), яке виконує наступні
 * функції. Причому на вхід програми подається вхідний файл з описом
 * графу, зі структурою, яка вказана у практичному завданні
 * «Представлення графів». При реалізації алгоритмів вважати, що
 * заданий граф є зв’язаним.
 * @author Arsen Savshak
 * @version 1.0
 */
public class BFS implements TraversalAlgorithmI {
    String[][] resultTable;

    @Override
    public void matrixSearch(AdjacencyMatrix matrix, int startTop) {
        Map<Integer, Integer> BFS = new HashMap<>(); // HashMap to write BFS results
        Queue<Integer> queue = new LinkedList<>();

        int m = matrix.getM();
        int n = matrix.getN();
        int[][] graph = matrix.getMatrix();
        String[][] resultTable = new String[n * 2 + 1][3];


        BFS.put(startTop, 1);
        queue.add(startTop);
        resultTable[1][0] = queue.peek().toString();
        resultTable[1][1] = String.valueOf(1);
        resultTable[1][2] = queue.toString();


        int BFCNum = 2;
        boolean isFind;

        for(int r = 2; !queue.isEmpty(); r++) { //
            isFind = false;
            int top = queue.peek(); // get element from the top
            for (int j = 1; j <= n; j++) {
                if (graph[top][j] == 1 && top != j) {
                    if (BFS.get(j) == null) {   // check if this top already in list
                        BFS.put(j, BFCNum);
                        queue.add(j);

                        resultTable[r][0] = String.valueOf(j);
                        resultTable[r][1] = String.valueOf(BFCNum);
                        BFCNum++;
                        isFind = true;
                        break;
                    }
                }
            }
            if(!isFind) {
                resultTable[r][0] = "-";
                resultTable[r][1] = "-";
                queue.remove(); // delete element on the top
            }
            resultTable[r][2] = queue.toString();
//            if (BFCNum > n) {
//                break;
//            }
        }
        this.resultTable = resultTable;
    }

    @Override
    public void printResult() {
        System.out.println("BFS table");
        System.out.println("Top BFS  Queue");
        for(int i = 1; i < resultTable.length; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.printf("%-2s | ", resultTable[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public String[][] getResultTable() {
        return resultTable;
    }
}
