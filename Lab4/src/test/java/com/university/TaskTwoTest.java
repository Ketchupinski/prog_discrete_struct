package com.university;

import junit.framework.TestCase;

public class TaskTwoTest extends TestCase {

    public void testGetK() {
        int actual = TaskTwo.getK(6, 4);
        int expected = 15;
        assertEquals(expected, actual);
    }
}