/**
 * This is the main class, it creates a list of Student and GradeItem by 
 * reading from a input .txt file 'hw3input01.txt' 
 * Zack Khalidov
 * Project #3
 * Windows, PC, Eclipse.
 * reverberation: noun - prolongation of a sound.
 * "The secret to getting ahead is getting started" 
 * - Mark Twain
 */

package zackKhalidov_03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This is the main class, it creates a list of Student and GradeItem by 
 * reading from a input .txt file 'hw3input01.txt' 
 * 
 * @author zack1
 * @version 10/14/2018
 */

public class ZackKhalidov_03 {
	
	// Declare fields
	private static List<Student> listOfStudents; // List for Student Items
	private static List<GradeItem> listOfGradeItem; // List for GradeItem Items
	
	private static Student[] arrayOfStudents; // Array of Student objects
	private static GradeItem[] arrayOfGradeItem; // Array of GradeItem objects
	
	// Final strings storing input and output file names. 
	private final static String INPUT_FILENAME = "hw3input01.txt";
	private final static String OUTPUT_FILENAME = "hw3output.txt";
	
	/**
	 * Main class creates new instances of listOfStudents and listOfGradeItem
	 * and calls on the processInput and generateReport methods to read from 
	 * input file and print onto an output file.  
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) 
						    throws IOException, InterruptedException {
		
		listOfStudents = new List<>(); // New listOfStudents List.
		listOfGradeItem = new List<>(); // New listOfGradeItem List.
		
		processInput();
		generateReport();
		
	} // end main

	//***********************************************************************
	
	/*
	 * ProcessInput method scans and input file and using a split method turns 
	 * every line of input into an array of strings. The array's first index
	 * is compared to two possible options, based on the option either 
	 * processStudentData or processGradeItemData is called.  
	 */
	public static void processInput() throws IOException, InterruptedException {
		
		Scanner stdIn = new Scanner(new File(INPUT_FILENAME)); // creates new scanner
		// Print statement indicating input file is being read. 
		System.out.println("Reading data from file " + INPUT_FILENAME);
		
		// Determines if its is a Student or Grade Item input. 
		while(stdIn.hasNextLine()) {
			
			String[] arrayStrings = stdIn.nextLine().split(",");
			
			if(arrayStrings[0].equals("STUDENT")) {
				
				// Calls processStudentData method.
				processStudentData(arrayStrings); 
			} // end if
			
			else if(arrayStrings[0].equals("GRADE ITEM")) {
				
				// Calls processGradeItemData method.
				processGradeItemData(arrayStrings); 
			} 
			
			// Prints error if 'STUDENT' or 'GRADE ITEM' isn't registered. 
			// WARNING. will print error if there is blank line. 
			else { 
				System.err.println("Invalid entry in 'STUDENT' or 'GRADE ITEM' entry.");
			}
			
			// Include only if console prints improper order of operations. 
			TimeUnit.SECONDS.sleep((long) 0.1);
			
		} // end while
		
		stdIn.close(); // closes Scanner
	} // end processInput
	
	//***********************************************************************

	/*
	 * ProcessStudentData method takes in an array of data as a String and 
	 * determines if the input data is an 'ADD' or 'DEL'. 
	 */
	public static void processStudentData (String[] data) 
										   throws IllegalArgumentException {
		
		// Saves necessary data as a new Student object. 
		Student Student = new Student(data[2], data[3], data[4], data[5]);

		if(data[1].equals("ADD")) { 

			if(listOfStudents.contains(Student)) {
				System.out.println("List already contains Student data.");
			} else {
				listOfStudents.add(Student); // Adds Student object to List. 
				
				// If email address contains '@' prints successful addition to List.
				if (data[5].contains("@")) { 
					System.out.println("Student with Id " + data[2] 
							           + " was added to the list.");
				} // end if
			} // end else
		} // end if
			
		else if(data[1].equals("DEL")) {
			
			// If List does not contain Students prints. 
			if(!listOfStudents.contains(Student)) {
				System.out.println("Student with Student Id " + data[2] 
									+ " is not in the list.");
			} // end if
			
			if(listOfStudents.contains(Student)) {
				
				
				listOfStudents.remove(Student); // Deletes Student object from List. 
				System.out.println("Student with Student Id " + data[2] 
							       + " was removed from the list.");
			} // end if
			
		} else { // Prints error if 'ADD' or 'DEL' isn't registered. 
			System.err.println("Invalid input for 'ADD' or 'DEL' for a Student Item.");
		} // end if else
	} // end processStudentData
	
	//***********************************************************************

	/*
	 * ProcessGradeItemData method takes in an array of data as a String and 
	 * determines if the input data is an 'ADD' or 'DEL'. 
	 */
	public static void processGradeItemData(String[] data) 
										    throws IllegalArgumentException {
		
		// Saves necessary data as a new GradeItem object. 
		GradeItem gradeItem = new GradeItem(Integer.parseInt(data[2]), 
										    data[3], data[4], data[5], 
										    data[6], Integer.parseInt
										    (data[7]), Integer.parseInt(data[8]));
		
		if(data[1].equals("ADD")) {
			
			if(listOfGradeItem.contains(gradeItem)) {
				System.out.println("List already contains grade item data.");
			} else {
				listOfGradeItem.add(gradeItem); // Adds GradeItem object to List,
				System.out.println("Grade Item with Id " + data[2] 
					       + " was added the list.");
			} // end else
		} // end if
			
		else if(data[1].equals("DEL")) {
			
			if(listOfGradeItem.contains(gradeItem)) {
				
				// Deletes GradeItem object from List. 
				listOfGradeItem.remove(gradeItem); 				
				System.out.println("Grade Item with Id " + data[2] 
							       + " was removed from the list.");
			} // end if
			
			// If List does not contain gradeItem prints. 
			if(!listOfGradeItem.contains(gradeItem)) {
				System.out.println("Grade Item with Id " + data[2] 
									+ " is not in the list.");
			} // end if
			
		} else { // Prints error if 'ADD' or 'DEL' isn't registered. 
			System.err.println("Invalid input for 'ADD' or 'DEL' for a GradeItem.");
		} // end if else
	} // end processGradeItemData
	
	//***********************************************************************

	/*
	 * GenerateReport method calls onto toArray method in List and prints
	 * all Student objects and correlating GradeItem objects in the List
	 * to an output file. 
	 */
	public static void generateReport() throws IOException {
		
		// New print writer to write onto output file. 
		PrintWriter stdOut = new PrintWriter(new File(OUTPUT_FILENAME));
		
		// Arrays storing Student and GradeItem objects. 
		arrayOfStudents = new Student[listOfStudents.getCurrentSize()];
		arrayOfGradeItem = new GradeItem[listOfGradeItem.getCurrentSize()];
		
		// Calls toArray method in List, sending array as a parameter. 
		listOfStudents.toArray(arrayOfStudents);
		listOfGradeItem.toArray(arrayOfGradeItem);
		 
		int gradeItemListSize = listOfGradeItem.getCurrentSize();
		
		// Prints onto console that report generation has began.
		System.out.print("Generating report ... ");
		
		stdOut.printf("Output Report for File: %s\n\n", INPUT_FILENAME);
		// Iterates through array of Student objects and prints onto output file.  
		for(int i = 1; i < listOfStudents.getCurrentSize(); i++) {
			int totalMax = 0; // Double in order to calculate percent. 
			int totalActual = 0;
			int totalPercent = 0;
			
			// Prints Student information. 
			stdOut.printf("%s   %s  %s  %s\n", arrayOfStudents[i].getStudentID()
					      , arrayOfStudents[i].getFirstName()
					      , arrayOfStudents[i].getLastName()
					      , arrayOfStudents[i].getEmailAddress());
			stdOut.println("  Grade Items");
			
			// Iterates through array of GradeItem objects and prints onto output file. 
			for(int t = 0; t < gradeItemListSize; t++) {

				// Prints only GradeItems correlated to specific Student. 
				if (arrayOfStudents[i].getStudentID().contentEquals
				   (arrayOfGradeItem[t].getStudentId())) {

					// Prints GradeItem information. 
					stdOut.printf("  %d   %s  %5s", arrayOfGradeItem[t].getGradeItemId()
						      , arrayOfGradeItem[t].getCourseId()
						      , arrayOfGradeItem[t].getItemType());
					stdOut.printf("  %s   %d  %d\n", arrayOfGradeItem[t].getDate()
							  , arrayOfGradeItem[t].getMaximumScore()
							  , arrayOfGradeItem[t].getActualScore());
					
					// Adds GradeItem actual and maximum scores. 
					totalMax += arrayOfGradeItem[t].getMaximumScore();
					totalActual += arrayOfGradeItem[t].getActualScore();
					
				} // end if
			} // end for
			stdOut.println("==================================================");
			
			// Calculates percent of Grade based on actual and max scores. 
			// Cast to double to find decimal ration of totalActual and totalMax.
			totalPercent = (int) (100 * ((double)totalActual/totalMax));
			
			// Prints GradeItem actual and maximum Scores, plus the percent. 
			stdOut.println("  Total                        " + 
						   totalMax + "  " + totalActual + "   " 
						   + totalPercent + "%");
			
			stdOut.println(" "); // Prints blank line
			
		} // end for
		
		System.out.println(" done."); // Prints on same line as "Generating report... "
		stdOut.close(); // Closes print writer. 
		
	} // end generateReport
} // end ZackKhalidov_03
