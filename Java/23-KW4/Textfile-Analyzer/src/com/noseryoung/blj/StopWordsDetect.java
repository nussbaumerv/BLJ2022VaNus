package com.noseryoung.blj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StopWordsDetect {
   public boolean detectWord(String word) throws IOException {
        File file = new File("C:\\Source\\BLJ2022VaNus\\Java\\23-KW4\\Textfile-Analyzer\\src\\com\\noseryoung\\blj\\stopwords.txt");
        Scanner input = new Scanner(file);

        boolean notStopWord = true;

        while (input.hasNext()) {
            String currentStopword = input.next();
            currentStopword = currentStopword.toLowerCase();

            if (currentStopword.equals(word)) {
                notStopWord = false;
            }

        }
        return notStopWord;
    }


}

