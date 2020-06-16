package ui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import mapper.SqlShenanigans;
import persistence.OnComputer;

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


	  public static void main(String[] args) throws IOException, SQLException, ParseException {
	    // Local variable
	    //int swValue;
	    Scanner sc = new Scanner(System.in);
		boolean running=true;
		int option;
		

	    while (running)
	    {
	    	// Display menu graphics
	    	System.out.println("===============================================");
		    System.out.println("|   CDB WONDERFUL CLI (Much options such wow) |");
		    System.out.println("===============================================");
		    System.out.println("| Available Options:                          |");
		    System.out.println("|        1. List all computers                |");
		    System.out.println("|        2. List all companies                |");
		    System.out.println("|        3. Show computer details             |");
		    System.out.println("|        4. Create a computer                 |");
		    System.out.println("|        5. Update a computer                 |");
		    System.out.println("|        6. Delete a computer                 |");
		    System.out.println("|        7. Exit                              |");
		    System.out.println("===============================================");
		    System.out.println("");
		    System.out.println(" Please select the (next) option you are interested in:  ");
		    option=sc.nextInt();
		   
		    
		    
		    
		    int id;
		    String name;
		    int c_id;
		    String intr;
		    String disc;
		    
		    SqlShenanigans server=new SqlShenanigans("root","root");
		    Connection con=server.getCo();
	    
	    // Switch construct
	    switch (option) {
	    
	    
	    case 1:
	      System.out.println("'List all computers' selected ->");
	      System.out.println("");
	      persistence.OnComputer.viewComputer(con);
	      break;
	    
	    
	    case 2:
	    	System.out.println("'List all companies' selected ->");
	    	System.out.println("");
	    	persistence.OnCompany.viewCompany(con);
	      break;
	    
	    
	    case 3:
	      System.out.println("'Show computer details' selected:");
	      System.out.println("Please indicate which computer you are interested in using its id ->");
	      Scanner three = new Scanner(System.in);
	      id=three.nextInt();
	      System.out.println("Attempting to fetch computer details for computer ID="+id);
	      System.out.println(id);
	      OnComputer.viewCompDetails(con, id);  
	      break;
	    
	    
	    case 4:
		      System.out.println("'Create a computer' selected:");
		      System.out.println("Please indicate the desired attributes of the computer you wish to create (name, date introduced, date discontinued & company id) ->");
		      Scanner four = new Scanner(System.in);
		      name=four.next();
		      intr=four.next();  // TODO Have to format to get a correct sql Date at a later point. Probably in the Mapper would be ideal.
		      disc=four.next();
		      c_id=four.nextInt();
		      System.out.println("Attempting to create computer with following attributes name=" +name);
		      System.out.println("date introduced=" +intr);
		      System.out.println("date discontinued=" +disc);
		      System.out.println("company ID=" +c_id);
	    	
	    	  DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
	    	  LocalDate date=LocalDate.parse(disc, formatter);
	    	  Date sqlDate=Date.valueOf(date);
	    	  LocalDate date2=LocalDate.parse(intr, formatter);
	    	  Date sqlDate2=Date.valueOf(date2);
	    	  
	    	  OnComputer.insertComputer(con, name, c_id, sqlDate2, sqlDate);
		      break;
	    
	   
	    case 5:
		      System.out.println("'Update a computer' selected:");
		      System.out.println("Please indicate which computer you wish to update using it's id ->");
		      Scanner five = new Scanner(System.in);
		      id=five.nextInt();
		      int subc;
		      System.out.println("Please input '1' if you wish to update "+id +"'s Computer name or '2' if you wish to update "+id +"'s discontinued date ->");
		      subc=five.nextInt();
		      switch(subc)
		      {
		      case 1:
		    	  System.out.println("Please input a new name for computer"+id+":");
		    	  Scanner subfive= new Scanner(System.in);
		    	  name=subfive.next();
		    	  OnComputer.updateComputerName(con, name, id);
		    	  System.out.println("Your modification has been carried out (hopefully, maybe, probably, definitely)");
		    	  System.out.println("");
		    	  break;
		      case 2:
		    	  System.out.println("Please input a new discontinued date for computer"+id+":");
		    	  Scanner five2= new Scanner(System.in);
		    	  disc=five2.next();
		    	  DateTimeFormatter formatter1= DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		    	  LocalDate date1=LocalDate.parse(disc, formatter1);
		    	  Date sqlDate1=Date.valueOf(date1);
		    	  OnComputer.updateComputerDisc(con, sqlDate1, id);
		    	  System.out.println("Your modification has been carried out (hopefully, maybe, probably, definitely)");
		    	  System.out.println("");
		    	  break;
		      }
		      break;
	   
	    
	    case 6:
		      System.out.println("'Delete a computer' selected:");
		      System.out.println("Please indicate which computer you wish to delete using it's id ->");
		      Scanner six=new Scanner(System.in);
		      id=six.nextInt();
		      OnComputer.deleteComputer(con,id);
		      System.out.println("Computer " +id+" has been deleted (hopefully, maybe, probably, definitely)");
		      break;
	   
	    
	    case 7:
	      System.out.println("'Exit' selected...bye bye!");
	      sc.close();
	      running=false;
	      break; 
	    default:
	    	System.out.println("The option you selected is not currently available, please try again :) ");
	    	break;  // This break is not really necessary
	    }
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
