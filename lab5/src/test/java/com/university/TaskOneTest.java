package com.university;

import static org.junit.Assert.*;

public class TaskOneTest {

    @org.junit.Test
    public void cartesianProd() {
        String[] A = {"1", "2"};
        String[] B = {"a", "b", "c"};
        String[] actual = TaskOne.cartesianProd(A, B);
        String[] expected = {"1a", "1b", "1c", "2a", "2b", "2c"};
        assertEquals(expected, actual);
    }
}