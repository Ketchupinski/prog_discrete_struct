package com.graph.analyze;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnalyzeGraphTest {

    @Test
    public void isHomogeneous() {
        AnalyzeGraph analyze = new AnalyzeGraph();
        int[][] test = {{1, 1}, {2, 1}};
        int actual = analyze.isHomogeneous(test, test);
        int expected = 1;
        assertEquals(expected, actual);
    }
}