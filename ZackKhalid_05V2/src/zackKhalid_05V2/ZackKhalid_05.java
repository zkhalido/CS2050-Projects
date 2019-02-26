/**
 * This is the main class, it prompts user for an infix expression and 
 * converts to a postfix. 
 * Zack Khalidov
 * Project #5
 * Windows, PC, Eclipse.
 * substance: noun - That which has mass and occupies space.
 * 
 * "The truth is not for all men, but only for those who seek it."
 * - Ayn Rand
 */

package zackKhalid_05V2;

import java.util.Scanner;

/**
 * This is the main class, it creates a LinkedList of Student and GradeItem by 
 * reading from a input .txt file 'hw3input01.txt' 
 * 
 * @author Zack Khalidov
 * @version 11/25/2018
 */

public class ZackKhalid_05 {
	
	// Declare fields. 
	private static Postfix convert = new Postfix();
	
	private static String infix = "";
	private static String postfix = "";

	public static void main(String[] args) throws InterruptedException {
		
		// Scanner used to prompt user for input.
		Scanner stdIn = new Scanner (System.in);
		
		System.out.println("If you'd like to quit enter: 'quit' ");
		System.out.print("Enter an infix expression: ");
		
		// While loop continually prompts for input until 'quit' is entered.
		while (!(infix.equals("quit"))) {
			
			infix = stdIn.nextLine(); // User input prompt.
			postfix = convert.convertToPostfix(infix); 
			
			// Prints postfix expression.
			System.out.println(postfix);

		} // end while
		
		if (infix.contains("quit")) {
			System.out.println("Bye!");
		} // end if
		
		stdIn.close();
	} // end main
} // end ZackKhalid_05
