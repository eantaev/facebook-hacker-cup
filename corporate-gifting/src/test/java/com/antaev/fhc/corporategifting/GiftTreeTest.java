package com.antaev.fhc.corporategifting;

import org.junit.Test;

import static com.antaev.fhc.corporategifting.GiftTree.optimalCost;
import static org.junit.Assert.assertEquals;

public class GiftTreeTest {
    @Test
    public void simpleInput() {
        assertEquals(4, optimalCost(0, 1, 1));
        assertEquals(10, optimalCost(0, 1, 1, 2, 2, 3, 3, 3));
        assertEquals(7, optimalCost(0, 1, 2, 3, 4));
        assertEquals(12, optimalCost(0, 1, 2, 3, 4, 5, 5, 5, 5));
        assertEquals(11, optimalCost(0, 1, 1, 1, 1, 2, 2, 2));
    }
}