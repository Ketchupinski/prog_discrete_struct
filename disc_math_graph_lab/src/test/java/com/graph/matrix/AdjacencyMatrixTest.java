package com.graph.matrix;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AdjacencyMatrixTest {

    @Test
    public void getMatrix() {
        int[][] E = {{2, 2}, {1, 2}, {2, 1}};
        AdjacencyMatrix aMatrix = new AdjacencyMatrix(E);
        int[][] actual = aMatrix.getMatrix();
        int[][] expected = {{0, 0}, {0, 1}, {1, 0}};
        assertEquals(actual.length, expected.length);
    }
}