package com.noseryoung.blj;

import java.util.ArrayList;

public class Sort {
    public void sort(String method, ArrayList<String> words, ArrayList<Integer> wordsCount){
        if(method.equals("ASC")) {
            for (int i = 0; i < wordsCount.size() - 1; i++) {
                for (int j = 0; j < wordsCount.size() - i - 1; j++) {
                    if (wordsCount.get(j) > wordsCount.get(j + 1)) {
                        int temp = wordsCount.get(j);
                        wordsCount.set(j, wordsCount.get(j + 1));
                        wordsCount.set(j + 1, temp);

                        String tempW = words.get(j);
                        words.set(j, words.get(j + 1));
                        words.set(j + 1, tempW);
                    }
                }
            }
        }else if(method.equals("DESC")){
            for (int i = 0; i < wordsCount.size() - 1; i++) {
                for (int j = 0; j < wordsCount.size() - i - 1; j++) {
                    if (wordsCount.get(j) < wordsCount.get(j + 1)) {
                        int temp = wordsCount.get(j);
                        wordsCount.set(j, wordsCount.get(j + 1));
                        wordsCount.set(j + 1, temp);

                        String tempW = words.get(j);
                        words.set(j, words.get(j + 1));
                        words.set(j + 1, tempW);
                    }
                }
            }
        }



    }
}
