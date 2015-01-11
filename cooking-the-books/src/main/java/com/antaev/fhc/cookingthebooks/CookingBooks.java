package com.antaev.fhc.cookingthebooks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Date: 10.01.15
 * Time: 17:26
 * <p>
 * Run:
 * java -jar fhc-cooking-the-books-1.0-SNAPSHOT.jar input.txt > out.txt
 *
 * @author Evgeny Antaev
 */
public class CookingBooks {
    public static void main(String[] args) throws IOException {
        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        }

        try (Scanner in = inputFile == null ? new Scanner(System.in) : new Scanner(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int nCases = in.nextInt();
            for (int c = 1; c <= nCases; ++c) {
                out.write("Case #" + c);
                out.write(": ");
                String number = in.next();
                out.write(BookCooker.minimize(number));
                out.write(' ');
                out.write(BookCooker.maximize(number));
                out.write('\n');
            }

        }
    }
}
