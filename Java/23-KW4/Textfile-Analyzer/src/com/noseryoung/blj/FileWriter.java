package com.noseryoung.blj;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileWriter {
    public void write(String path, String fileName, int uWords, int tWords, String mCWord, ArrayList<String> words, ArrayList<Integer> wordsCount) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(path + fileName + "_evaluation.txt");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/HH:mm");
            LocalDateTime now = LocalDateTime.now();

            writer.write("" +
                    dtf.format(now) + "   |    " + fileName + ".txt\n" +
                    "-----------------------------------------\n" +
                    "Number of Unique words: \t" + uWords + "\n" +
                    "Total number of words: \t" + tWords + "\n" +
                    "Most Common Word: \t" + mCWord +
                    "\n-----------------------------------------\n");
            for(int i = 0; i < words.size(); i++){
                writer.write(words.get(i) + "\t" + wordsCount.get(i) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}