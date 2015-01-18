package com.antaev.fhc.autocomplete;

import java.io.*;

/**
 * Date: 18.01.15
 * Time: 4:53
 * <p>
 * Run:
 * java -jar fhc-autocomplete-1.0-SNAPSHOT.jar input.txt > out.txt
 *
 * @author Evgeny Antaev
 */
public class AutocompleteProblem {
    public static void main(String[] args) throws IOException {
        File inputFile = null;
        if (args.length > 0) {
            inputFile = new File(args[0]);
        }


        try (BufferedReader in = inputFile == null
            ? new BufferedReader(new InputStreamReader(System.in))
            : new BufferedReader(new FileReader(inputFile));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int nCases = Integer.parseInt(in.readLine());
            for (int c = 1; c <= nCases; ++c) {
                int numOfWords = Integer.parseInt(in.readLine());

                String[] words = new String[numOfWords];
                for (int w = 0; w < numOfWords; ++w) {
                    words[w] = in.readLine();
                }

                out.write("Case #" + c);
                out.write(": ");
                out.write(Integer.toString(Autocomplete.countCharactersToTypeAMessage(words)));
                out.write('\n');
            }
        }
    }
}
