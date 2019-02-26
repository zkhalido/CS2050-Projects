/*
 * ShellSort class takes in an array of int and sorts numbers in array 
 * from lowest order to highest. 
 * 
 * Zack Khalidov
 * Project #6
 * Windows, PC, Eclipse.
 */

package zackKhalidov_06;

/**
 * ShellSort class takes in an array of int and sorts numbers in array 
 * from lowest order to highest.
 * 
 * @author Zack Khalidov
 * @version 11/30/2018
 */

public class ShellSort {
	
	// Declare fields
	private int interval = 0;
	private int valueToInsert;
	private int inner;
	
	public void shellSort (int[] shellArray) {
		
		// Splits array into intervals.
		while (interval < shellArray.length / 3) {
			interval = interval * 3 + 1;
		} // end while
		
		while (interval > 0) {
			for (int outer = interval; outer < shellArray.length; outer++) {
				valueToInsert = shellArray[outer];
				inner = outer;
				
				while (inner > interval - 1 && shellArray[inner - interval] >= valueToInsert) {
					shellArray[inner] = shellArray[inner - interval];
					inner = inner - interval;
				} // end while
				
				shellArray[inner] = valueToInsert;
			} // end for
			
			interval = (interval - 1) / 3;
		} // end while
	} // end sortArray
} // end ShellSort
