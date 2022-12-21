package com.noseryoung.blj;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<String> words = new ArrayList<String>();

    public void initializeWords() throws IOException {
        File file = new File("C:\\Users\\nussb\\Downloads\\wordList.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String readWord;

        while ((readWord = reader.readLine()) != null) {
            words.add(readWord);
        }

    }

    Words() throws IOException {
        initializeWords();


    }

    public String getWord(){
        Random rand = new Random();
        int index = rand.nextInt(words.size());

        return words.get(index);
    }
}
