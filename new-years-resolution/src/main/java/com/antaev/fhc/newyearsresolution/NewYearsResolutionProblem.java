package com.antaev.fhc.newyearsresolution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

import static com.antaev.fhc.newyearsresolution.Triple.triple;
import static com.google.common.collect.Lists.newArrayListWithCapacity;

/**
 * Date: 11.01.15
 * Time: 19:55* <p/>
 * Run:
 * java -jar fhc-new-years-resolution-1.0-SNAPSHOT.jar input.txt > out.txt
 *
 * @author Evgeny Antaev
 */
public final class NewYearsResolutionProblem {
    public static void main(String[] args) throws IOException {
        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        }

        try (Scanner in = inputFile == null ? new Scanner(System.in) : new Scanner(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int nCases = in.nextInt();
            for (int c = 1; c <= nCases; ++c) {

                Triple target = triple(in.nextInt(), in.nextInt(), in.nextInt());

                int foodCount = in.nextInt();
                List<Triple> foods = newArrayListWithCapacity(foodCount);
                for (int food = 0; food < foodCount; ++food) {
                    foods.add(triple(in.nextInt(), in.nextInt(), in.nextInt()));
                }

                out.write("Case #" + c);
                out.write(": ");
                out.write(Solver.isReachable(target, foods) ? "yes" : "no");
                out.write('\n');
            }
        }
    }
}