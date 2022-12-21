package com.noseryoung.blj;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void wordleManger(Words words, Field field, String option) {
        Scanner scan = new Scanner(System.in);
        String correctWord = words.getWord();
        correctWord = correctWord.toUpperCase();

        System.out.println(correctWord);
        field.setCorrectWord(correctWord);

        int counter = 0;
        boolean exit = false;

        while (!exit) {
            System.out.print("\nEnter your guess: ");
            String inputString = scan.nextLine();
            inputString = inputString.toUpperCase();
            if (inputString.length() == 5) {
                if(option.equals("2") || words.isInDB(inputString)) {
                    System.out.println("");

                    counter++;

                    field.addWord(inputString);
                    boolean answer = field.checkIfCorrect(inputString);
                    field.print();

                    if (answer) {
                        System.out.println("\nNice job!");
                        System.out.println("You were able to solve it in " + counter + " tries\n");
                        exit = true;
                    } else {
                        System.out.println("\nNot quite\n");
                        if (counter == 6) {
                            System.out.println("No tries remaining");
                            exit = true;
                        } else {
                            System.out.println((6 - counter) + " tries remaining");
                        }
                    }
                } else{
                    System.out.println("\nEntered Word isn't in Database");
                }
            } else {
                System.out.println("\nInvalid Input");
            }

        }
    }
        public static void main (String[]args) throws IOException {
            boolean keepDoing = true;
            Field field = new Field();
            Words words = new Words();
            Scanner scan = new Scanner(System.in);

            String welcomeText = "Welcome to WORDLE";
            String[] welcomeArr = welcomeText.split("", 17);
            System.out.println("");
            System.out.println("\033[0;107m\033[1;90m W E L C O M E \033[0m  \033[0;103m\033[1;90m T O \033[0m  \033[0;102m\033[1;90m W O R D L E \033[0m\n");


            do {
                System.out.println("What do you want to do?");
                System.out.println("" +
                        "1. Solve a classic WORDLE\n" +
                        "2. Solve a WORDLE without Word check\n" +
                        "3. Exit");
                System.out.print("Enter Option: ");
                String option = scan.nextLine();
                if (option.equals("1")) {
                    wordleManger(words, field, option);
                } else if (option.equals("2")) {
                    wordleManger(words, field, option);
                } else if (option.equals("3")) {
                    System.out.println("Thanks for using my Program");
                    keepDoing = false;
                } else {
                    System.out.println("\nInvalid Input\n");
                }

            } while (keepDoing);

        }
    }
