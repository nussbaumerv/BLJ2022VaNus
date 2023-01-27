package com.noseryoung.blj;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileWriter {
    public boolean write(String path, String fileName, int uWords, int tWords, String mCWord, String longestWord, int longestLength, ArrayList<String> words, ArrayList<Integer> wordsCount, String doStopWord, String orderingMethod) {
        boolean successful = true;
        try {
            java.io.FileWriter writer = new java.io.FileWriter(path + fileName + "_evaluation.txt");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/HH:mm");
            LocalDateTime now = LocalDateTime.now();

            writer.write("" +
                    "---------------------------------------------------------\n" +
                    dtf.format(now) + "   |    " + fileName + ".txt\n" +
                    "---------------------------------------------------------\n" +
                    "Number of unique words: \t" + uWords + "\n" +
                    "Total number of words: \t" + tWords + "\n" +
                    "Most common word: \t" + mCWord + "\n" +
                    "Longest word: \t'" + longestWord + "' (" + longestLength + " Characters)\n" +
                    "Stop words: \t"+ doStopWord + "\n" +
                    "Sorting method: \t" + orderingMethod + "\n" +
                    "---------------------------------------------------------\n");

            for(int i = 0; i < words.size(); i++){
                writer.write(words.get(i) + "\t" + wordsCount.get(i) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            successful = false;
        }
        return successful;
    }
}