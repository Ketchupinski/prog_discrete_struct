package com.university;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTwoTest {

    @Test
    public void resolveTask() {
        int[][] F = TaskTwo.fillTable(5);
        F = TaskTwo.completeTable(F);
        int actual = F[3][2];
        int expected = 6;
        assertEquals(actual, expected);
    }
}