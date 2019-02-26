/**
 * This is the main class, it creates a LinkedList of Student and GradeItem by 
 * reading from a input .txt file 'hw3input01.txt' 
 * Zack Khalidov
 * Project #4
 * Windows, PC, Eclipse.
 * beneficiary: noun - a person who derives advantage from something, 
 * especially a trust, will, or life insurance policy.
 * 
 * "The truth is not for all men, but only for those who seek it."
 * - Ayn Rand
 */

package zackKhalidov_04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Imported in case IDE does not utilize packages. 
import zackKhalidov_04.GradeItem;
import zackKhalidov_04.LinkedList;
import zackKhalidov_04.Student;

/**
 * This is the main class, it creates a LinkedList of Student and GradeItem by 
 * reading from a input .txt file 'hw3input01.txt' 
 * 
 * @author zack1
 * @version 10/26/2018
 */
public class ZackKhalidov_04 {

	// Declare fields
	private static LinkedList<Student> listOfStudents; // List for Student Items
	private static LinkedList<GradeItem> listOfGradeItem; // List for GradeItem Items
		
	private static Student[] arrayOfStudents; // Array of Student objects
	private static GradeItem[] arrayOfGradeItem; // Array of GradeItem objects
		
	// Final strings storing input and output file names. 
	private final static String INPUT_FILENAME = "hw3input01.txt";
	private final static String OUTPUT_FILENAME = "hw3output.txt";
		
	public static void main(String[] args) 
							throws IOException, InterruptedException {
		
		listOfStudents = new LinkedList<>(); // New listOfStudents List.
		listOfGradeItem = new LinkedList<>(); // New listOfGradeItem List.
		
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
				break; // Terminates while loop. 
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

			if(data[5].contains("@")) {
				if(listOfStudents.contains(Student)) {
					System.err.println("Error: LinkedList already contains Student data.");
				} else {
					
					// Adds to LinkedList. 
					if (listOfStudents.add(Student)) { 
						System.out.println("Student with Id " + data[2] 
						           + " was added to the Linkedlist.");
					} else { // If returns false
						System.err.println("Error: Add to LinkedList failed.");
					} // end else
				} // end else
			} // end if
		} // end if
			
		else if(data[1].equals("DEL")) {
			
			// If List does not contain Students prints. 
			if(!listOfStudents.contains(Student)) {
				System.out.println("Student with Student Id " + data[2] 
									+ " is not in the Linkedlist.");
			} // end if
			
			if(listOfStudents.contains(Student)) {

				if (listOfStudents.remove(Student)) { // Deletes Student object from List.
					System.out.println("Student with Student Id " + data[2] 
						       + " was removed from the Linkedlist.");
				} else { // If returns false
					System.err.println("Error: Delete from LinkedList failed.");
				} // end else
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
				System.err.println("Error: LinkedList already contains grade item data.");
			} else {
				
				// Adds to LinkedList. 
				if (listOfGradeItem.add(gradeItem)) { // Adds GradeItem object to List,
					System.out.println("Grade Item with Id " + data[2] 
						       + " was added the Linkedlist.");
				} else { // If returns false
					System.err.println("Error: Add to LinkedList failed.");
				} // end else
			} // end else
		} // end if
			
		else if(data[1].equals("DEL")) {
			
			// If List does not contain gradeItem prints. 
			if(!listOfGradeItem.contains(gradeItem)) {
				System.out.println("Grade Item with Id " + data[2] 
									+ " is not in the Linkedlist.");
			} // end if
			
			if(listOfGradeItem.contains(gradeItem)) {
				
				if (listOfGradeItem.remove(gradeItem)) { // Deletes GradeItem object from List.
					System.out.println("Grade Item with Id " + data[2] 
						       + " was removed from the Linkedlist.");
				} else { // If returns false
					System.err.println("Error: Delete from LinkedList failed.");
				} // end else
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
		
		// Calls toArray method in LinkedList, sending array as a parameter. 
		listOfStudents.toArray(arrayOfStudents);
		listOfGradeItem.toArray(arrayOfGradeItem);
		
		int studentListSize = listOfStudents.getCurrentSize(); 
		int gradeItemListSize = listOfGradeItem.getCurrentSize();

		
		// Prints onto console that report generation has began.
		System.out.print("Generating report ... ");
		
		stdOut.printf("Output Report for File: %s\n\n", INPUT_FILENAME);
		// Iterates through array of Student objects and prints onto output file.  
		for(int i = 0; i < studentListSize; i++) {
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
			// Cast to double to find decimal ratio of totalActual and totalMax.
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

} // end ZackKhalidov_04
