package com.antaev.fhc.homework;

import com.google.common.base.Preconditions;

/**
 * Date: 18.01.15
 * Time: 3:55
 *
 * @author Evgeny Antaev
 */
public final class Primacity {
    private final int[] primData;

    private Primacity(int maxNumber) {
        primData = computePrimacityArray(maxNumber);
    }

    public int countNumbersWithPrimacity(int left, int right, int primacity) {
        if (left > right) {
            return 0;
        }
        int count = 0;
        for (int v = left; v <= right; ++v)
            if (primData[v] == primacity)
                ++count;
        return count;
    }

    public static Primacity forPositivesUpTo(int maxNumber) {
        Preconditions.checkArgument(maxNumber > 0);
        Primacity p = new Primacity(maxNumber);
        return p;
    }

    private static int[] computePrimacityArray(int maxNumber) {
        int[] pr = new int[maxNumber + 1];

        for (int v = 2; v <= maxNumber; ++v) {
            if (pr[v] == 0) { // v is prime
                pr[v] = 1;
                int j = v * 2;
                while (j <= maxNumber) {
                    ++pr[j];
                    j += v;
                }
            }
        }

        return pr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int v = 2; v < primData.length; v++) {
            sb.append(v);
            sb.append(':');
            sb.append(primData[v]);
            sb.append(' ');
        }
        sb.append('}');
        return sb.toString();
    }
}
