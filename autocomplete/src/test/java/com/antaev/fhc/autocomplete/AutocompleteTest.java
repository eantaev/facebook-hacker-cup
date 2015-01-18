package com.antaev.fhc.autocomplete;

import org.junit.Test;

import static com.antaev.fhc.autocomplete.Autocomplete.countCharactersToTypeAMessage;
import static org.junit.Assert.assertEquals;

public class AutocompleteTest {
    @Test
    public void simpleInput() {
        assertEquals(11, countCharactersToTypeAMessage(new String[]{
            "hi",
            "hello",
            "lol",
            "hills",
            "hill"
        }));

        assertEquals(15, countCharactersToTypeAMessage(new String[]{
            "a",
            "aa",
            "aaa",
            "aaaa",
            "aaaaa"
        }));

        assertEquals(11, countCharactersToTypeAMessage(new String[]{
            "aaaaa",
            "aaaa",
            "aaa",
            "aa",
            "a"
        }));

        assertEquals(9, countCharactersToTypeAMessage(new String[]{
            "to",
            "be",
            "or",
            "not",
            "to",
            "bee"
        }));

        assertEquals(3, countCharactersToTypeAMessage(new String[]{
            "hading",
            "fun",
            "yet"
        }));
    }
}