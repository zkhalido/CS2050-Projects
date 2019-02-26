/**
 * This is the main class, it reads a .txt file and operates two sorts onto the 
 * collection of numbers from lowest to highest order and prints onto two 
 * output txt files.
 *  
 * Zack Khalidov
 * Project #6
 * Windows, PC, Eclipse.
 * 
 * substance: noun - That which has mass and occupies space.
 */

package zackKhalidov_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is the main class, it reads a .txt file and operates two sorts onto the 
 * collection of numbers from lowest to highest order and prints onto two 
 * output txt files.
 * 
 * @author zack1
 * @version 11/30/2018
 */
public class ZackKhalid_06 {
	
	// Declare fields
	private static int[] shellSortArray = new int [100];
	private static int[] quickSortArray = new int [100];

	// Declare Objects
	private static ShellSort shellSort = new ShellSort();
	private static QuickSort quickSort = new QuickSort();
	
	// Declare FINAL
	private final static String INPUT_FILENAME = "hw6input.txt";
	
	private final static String OUTPUT_FILENAME1 = "hw6output1.txt";
	private final static String OUTPUT_FILENAME2 = "hw6output2.txt";

	public static void main(String[] args) throws IOException {
		
		// Method to populate arrays. 
		populateArray();
		
		// Calls sort classes. 
		shellSort.shellSort(shellSortArray);
		quickSort.quickSort(quickSortArray, 0, 99);
		
		// Calls printArray to print numbers in array to txt file.
		printArray();
		
	} // end main

	//***********************************************************************

	/*
	 * Scans txt file line by line and saves onto an array.
	 */
	public static void populateArray() throws FileNotFoundException {
		
		// Creates scanners to search txt file. 
		Scanner stdIn1 = new Scanner(new File(INPUT_FILENAME));
		Scanner stdIn2 = new Scanner(new File(INPUT_FILENAME));
		
		// Runs through every line in txt file and saves to array.
		for (int i = 0; i < 100; i++) {
			shellSortArray[i] = Integer.parseInt(stdIn1.nextLine());
			quickSortArray[i] = Integer.parseInt(stdIn2.nextLine());
		} // end for
		
		stdIn1.close();
		stdIn2.close();
	} // end populate Array
	
	//***********************************************************************

	/*
	 * Loops through an array and prints onto txt files. 
	 */
	public static void printArray() throws IOException {
		
		// Creates printers to write onto txt files.
		PrintWriter stdOut1 = new PrintWriter(new File(OUTPUT_FILENAME1));
		PrintWriter stdOut2 = new PrintWriter(new File(OUTPUT_FILENAME2));
		
		// Runs through array and prints onto txt files.
		for (int i = 0; i < 100; i++) {
			stdOut1.println(shellSortArray[i]);
			stdOut2.println(quickSortArray[i]);
		} // end for
		stdOut1.close();
		stdOut2.close();
	} // end printArray
} // zackKhalid_06
