package zackKhalid_05;

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
		
		for (int i = 0; i < splitInfix.length; i++) {
			
			character = splitInfix[i];
			
			switch (character) {
			case "a" : case "b" : case "c" : case "d" : case "e" : case "f" :
			case "g" : case "h" : case "i" : case "j" : case "k" : case "l" :
				postfix += character;
				break;
			case "^" : 
				operStack.push(character);
				break;
			case "+" : case "-" : case "*" : case "/" :
				while (!operStack.isEmpty() && precedence(character) <= precedence(operStack.peek())) {
					postfix += operStack.peek();
					operStack.pop();
				}
				operStack.push(character);
				break;
			case "(" : 
				operStack.push(character);
				break;
			case ")" : 
				topOperator = operStack.pop();
				while (topOperator != "(") {
					postfix += topOperator;
					topOperator = operStack.pop();
				}
				break;
			default : break;
			
			} // end switch
        } // end for
		while (!operStack.isEmpty()) {
			topOperator = operStack.pop();
			postfix += topOperator;
		} // end while
		return postfix;
	} // end convertToPostfix

	private int precedence (String character) {
		
	        switch (character) {
	        	case "-":
	        		//return 1;
		        case "+":
		        	return 2;
		        case "/":
		            //return 3;
		        case "*":
		        	return 4;
		        case "^":
		            return 5;
	        } // end switch
	        return 0;
	} // end precedence
}
