package com.antaev.fhc.autocomplete;

/**
 * Date: 18.01.15
 * Time: 5:37
 *
 * @author Evgeny Antaev
 */
public final class Autocomplete {

    public static int countCharactersToTypeAMessage(String[] words) {
        Trie t = new Trie();
        int count = 0;
        for (String word : words) {
            t.add(word);
            count += t.countStepsToIdentifyKey(word);
        }
        return count;
    }

    private Autocomplete() {
    }
}
