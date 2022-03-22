package com.university;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskOneTest {

    @Test
    public void getFactorial() {
        int actual = TaskOne.getFactorial(4);
        int expected = 24;
        assertEquals(actual, expected);
    }

    @Test
    public void resolveTask() {
        int actual = TaskOne.resolveTask(7, 3);
        int expected = 210;
        assertEquals(actual, expected);
    }
}