package com.university;

import junit.framework.TestCase;

public class TaskOneTest extends TestCase {
    public void testGetFactorial() {
        int actual = TaskOne.getFactorial(5);
        int expected = 120;
        assertEquals(actual, expected);
    }

    public void testFindMinHigher() {
        int[] t = {4, 5, 1, 2, 5, 1, 3};
        int actual = TaskOne.findMinHigher(t, 3);
        int expected = 6;
        assertEquals(actual, expected);
    }
}