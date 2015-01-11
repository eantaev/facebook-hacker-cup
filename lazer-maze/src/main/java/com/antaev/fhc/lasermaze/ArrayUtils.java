package com.antaev.fhc.lasermaze;

import java.util.Arrays;

/**
 * Date: 10.01.15
 * Time: 23:23
 *
 * @author Evgeny Antaev
 */
public final class ArrayUtils {

    public static char[][] copyOf(char[][] orig) {
        char[][] copy = new char[orig.length][];

        System.arraycopy(orig, 0, copy, 0, orig.length);

        for (int i = 0; i < orig.length; i++) {
            copy[i] = Arrays.copyOf(orig[i], orig[i].length);
        }

        return copy;
    }

    public static String toString(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            sb.append(row);
            sb.append('\n');
        }
        return sb.toString();
    }

    private ArrayUtils() {
        throw new UnsupportedOperationException();
    }
}
