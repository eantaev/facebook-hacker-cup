package com.antaev.fhc.corporategifting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.antaev.fhc.corporategifting.GiftTree.optimalCost;
import static com.google.common.base.Charsets.UTF_8;

/**
 * Date: 18.01.15
 * Time: 17:21
 * Run:
 * java -Xss25m -jar fhc-corporategifting-1.0-SNAPSHOT.jar
 *
 * @author Evgeny Antaev
 */
public final class CorporateGifting {
    public static void main(String[] args) throws IOException {

        try (BufferedReader in = Files.newBufferedReader(Paths.get("./work/corporate_gifting.txt"), UTF_8);
             BufferedWriter out = Files.newBufferedWriter(Paths.get("./work/output.txt"), UTF_8)) {

            int nCases = Integer.parseInt(in.readLine());
            for (int c = 1; c <= nCases; ++c) {
                int numOfEmployees = Integer.parseInt(in.readLine());
                int[] hierarchy = new int[numOfEmployees];
                int employeeId = 0;
                for (String s : in.readLine().split(" ")) {
                    hierarchy[employeeId] = Integer.parseInt(s);
                    ++employeeId;
                }
                String caseHead = "Case #" + c;
                System.out.println(caseHead);
                out.write(caseHead);
                out.write(": ");
                out.write(Integer.toString(optimalCost(hierarchy)));
                out.write('\n');
            }
        }
        System.out.println("Done!");
    }
}
