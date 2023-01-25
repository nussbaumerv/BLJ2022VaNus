package com.noseryoung.blj;

import com.noseryoung.blj.exceptions.*;

import java.util.Calendar;
import java.util.Scanner;

public class TriangleApp {

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

  private String company;
  private String handler;
  private double version;

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
      System.out.println("\nTEST CASES TRIANGLE\n");

      sideAInput = promptSide("a");
      sideBInput = promptSide("b");
      sideCInput = promptSide("c");


      try {
        validateInput();
        code = determineTriangleType();
      }
      catch (TriangleException e) {
        code = e.getMessage();
      }
      finally {
        printResult();
      }
      promptAction();
    }
  }

  private void printHeader() {
    System.out.println(ANSI_BLACK_BACKGROUND + "******************************");
    System.out.println(ANSI_BLUE_BACKGROUND +  "      TRIANGLE EVALUATOR      " + ANSI_BLACK_BACKGROUND);
    System.out.println("******************************");
    System.out.println( "COMPANY: " + ANSI_CYAN_BACKGROUND + company + ", " + Calendar.getInstance().get(Calendar.YEAR) + ANSI_BLACK_BACKGROUND );
    System.out.println("HANDLER: " + ANSI_CYAN_BACKGROUND  + handler + ANSI_BLACK_BACKGROUND );
    System.out.println("VERSION: " + ANSI_CYAN_BACKGROUND + version + ANSI_BLACK_BACKGROUND );
    System.out.println( ANSI_BLACK_BACKGROUND + "******************************");
  }

  private void printResult() {
    System.out.println("\n" + ANSI_RED_BACKGROUND + " Code: " + code + " " + ANSI_BLACK_BACKGROUND);
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

    do{
      System.out.println("" +
              "\nWhat do you want to do?\n" +
                      "<c> Continue \n" +
                      "<q> Quit \n");
     action = scan.nextLine();
     action.toLowerCase();
     if(action.equals("q") || action.equals("c")){
       valid = true;
     }
    } while (valid == false);

    if(action.equals("q")){
      isRunning = false;
    }

	
    System.out.println("******************************");
  }

  private void validateInput() throws TriangleException {
    try {
      sideA = Double.parseDouble(sideAInput);
      sideB = Double.parseDouble(sideBInput);
      sideC = Double.parseDouble(sideCInput);
    }
    catch(NumberFormatException e){
      throw new IllegalTriangleSideException();
    }
    // validate sideAInput, sideBInput, sideCInput as double

    if (sideA == 0 || sideB == 0 || sideC == 0) {
      throw new ZeroTriangleSideException();
    }
    if (sideA < 0 || sideB < 0 || sideC < 0) {
      throw new NegativeTriangleSideException();
    }

    if(sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA){
      throw new ImpossibleTriangleException();
    }
    if(sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA){
      throw new TriangleIsLineException();
    }
  }

  private String determineTriangleType() {
    String returnCode;

    double sideAPOW = Math.pow(sideA, 2);
    double sideBPOW = Math.pow(sideB, 2);
    double sideCPOW = Math.pow(sideC, 2);


    if (sideA == sideB && sideB == sideC) {
    returnCode = "TRI66TF";
    } else if(sideA == sideB || sideB == sideC || sideA == sideC){
      returnCode = "TRI84TF";
    }else if(sideAPOW + sideBPOW == sideCPOW || sideCPOW + sideBPOW == sideAPOW || sideAPOW + sideCPOW == sideBPOW){
      returnCode = "TRI72TF";
    } else{
      returnCode = "TRI60TF";
    }
    return returnCode;
  }
}
