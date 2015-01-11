package com.antaev.fhc.cookingthebooks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Date: 10.01.15
 * Time: 17:26
 *
 * @author Evgeny Antaev
 */
public final class BookCooker {
    public static String maximize(String number) {
        char[] digits = number.toCharArray();
        maximize(digits, 0);
        return String.valueOf(digits);
    }

    public static String minimize(String number) {
        char[] digits = number.toCharArray();
        minimize(digits, 0);
        return String.valueOf(digits);
    }

    private static void maximize(char[] digits, int offset) {
        if (offset == digits.length - 1) {
            return;
        }
        char max = digits[offset];
        int maxIndex = offset;

        for (int i = offset + 1; i < digits.length; ++i) {
            if (digits[i] > max) {
                max = digits[i];
                maxIndex = i;
            }
        }
        if (maxIndex == offset) {
            maximize(digits, offset + 1);
        } else {
            swap(digits, offset, maxIndex);
        }
    }

    private static void minimize(char[] digits, int offset) {
        if (digits[offset] == 0) {
            ++offset;
        }
        if (offset == digits.length - 1) {
            return;
        }
        char min = digits[offset];
        int minIndex = offset;
        for (int i = offset + 1; i < digits.length; ++i) {
            if (digits[i] < min && digits[i] != '0') {
                min = digits[i];
                minIndex = i;
            }
        }
        if (minIndex == offset) {
            minimize(digits, offset + 1);
        } else {
            swap(digits, offset, minIndex);
        }
    }

    private static void swap(char[] digits, int i, int j) {
        char t = digits[i];
        digits[i] = digits[j];
        digits[j] = t;
    }

    @Test
    public void maximize() {
        assertEquals("523", maximize("325"));
        assertEquals("532", maximize("523"));
        assertEquals("532", maximize("532"));

        assertEquals("51324", maximize("31524"));
        assertEquals("987", maximize("897"));
        assertEquals("321", maximize("123"));
        assertEquals("10", maximize("10"));
        assertEquals("5", maximize("5"));
    }

    @Test
    public void minimize() {
        assertEquals("235", minimize("325"));
        assertEquals("235", minimize("253"));
        assertEquals("235", minimize("235"));
        assertEquals("305", minimize("305"));

        assertEquals("13524", minimize("31524"));
        assertEquals("798", minimize("897"));
        assertEquals("123", minimize("123"));
        assertEquals("10", minimize("10"));
        assertEquals("5", minimize("5"));
    }
}
