package com.graph.algorithms;

import com.graph.analyze.AnalyzeGraph;
import com.graph.matrix.AdjacencyMatrix;
import com.graph.matrix.MatrixService;

import java.util.*;

public class ColoringGraph {
    Map<Integer, Integer> colorsMap;

    public ColoringGraph(AdjacencyMatrix adjacencyMatrix) {
        Queue<Integer> tops = sortDeg(adjacencyMatrix);
        Map<Integer, Integer> colors = new HashMap<>();

        int[][] matrix = adjacencyMatrix.getMatrix();

        int color = 0;
        while(!tops.isEmpty()) {
            color++;
            int top = tops.poll();
            colors.put(top, color);

            Iterator<Integer> iterator = tops.iterator();
            while(iterator.hasNext()) {
                int elem = iterator.next();
                boolean canBeColored = true;
                for(int element : colors.keySet()) {
                    if (colors.get(element) == color) {
                        if (matrix[elem][element] == 1 || matrix[element][elem] == 1) {
                            canBeColored = false;
                            break;
                        }
                    }
                }
                if (canBeColored) {
                    colors.put(elem, color);
                    iterator.remove();
                }
            }
        }
        this.colorsMap = colors;
    }

    public Queue<Integer> sortDeg(AdjacencyMatrix adjacencyMatrix) {
        AnalyzeGraph analyze = new AnalyzeGraph();
        Queue<Integer> tops = new LinkedList<>();
        MatrixService service = new MatrixService();

        int[][] outDeg = analyze.FindOutDegrees(adjacencyMatrix);
        service.printTopsResult(outDeg, "Out");

        while(tops.size() != adjacencyMatrix.getN()) {
            int max = -1;
            int maxTop = 0;
            for (int i = 1; i <= adjacencyMatrix.getN(); i++) {
                if (!tops.contains(i)) {
                    if (outDeg[i][1] > max) {
                        maxTop = outDeg[i][0];
                        max = outDeg[i][1];
                    }
                }
            }
            if (maxTop != 0) {
                tops.add(maxTop);
            }
        }
        System.out.println("Sorted queue: " + Arrays.toString(tops.toArray()));
        return tops;
    }

    public Map<Integer, Integer> getColorsMap() {
        return colorsMap;
    }
}
