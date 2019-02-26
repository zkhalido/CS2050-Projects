/*
 * Postfix class takes in a infix expression as string and
 * returns postfix form.
 * 
 * Zack Khalidov
 * Project #5
 * Windows, PC, Eclipse.
 */
package zackKhalid_05V2;

/**
 * Postfix class takes in a infix expression as string and
 * returns postfix form.
 * 
 * @author Zack Khalidov
 * @version 11/25/2018
 */
public class Postfix {
	
	private static String[] splitInfix;
	
	private static LinkedStack<String> operStack = new LinkedStack<>();

	/**
	 * Converts infix expressions of type String to postfix.
	 * 
	 * @param inputExpression is an infix expression. 
	 * @return Returns a postfix expression.
	 */
	public String convertToPostfix(String inputExpression) {
		
		splitInfix = inputExpression.split(" ");
		String postfix = "";
		String topOperator = "";
		String character = "";
		
		// for loop runs for the length of the array splitInfix.
		for (int i = 0; i < splitInfix.length; i++) {
			
			character = splitInfix[i];
			
			// Determines what character is being analyzed 
			// and applies correct procedures.
			switch (character) {
			case "^" : 
				operStack.push(character);
				break;
			case "+" : case "-" : case "*" : case "/" :
				
				// Checks if precedence of character is less or equal to 
				// precedence of operand in Stack. 
				while (!operStack.isEmpty() && precedence(character) 
											<= precedence(operStack.peek())) {
					
					postfix += operStack.peek(); // Adds top operand to postfix.
					operStack.pop();
				} // end while
				
				// Pushes character being analyzed to Stack. 
				operStack.push(character);
				break;
			case "(" : 
				operStack.push(character);
				break;
			case ")" : 
				// Pops from Stack until '(' is on top of Stack..
				topOperator = operStack.pop();
				while (!(topOperator.equals("("))) {
					postfix += topOperator;
					topOperator = operStack.pop();
				} // end while
				break;
				
			// Default case adds variables to postfix. 
			default : postfix += character;
				break;
			
			} // end switch
        } // end for
		
		// Pops remaining operands from Stack and adds to postfix.
		while (!operStack.isEmpty()) {
			topOperator = operStack.pop();
			postfix += topOperator;
		} // end while
		
		return postfix;
	} // end convertToPostfix
	
	//***********************************************************************
	
	/*
	 * Precedence method takes in a String and evaluates
	 * a case to returns its precedence.
	 */
	private int precedence (String character) {
		
	        switch (character) {
	        	case "-":
		        case "+":
		        	return 2;
		        case "/":
		        case "*":
		        	return 4;
		        case "^":
		            return 5;
	        } // end switch
	        return 0;
	} // end precedence
} // end Postfix
