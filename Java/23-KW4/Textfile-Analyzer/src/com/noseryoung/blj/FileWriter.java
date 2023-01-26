package com.noseryoung.blj;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWriter {
    public void write(String fileName, int uWords, int tWords, String mCWord) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(fileName + "_evaluation.txt");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/HH:mm");
            LocalDateTime now = LocalDateTime.now();

            writer.write("" +
                    dtf.format(now) + "   |    " + fileName + ".txt\n" +
                    "-----------------------------------------\n" +
                    "Number of Unique words: \t" + uWords + "\n" +
                    "Total number of words: \t" + tWords + "\n" +
                    "Most Common Word: \t" + mCWord +
                    "\n-----------------------------------------\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}