package com.noseryoung.blj;

import com.noseryoung.blj.exceptions.*;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

// import the exceptions

public class TriangleApp {

  private String company;
  private String handler;

  private boolean isRunning;

  private String sideAInput;
  private String sideBInput;
  private String sideCInput;

  private double sideA;
  private double sideB;
  private double sideC;

  private String code;

  /**
   * The constructor.
   * 
   * @param company of type String to print in the application header
   * @param handler of type String to print in the application header
   */
  public TriangleApp(String company, String handler) {
    this.company = company;
    this.handler = handler;
    this.isRunning = true;
	// persist company and handler
	// with initialisation programm is running.
  }



  /**
   * This method starts the actual application. It will remain in a loop as long
   * as the field "isRunning" is true.
   */
  public void start() throws TriangleException {
    printHeader();
    while (isRunning) {
      System.out.println("\nTEST CASES TRIANGLE\n");

      sideAInput = promptSide("a");
      sideBInput = promptSide("b");
      sideCInput = promptSide("c");


      // get all 3 sides from the triangle

      try {
        validateInput();

		// validate Input (might throw exception)
		// get triangle code and write it to field code
      }
      catch (TriangleException e) {
        String message = e.getMessage();
        System.out.println(message);
        // get error code from exception and write it to field code
      }
      finally {
        printResult();
		// print result
		// ask user for next step
      }
    }
  }

  /**
   * This method prints the application header.
   */
  private void printHeader() {
    // create header with handler, company and current year
  }

  /**
   * This method prints the evaluated code in an aesthetically pleasing way.
   */
  private void printResult() {
    // todo
  }

  /**
   * This method prompts the user to give an input for a trinalge side.
   * 
   * @param side of type String to display as title for the prompt.
   * @return the input of type String.
   */
  private String promptSide(String side) {
    System.out.println("Enter Side " + side);
    Scanner scan = new Scanner(System.in);
    String input = scan.next();
    return input;
  }

  /**
   * This method prompts the user to give an input.<br>
   * "q": Quits the program.<br>
   * "c": Continues the program.<br>
   * else: Keeps asking for an input until "q" or "c" is entered.
   */
  private void promptAction() {
    String action = "";
    // get valid prompt
    
	// check if program needs to be cancelled
	
    System.out.println("******************************");
  }

  /**
   * This method validates the three entered values, to be used as sides for a
   * triangle.
   * 
   * @throws TriangleException if the validation fails. This means that the
   *                           entered values do not lead to a triangle.
   */
  private void validateInput() throws TriangleException {
    sideA = Double.parseDouble(sideAInput);
    sideB = Double.parseDouble(sideBInput);
    sideC = Double.parseDouble(sideCInput);
    // validate sideAInput, sideBInput, sideCInput as double

    if (sideA == 0 || sideB == 0 || sideC == 0) {
      throw new ZeroTriangleSideException();
    }
    if (sideA < 0 || sideB < 0 || sideC < 0) {
      throw new NegativeTriangleSideException();
    }

    if(sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA){
      throw new ImpossibleTriangleException();
    }
    if(sideA + sideB == sideC || sideA + sideC == sideB || sideB + sideC == sideA){
      throw new TriangleIsLineException();
    }

	// validates other triangle cases
  }

  /**
   * This method determines whether the three entered values lead to a
   * equilateral, isosceles, right-angled or scalene triangle.
   * 
   * @return The corresponding code for each triangle.
   */
  private String determineTriangleType() {
    // todo
    return null;
  }
}
