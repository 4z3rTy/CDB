package ui;

import java.util.Scanner;

public class Myne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running=true;
		int option;
		while (true)
	    {
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
	    
	    option=sc.nextInt();
	    // Switch construct
	    switch (option) {
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
}

