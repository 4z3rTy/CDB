package ui;

public class CLI {

	/*
	Java Programming for Engineers
	Julio Sanchez
	Maria P. Canton


	ISBN: 0849308100
	Publisher: CRC Press
	*/


	// File name: MenuDemo.java
	//Reference: Chapter 9
	//
	//Java program to demonstrate menu selection
	//Topics:
	// 1. Using the switch construct
	//
	//Requires:
	// 1. Keyin class in the current directory


	  public static void main(String[] args) {
	    // Local variable
	    int swValue;

	    // Display menu graphics
	    System.out.println("===============================================");
	    System.out.println("|   CDB WONDERFUL CLI (Much options such wow) |");
	    System.out.println("===============================================");
	    System.out.println("| Options:                                    |");
	    System.out.println("|        1. List computers                    |");
	    System.out.println("|        2. List companies                    |");
	    System.out.println("|        3. Show computer details             |");
	    System.out.println("|        4. Create a computer                 |");
	    System.out.println("|        5. Update a computer                 |");
	    System.out.println("|        6. Delete a computer                 |");
	    System.out.println("|        7. Exit                              |");
	    System.out.println("===============================================");
	    swValue = Keyin.inInt(" Select option: ");

	    // Switch construct
	    switch (swValue) {
	    case 1:
	      System.out.println("List computers selected");
	      break;
	    case 2:
	      System.out.println("List companies   selected");
	      break;
	    case 3:
	      System.out.println("Show computer details selected");
	      break;
	    case 4:
		      System.out.println("Create a computer selected");
		      break;
	    case 5:
		      System.out.println("Update a computer selected");
		      break;
	    case 6:
		      System.out.println("Delete a computer selected");
		      break;
	    case 7:
	      System.out.println("Exit selected...bye bye!");
	      break; 
	    default:
	    	System.out.println("Please Try again :) ");
	    	break;  // This break is not really necessary
	    }
	  }
	}

	//**********************************************************
	//**********************************************************
	//Program: Keyin
	//Reference: Session 20
	//Topics:
	// 1. Using the read() method of the ImputStream class
//	    in the java.io package
	// 2. Developing a class for performing basic console
//	    input of character and numeric types
	//**********************************************************
	//**********************************************************

	class Keyin {

	  //*******************************
	  //   support methods
	  //*******************************
	  //Method to display the user's prompt string
	  public static void printPrompt(String prompt) {
	    System.out.print(prompt + " ");
	    System.out.flush();
	  }

	  //Method to make sure no data is available in the
	  //input stream
	  public static void inputFlush() {
	    int dummy;
	    int bAvail;

	    try {
	      while ((System.in.available()) != 0)
	        dummy = System.in.read();
	    } catch (java.io.IOException e) {
	      System.out.println("Input error");
	    }
	  }

	  //********************************
	  //  data input methods for
	  //string, int, char, and double
	  //********************************
	  public static String inString(String prompt) {
	    inputFlush();
	    printPrompt(prompt);
	    return inString();
	  }

	  public static String inString() {
	    int aChar;
	    String s = "";
	    boolean finished = false;

	    while (!finished) {
	      try {
	        aChar = System.in.read();
	        if (aChar < 0 || (char) aChar == '\n')
	          finished = true;
	        else if ((char) aChar != '\r')
	          s = s + (char) aChar; // Enter into string
	      }

	      catch (java.io.IOException e) {
	        System.out.println("Input error");
	        finished = true;
	      }
	    }
	    return s;
	  }

	  public static int inInt(String prompt) {
	    while (true) {
	      inputFlush();
	      printPrompt(prompt);
	      try {
	        return Integer.valueOf(inString().trim()).intValue();
	      }

	      catch (NumberFormatException e) {
	        System.out.println("Invalid input. Not an integer");
	      }
	    }
	  }

	  public static char inChar(String prompt) {
	    int aChar = 0;

	    inputFlush();
	    printPrompt(prompt);

	    try {
	      aChar = System.in.read();
	    }

	    catch (java.io.IOException e) {
	      System.out.println("Input error");
	    }
	    inputFlush();
	    return (char) aChar;
	  }

	  public static double inDouble(String prompt) {
	    while (true) {
	      inputFlush();
	      printPrompt(prompt);
	      try {
	        return Double.valueOf(inString().trim()).doubleValue();
	      }

	      catch (NumberFormatException e) {
	        System.out
	            .println("Invalid input. Not a floating point number");
	      }
	    }
	  }
	}
