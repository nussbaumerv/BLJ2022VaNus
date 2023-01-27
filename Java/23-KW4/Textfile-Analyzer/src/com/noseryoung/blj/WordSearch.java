package com.noseryoung.blj;

import java.util.ArrayList;

public class WordSearch {
    public int searchWordFinal(String wordToFind, ArrayList<String> words){
        int position = 0;
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).equals(wordToFind)){
                position = i + 9;
            }
        }
        return position;
    }
    public ArrayList<Integer> searchWordOriginal(String wordToFind, ArrayList<String> words){
        ArrayList<Integer> wordPositions = new ArrayList<Integer>();
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).equals(wordToFind)){
                wordPositions.add(i+1);
            }
        }
        return wordPositions;
    }
}
