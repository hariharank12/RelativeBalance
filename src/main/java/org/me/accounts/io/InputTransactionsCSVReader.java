package org.me.accounts.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class InputTransactionsCSVReader {

    public String[][] readCSV() {
        String[][] transactionValues = new String[100][10];
        String line;
        String cvsSplitBy = ",";
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().
                getClassLoader().getResourceAsStream("inputTransactions.csv")))) {
            while ((line = br.readLine()) != null) {
                transactionValues[lineCount++] = line.split(cvsSplitBy);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return transactionValues;
    }
}
