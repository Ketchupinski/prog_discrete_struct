package com.graph.search;

import com.graph.matrix.AdjacencyMatrix;

import java.util.*;

/**
 * 1. Обійти граф пошуком углиб. Користувач вводить початкову вершину
 * графу. Програма виконує обхід графу, починаючи з вказаної початкової
 * вершини. На екран виводиться протокол обходу – таблиця, яка містить
 * наступні дані по кожній ітерації алгоритму обходу: поточна вершина, її
 * DFS-номер, вміст стеку.
 * @author Arsen Savhsak
 * @version 1.0
 */
public class DFS implements SearchAlgorithmI {

    private String[][] resultTable;

    @Override
    public void matrixSearch(AdjacencyMatrix matrix, int startTop) {
        Map<Integer, Integer> DFS = new HashMap<>(); // HashMap to write DFS results
        Stack<Integer> stack = new Stack<>();

        int m = matrix.getM();
        int n = matrix.getN();
        int[][] graph = matrix.getMatrix();
        String[][] resultTable = new String[n * 2 + 1][3];


        DFS.put(startTop, 1);
        stack.push(startTop);
        resultTable[1][0] = stack.peek().toString();
        resultTable[1][1] = String.valueOf(1);
        resultTable[1][2] = stack.toString();


        int BFCNum = 2;
        boolean isFind;

        for(int r = 2; !stack.isEmpty(); r++) { //
            isFind = false;
            int top = stack.peek(); // get element from the top
            for (int j = 1; j <= n; j++) {
                if (graph[top][j] == 1 && top != j) {
                    if (DFS.get(j) == null) {   // check if this top already in list
                        DFS.put(j, BFCNum);
                        stack.push(j);

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
                stack.pop(); // delete element on the top
            }
            resultTable[r][2] = stack.toString();
//            if (BFCNum > n) {
//                break;
//            }
        }
        this.resultTable = resultTable;
    }

    @Override
    public void printResult() {
        System.out.println("DFS table");
        System.out.println("Top DFS  Stack");
        for(int i = 1; i < resultTable.length; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.printf("%-2s | ", resultTable[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public String[][] getResultTable() {
        return this.resultTable;
    }
}
