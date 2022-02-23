package com.university;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTwoTest {

    @Test
    public void findLogicConjunction() {
        String actual = TaskTwo.findLogicConjunction();
        String expected = "000011000";
        assertEquals(actual, expected);
    }

    @Test
    public void findLogicDisjunction() {
        String actual = TaskTwo.findLogicDisjunction();
        String expected = "111011110";
        assertEquals(actual, expected);
    }

    @Test
    public void findStrictDisjunction() {
        String actual = TaskTwo.findStrictDisjunction();
        String expected = "111000110";
        assertEquals(actual, expected);
    }
}