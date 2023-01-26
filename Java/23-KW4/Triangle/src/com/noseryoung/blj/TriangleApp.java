package com.noseryoung.blj;

import com.noseryoung.blj.exceptions.*;

import java.util.Calendar;
import java.util.Scanner;

public class TriangleApp {

    private String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private String ANSI_RED_BACKGROUND = "\u001B[41m";
    private String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    private String company;
    private String handler;
    private double version;

    private String codeTable = "\n" +
            "***********************************************\n" +
            "| Codes   | Type \n" +
            "***********************************************\n" +
            "| " + ANSI_GREEN_BACKGROUND + "TRI84TF" + ANSI_BLACK_BACKGROUND + " | Gleichschenkliges Dreieck\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_GREEN_BACKGROUND + "TRI66TF" + ANSI_BLACK_BACKGROUND + " | Gleichseitiges Dreieck\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_GREEN_BACKGROUND + "TRI60TF" + ANSI_BLACK_BACKGROUND + " | Gewöhnliches Dreieck\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_GREEN_BACKGROUND + "TRI72TF" + ANSI_BLACK_BACKGROUND + " | Rechtwinkliges Dreieck\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_RED_BACKGROUND + "ERR36TF" + ANSI_BLACK_BACKGROUND +   " | Unmögliches Dreieck\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_RED_BACKGROUND + "ERR96TF" + ANSI_BLACK_BACKGROUND +   " | Buchstaben oder sonstige Zeichen\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_RED_BACKGROUND + "ERR12TF" + ANSI_BLACK_BACKGROUND +   " | Minuszahlen\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_RED_BACKGROUND + "ERR16TF" + ANSI_BLACK_BACKGROUND +   " | Null als Seitenlänge\n" +
            "-----------------------------------------------\n" +
            "| " + ANSI_RED_BACKGROUND + "ERR56TF" + ANSI_BLACK_BACKGROUND +   " | Eine Gerade\n" +
            "-----------------------------------------------\n";

    private String triangleGraphic = "";
    private String codeBgColor = ANSI_RED_BACKGROUND;

    private boolean isRunning;

    private String sideAInput;
    private String sideBInput;
    private String sideCInput;

    private double sideA;
    private double sideB;
    private double sideC;

    private String code;

    public TriangleApp(String company, String handler, double version) {
        this.company = company;
        this.handler = handler;
        this.version = version;
        this.isRunning = true;
    }

    public void start() throws TriangleException {
        printHeader();
        while (isRunning) {
            System.out.println("\n------------------------------");
            System.out.println(ANSI_BLUE_BACKGROUND + "      TEST CASES TRIANGLE     " + ANSI_BLACK_BACKGROUND);
            System.out.println("------------------------------\n");


            sideAInput = promptSide("a");
            sideBInput = promptSide("b");
            sideCInput = promptSide("c");


            try {
                validateInput();
                code = determineTriangleType();
            } catch (TriangleException e) {
                code = e.getMessage();
            } finally {
                printResult();
            }
            promptAction();
        }
    }

    private void printHeader() {
        System.out.println(ANSI_BLACK_BACKGROUND + "******************************");
        System.out.println(ANSI_BLUE_BACKGROUND +  "      TRIANGLE EVALUATOR      " + ANSI_BLACK_BACKGROUND);
        System.out.println("******************************");
        System.out.println("COMPANY: " + ANSI_CYAN_BACKGROUND + company + ", " + Calendar.getInstance().get(Calendar.YEAR) + ANSI_BLACK_BACKGROUND);
        System.out.println("HANDLER: " + ANSI_CYAN_BACKGROUND + handler + ANSI_BLACK_BACKGROUND);
        System.out.println("VERSION: " + ANSI_CYAN_BACKGROUND + version + ANSI_BLACK_BACKGROUND);
        System.out.println(ANSI_BLACK_BACKGROUND + "******************************");
    }

    private void printResult() {
        System.out.println("\n" + codeBgColor + " Code: " + code + " " + ANSI_BLACK_BACKGROUND);
        System.out.println(triangleGraphic);
    }

    private String promptSide(String side) {
        System.out.print("Enter Side " + side + ": ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return input;
    }


    private void promptAction() {
        Scanner scan = new Scanner(System.in);
        String action = "";
        boolean valid = false;

        do {
            codeBgColor = ANSI_RED_BACKGROUND;
            triangleGraphic = "";

            System.out.println("" +
                    "\nWhat do you want to do?\n" +
                    "<c> Continue \n" +
                    "<o> Print codes\n" +
                    "<q> Quit \n");
            System.out.print("Option: ");
            action = scan.nextLine();
            action.toLowerCase();
            if (action.equals("q") || action.equals("c")) {
                valid = true;
            } else if(action.equals("o")){
                System.out.println(codeTable);
            }
        } while (valid == false);

        if (action.equals("q")) {
            isRunning = false;
            System.out.println("\nThanks for using my program!");
        }

        System.out.println("******************************");
    }

    private void validateInput() throws TriangleException {
        try {
            sideA = Double.parseDouble(sideAInput);
            sideB = Double.parseDouble(sideBInput);
            sideC = Double.parseDouble(sideCInput);
        } catch (NumberFormatException e) {
            throw new IllegalTriangleSideException();
        }

        if (sideA == 0 || sideB == 0 || sideC == 0) {
            throw new ZeroTriangleSideException();
        }
        if (sideA < 0 || sideB < 0 || sideC < 0) {
            throw new NegativeTriangleSideException();
        }

        if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA) {
            throw new ImpossibleTriangleException();
        }
        if (sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA) {
            throw new TriangleIsLineException();
        }
    }

    private String determineTriangleType() {
        String returnCode;
        codeBgColor = ANSI_GREEN_BACKGROUND;

        double sideAPOW = Math.pow(sideA, 2);
        double sideBPOW = Math.pow(sideB, 2);
        double sideCPOW = Math.pow(sideC, 2);


        if (sideA == sideB && sideB == sideC) {
            triangleGraphic = "\n" +
                       "Gleichseitiges Dreieck \n\n" +
                       "             / \\ \n" +
                       "           /     \\ \n" +
                       "         /         \\ \n" +
                       "       /             \\ \n" +
                       "      -----------------";
            returnCode = "TRI66TF";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            triangleGraphic = "\n" +
                    "Gleichschenkliges Dreieck \n\n" +
                    "          / \\ \n" +
                    "         /   \\ \n" +
                    "        /     \\ \n" +
                    "       /       \\ \n" +
                    "      -----------";
            returnCode = "TRI84TF";
        } else if (sideAPOW + sideBPOW == sideCPOW || sideCPOW + sideBPOW == sideAPOW || sideAPOW + sideCPOW == sideBPOW) {
            triangleGraphic = "\n" +
                    "Rechtwinkliges Dreieck \n\n" +
                    "       | \\ \n" +
                    "       |   \\ \n" +
                    "       |     \\ \n" +
                    "       |       \\ \n" +
                    "       ----------";
            returnCode = "TRI72TF";
        } else {
            triangleGraphic = "\n" +
                    "Gewöhnliches Dreieck \n\n" +
                    "    \\ \\ \n" +
                    "     \\   \\ \n" +
                    "      \\      \\ \n" +
                    "       \\        \\ \n" +
                    "       ------------";
            returnCode = "TRI60TF";
        }
        return returnCode;
    }
}
