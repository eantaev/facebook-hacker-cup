package com.antaev.fhc.autocomplete;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ATrieTest {
    private ATrie trie;

    @Before
    public void before() {
        trie = new ATrie();
    }

    @Test
    public void test() {
        assertStepsToIdentifyKeyEquals(1, "hi");
        assertStepsToIdentifyKeyEquals(2, "hello");
        assertStepsToIdentifyKeyEquals(1, "lol");
        assertStepsToIdentifyKeyEquals(3, "hills");
        assertStepsToIdentifyKeyEquals(4, "hill");
    }

    private void assertStepsToIdentifyKeyEquals(int expectedSteps, String key) {
        trie.add(key);
        assertEquals(expectedSteps, trie.countStepsToIdentifyKey(key));
    }
}