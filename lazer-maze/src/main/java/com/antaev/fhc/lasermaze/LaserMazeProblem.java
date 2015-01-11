package com.antaev.fhc.lasermaze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import static com.antaev.fhc.lasermaze.MazePaths.findOptimalPathLength;

/**
 * Date: 10.01.15
 * Time: 21:39
 * <p/>
 * Run:
 * java -jar fhc-laser-maze-1.0-SNAPSHOT.jar input.txt > out.txt
 *
 * @author Evgeny Antaev
 */
public final class LaserMazeProblem {
    public static void main(String[] args) throws IOException {
        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        }

        try (Scanner in = inputFile == null ? new Scanner(System.in) : new Scanner(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int nCases = in.nextInt();
            for (int c = 1; c <= nCases; ++c) {

                int rows = in.nextInt();
                in.nextInt(); // cols
                in.nextLine();
                String[] board = new String[rows];
                for (int row = 0; row < rows; ++row) {
                    board[row] = in.nextLine();
                }

                int pathLength = findOptimalPathLength(Maze.create(board));

                out.write("Case #" + c);
                out.write(": ");
                out.write(pathLength == -1 ? "impossible" : Integer.toString(pathLength));
                out.write('\n');
            }
        }
    }
}
