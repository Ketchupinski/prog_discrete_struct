package com.university;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void solveOperations() {
        int[][] expected = {{0, 0, 0, 1, 1, 1, 1},
                            {1, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 1, 1, 1, 1},
                            {1, 1, 0, 0, 1, 0, 0},
                            {0, 0, 1, 1, 1, 1, 1},
                            {1, 0, 1, 0, 0, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 0, 1, 1, 1}};
        Task t = new Task();
        t.solveOperations();
        int[][] actual = t.getTable();
        assertArrayEquals(expected, actual);

    }
}