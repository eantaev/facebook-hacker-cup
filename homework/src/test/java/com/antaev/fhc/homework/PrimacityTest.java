package com.antaev.fhc.homework;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimacityTest {
    private static final int MAX_NUMBER = 10000000;

    private static Primacity p;

    @BeforeClass
    public static void beforeClass() {
        p = Primacity.forPositivesUpTo(MAX_NUMBER);
    }

    @Test
    public void simpleInput() {
        assertEquals(5, p.countNumbersWithPrimacity(5, 15, 2));
        assertEquals(7, p.countNumbersWithPrimacity(2, 10, 1));
        assertEquals(2, p.countNumbersWithPrimacity(24, 42, 3));
        assertEquals(0, p.countNumbersWithPrimacity(1000000, 1000000, 1));
        assertEquals(1, p.countNumbersWithPrimacity(1000000, 1000000, 2));
    }
}