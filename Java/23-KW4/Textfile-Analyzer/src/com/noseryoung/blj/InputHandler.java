package com.noseryoung.blj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    private String[] sortOption = {"No sorting", "ASC", "DESC"};
    private boolean[] stopOption = {true, false};

    private String ANSI_RED_BACKGROUND = "\u001B[41m";
    private String ANSI_GREEN_BACKGROUND = "\033[42m";
    private String ANSI_RESET = "\033[0m";
    private String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public String textValidation(String question) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        String input = "";

        do {
            System.out.println(question);
            System.out.print("Enter Text: ");
            try {
                input = scan.nextLine();
                if (input.length() >= 1) {
                    valid = true;
                } else {
                    System.out.println("\n" + ANSI_RED_BACKGROUND + " Invalid Input " + ANSI_RESET + "\n");
                }
            } catch (Exception e) {
                System.out.println("\n" + ANSI_RED_BACKGROUND + " Invalid Input " + ANSI_RESET + "\n");
            }
        } while (!valid);
        System.out.println("\n******************************************\n");
        return input;

    }

    public int optionValidation(String question, String[] answers) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int input = 0;

        do {
            System.out.println(question);
            for (int i = 0; i < answers.length; i++) {
                System.out.println("  " + i + ": " + answers[i]);
            }
            System.out.print("Select option: ");
            try {
                input = scan.nextInt();
                if (input >= 0 && input < answers.length) {
                    valid = true;
                } else {
                    System.out.println("\n" + ANSI_RED_BACKGROUND + " Invalid Input " + ANSI_RESET + "\n");
                }
            } catch (Exception e) {
                System.out.println("\n" + ANSI_RED_BACKGROUND + " Invalid Input " + ANSI_RESET + "\n");
            }
            scan.nextLine();
        } while (!valid);
        System.out.println("\n******************************************\n");
        return input;
    }

    public void menuPrompt() throws IOException {
        boolean successful;
        int ordering = 2;
        int stopWords = 1;

        System.out.println("\n" + ANSI_BLUE_BACKGROUND + "                 Textfile Analyzer                  " + ANSI_RESET + "\n");


        int defaultSettings = optionValidation("Do wo want to use the default Settings?", new String[]{"Yes", "No"});
        if (defaultSettings == 1) {
            ordering = optionValidation("How do you want to Sort the data?", new String[]{"Don't sort it", "ASC by most common Words", "DESC by most common Words"});
            stopWords = optionValidation("Do wo want to exclude the Stop Words?", new String[]{"Yes", "No"});

        }
        FileHandler fHandler = new FileHandler(sortOption[ordering], stopOption[stopWords]);
        successful = fHandler.readFile(1);
        ArrayList<String> words = fHandler.getWords();

        if (successful) {

            System.out.println("\n" + ANSI_GREEN_BACKGROUND + "          File got successfully Generated           " + ANSI_RESET + "\n");
            int searchWords = optionValidation("Do wo want to search a Specific Word?", new String[]{"Yes", "No"});
            if (searchWords == 0) {
                boolean keepDoing = true;
                do {
                    int searchOption = optionValidation("Where do you want to search?", new String[]{"In the generated file", "In the input file", "Exit"});
                    WordSearch wordSearch = new WordSearch();

                    if (searchOption == 0) {
                        String wordToSearch = textValidation("What word do you want to find?");
                        int wordPositionFinal = wordSearch.searchWordFinal(wordToSearch, words);
                        if(wordPositionFinal == 0){
                            System.out.println("\n" + ANSI_RED_BACKGROUND + " Word not found " + ANSI_RESET + "\n");
                        } else {
                            System.out.println("The word '" + wordToSearch + "' was found on Line " + wordPositionFinal + ". \n");
                        }
                    } else if (searchOption == 1) {
                        String wordToSearch = textValidation("What word do you want to find?");
                        try {
                            ArrayList<String> wordsRaw = fHandler.getWordsRaw();
                            ArrayList<Integer> wordPositions = wordSearch.searchWordOriginal(wordToSearch, wordsRaw);
                            System.out.println("The word '" + wordToSearch + "' was found on Position " + wordPositions.get(0) + ". and at " + (wordPositions.size() -1) + ". other Positions\n");

                            int printFindOption = optionValidation("Do you want to print the other Positions?", new String[]{"Yes", "No"});
                            if(printFindOption == 0) {
                                for (int i = 0; i < wordPositions.size(); i++) {
                                    System.out.println("Position: " + wordPositions.get(i) + ".");
                                }
                            }

                        }catch (Exception e){
                            System.out.println("\n" + ANSI_RED_BACKGROUND + " Word not found " + ANSI_RESET + "\n");
                        }

                        System.out.println();

                    } else {
                        keepDoing = false;
                    }

                } while (keepDoing);

            }
        } else {
            System.out.println("\n" + ANSI_RED_BACKGROUND + "                Something went wrong                " + ANSI_RESET + "\n");
        }


        System.out.println(ANSI_BLUE_BACKGROUND + "             Thanks for using my Program            " + ANSI_RESET);

    }
}
