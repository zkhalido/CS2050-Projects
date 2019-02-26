package zackKhalid_05;

import java.util.Scanner;

public class ZackKhalid_05 {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner stdIn = new Scanner (System.in);
		
		Postfix convert = new Postfix();
		
		String infix = "";
		String postfix = "";
		
		System.out.println("If you'd like to quit enter: 'quit' ");
		System.out.print("Enter an infix expression: ");
		
		while (!(infix.equals("quit"))) {
			
			infix = stdIn.nextLine();
			postfix = convert.convertToPostfix(infix);

			System.out.println(postfix);
		}
		
		if (infix.contains("quit")) {
			System.out.println("Bye!");
		}
	}
}
