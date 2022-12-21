package com.noseryoung.blj;

public class Field {
    private String correctWord;
    private String[][] field = new String[5][6];

    Field() {

    }

    public void addWord(String inputWord) {
        String[] arrInput = inputWord.split("", 5);
        int index = 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                if (field[c][r] == null) {
                    if (index < 5) {
                        field[c][r] = arrInput[index];
                        index++;
                    }
                }
            }
        }
    }



    public void print() {
        String[] arrCorrect = correctWord.split("", 5);

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                System.out.print("\033[0;107m");
                if (arrCorrect[c].equals(field[c][r])) {
                    System.out.print("\033[0;102m");

                } else {
                    for (int i = 0; i < 5; i++) {
                        if (arrCorrect[i].equals(field[c][r])) {
                            System.out.print("\033[0;103m");

                        }
                    }
                }
                System.out.print("\033[1;90m");
                if (field[c][r] == null) {
                    System.out.print("   \033[0m");

                } else {
                    System.out.print(" " + field[c][r] + " \033[0m");
                }
            }
            System.out.println();
        }


    }

    public boolean checkIfCorrect(String inputWord) {
        boolean result = false;
        if (inputWord.equals(correctWord)) {
            result = true;
        }
        return result;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }
}
