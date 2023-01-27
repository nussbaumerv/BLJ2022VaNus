package com.noseryoung.blj;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<Integer> wordsCount = new ArrayList<Integer>();
    private String  sortMethond = "DESC";
    private boolean doStopWord = false;

    int count = 0;
    int unique = 0;
    boolean found;
    int index = 0;

    public FileHandler(String sortMethond, boolean doStopWord){
        this.sortMethond = sortMethond;
        this.doStopWord = doStopWord;
    }
    public void processWord(String word){
        found = false;
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
            count++;
        }

    }
    public void readFile() throws IOException {
        StopWordsDetect stopWord = new StopWordsDetect();
        String filename = "script";
        String path = "C:\\Source\\BLJ2022VaNus\\Java\\23-KW4\\Textfile-Analyzer\\src\\com\\noseryoung\\blj\\";
        File file = new File(path + filename + ".txt");
        Scanner input = new Scanner(file);


        while (input.hasNext()) {
            String word = input.next();
            word = word.toLowerCase();

            if(doStopWord){
                if(stopWord.detectWord(word)){
                    processWord(word);
                }
            } else{
                processWord(word);
            }
        }
        int highestAmount = 0;
        int highestIndex = 0;

        int longestLength = 0;
        int longestIndex = 0;

        Sort sort = new Sort();
        sort.sort(sortMethond, words, wordsCount);

        for (int i = 0; i < wordsCount.size(); i++) {
            if (wordsCount.get(i) > highestAmount) {
                highestIndex = i;
                highestAmount = wordsCount.get(i);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > longestLength) {
                longestIndex = i;
                longestLength = words.get(i).length();
            }
        }

        FileWriter write = new FileWriter();
        write.write(path, filename, unique, count, words.get(highestIndex), words.get(longestIndex), longestLength, words, wordsCount);
    }
}
