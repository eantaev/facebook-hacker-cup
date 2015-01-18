package com.antaev.fhc.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Date: 18.01.15
 * Time: 4:27
 * <p/>
 * java -jar fhc-homework-1.0-SNAPSHOT.jar input.txt > out.txt
 *
 * @author Evgeny Antaev
 */
public class PrimacityProblem {

    private static final int MAX_NUMBER = 10000000;

    public static void main(String[] args) throws IOException {
        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        }

        Primacity pr = Primacity.forPositivesUpTo(MAX_NUMBER);

        try (Scanner in = inputFile == null ? new Scanner(System.in) : new Scanner(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int nCases = in.nextInt();
            for (int c = 1; c <= nCases; ++c) {

                int left = in.nextInt();
                int right = in.nextInt();
                int primacity = in.nextInt();

                out.write("Case #" + c);
                out.write(": ");
                out.write(Integer.toString(
                        pr.countNumbersWithPrimacity(left, right, primacity)
                    )
                );
                out.write('\n');
            }
        }
    }

}