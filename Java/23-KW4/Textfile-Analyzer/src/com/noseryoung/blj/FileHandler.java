package com.noseryoung.blj;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<Integer> wordsCount = new ArrayList<Integer>();

    public void readFile() throws IOException {
        String filename = "script";
        String path = "C:\\Source\\BLJ2022VaNus\\Java\\23-KW4\\Textfile-Analyzer\\src\\com\\noseryoung\\blj\\";
        File file = new File(path + filename + ".txt");
        Scanner input = new Scanner(file);

        int count = 0;
        int unique = 0;
        boolean found;
        int index = 0;

        while (input.hasNext()) {
            found = false;
            String word = input.next();
            word = word.toLowerCase();
            StringBuilder wordSB = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char charI = word.charAt(i);
                int ascii = (int) charI;
                if ((ascii < 64 || (ascii > 90 && ascii < 97) || ascii > 122) && (ascii != 39)) {
                    wordSB.deleteCharAt(i);
                    i = 1000;
                }
            }
            word = wordSB.toString();
            if (!word.equals("")) {

                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).equals(word)) {
                        index = i;
                        found = true;
                    }
                }
                if (found) {
                    int before = wordsCount.get(index);
                    int after = before + 1;
                    wordsCount.set(index, after);
                } else {
                    words.add(word);
                    wordsCount.add(1);
                    unique++;
                }
                count = count + 1;
            }
        }
        int highestAmount = 0;
        int highestIndex = 0;

        for (int i = 0; i < wordsCount.size(); i++) {
            if (wordsCount.get(i) > highestAmount) {
                highestIndex = i;
                highestAmount = wordsCount.get(i);
            }
        }
        Sort sort = new Sort();
        sort.sort("DESC", words, wordsCount);


        FileWriter write = new FileWriter();
        write.write(path, filename, unique, count, words.get(highestIndex), words, wordsCount);
    }
}
