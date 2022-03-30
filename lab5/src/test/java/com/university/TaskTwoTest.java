package com.university;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TaskTwoTest {

    @Test
    public void fillArray() {
        int[] arr = new int[3];
        int[] actual = TaskTwo.fillArray(arr);
        System.out.println(Arrays.toString(arr));
        int[] expected = {1, 2, 3};
        assertEquals(expected[1], actual[1]);
    }
}