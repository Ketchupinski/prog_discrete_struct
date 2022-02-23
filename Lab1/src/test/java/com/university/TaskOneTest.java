package com.university;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskOneTest {
    TaskOne t = new TaskOne(true, false);

    @Test
    public void findLogicConjunction() {
        boolean actual = t.findLogicConjunction();
        assertFalse(actual);
    }

    @Test
    public void findLogicDisjunction() {
        boolean actual = t.findLogicDisjunction();
        assertTrue(actual);
    }

    @Test
    public void findStrictDisjunction() {
        boolean actual = t.findStrictDisjunction();
        assertTrue(actual);
    }

    @Test
    public void findLogicImplicationOne() {
        boolean actual = t.findLogicImplicationOne();
        assertFalse(actual);
    }

    @Test
    public void findLogicImplicationTwo() {
        boolean actual = t.findLogicImplicationTwo();
        assertTrue(actual);
    }

    @Test
    public void findLogicEquivalence() {
        boolean actual = t.findLogicEquivalence();
        assertFalse(actual);
    }
}