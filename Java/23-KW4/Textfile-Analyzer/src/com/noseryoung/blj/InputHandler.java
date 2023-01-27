package com.noseryoung.blj;

import java.io.IOException;
import java.util.Scanner;

public class InputHandler {
    private String[] sortOption = {"No", "ASC", "DESC"};
    private boolean[] stopOption = {true, false};
    public int inputValidation(String question, String[] answers){
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int input = 0;

        do {
            System.out.println(question);
            for (int i = 0; i < answers.length; i++) {
                System.out.println(i + ": " + answers[i]);
            }
            System.out.println("Select option: ");
            try {
                input = scan.nextInt();
                if(input >= 0 && input < answers.length){
                    valid = true;
                } else {
                    System.out.println("\nInvalid Input\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid Input\n");
            }
        }while (!valid);
        return input;
    }
    public void menuPrompt() throws IOException {
        System.out.println("Welcome to my Textfile Analyzer");

        int defaultSettings = inputValidation("Do wo want to use the default Settings?" , new String[]{"Yes", "No"});
        if(defaultSettings == 1){
            int ordering = inputValidation("How do you want to Sort the data?" , new String[]{"Don't sort it", "ASC by most common Words", "DESC by most common Words"});
            int stopWords = inputValidation("Do wo want to include the Stop Words?" , new String[]{"Yes", "No"});
            FileHandler fHandler = new FileHandler(sortOption[ordering], stopOption[stopWords]);
            fHandler.readFile();
        } else{
            FileHandler fHandler = new FileHandler(sortOption[2], stopOption[1]);
            fHandler.readFile();
        }
    }
}
