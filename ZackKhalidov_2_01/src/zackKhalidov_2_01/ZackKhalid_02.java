/*
 * This is the main class running the classes Student, and GradeItem,
 * It runs 3 tests with the provided information. 
 * Zack Khalidov
 * Project #2
 * Windows, PC, Eclipse
 * allure: verb - to attract or tempt by something flattering or desirable.
 * "When you are content to be simply yourself and don't compare or comepete,
 * everyone will respect you."
 * - Lao Teu, Tao Teh Ching
 */

package zackKhalidov_2_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ZackKhalid_02 is used to create 2 objects of each class; Student and GradeItem,
 * and runs 3 tests on the information the hold.  
 * @author Zack Khalidov
 * @version 09/16/2018
 */

public class ZackKhalid_02 {

	// Declare variables and fields 
	
	private static Student student1; // Student object #1
	private static Student student2; // Student object #2
		
	private static GradeItem gradeItem1; // Grade Item object #1
	private static GradeItem gradeItem2; // Grade Item object #2
		
	// Constant variable storing input text file name
	private static final String INPUT_FILENAME = "Project_02_Input01.txt";
	
	// Arrays used to store input from text file 
	private static String studentFileArray[] = new String[6];
	private static String gradeItemFileArray[] = new String[9];
		
	/*
	* Main class reads from text file and runs 3 tests on information in text file,
	* information in the file is saved as objects of either Student or Grade Item. 
	*/
		
	public static void main(String[] args) throws FileNotFoundException {

		/**
		 * Test Set 1.
		 * Tests the constructor with parameters for each field and the toString method.
		 */
			
		System.out.println("Running Test 1a:");
		
		// Creates and object and instantiates using given parameters. 
		student1 = new Student("900123548", "Joe", "Doe", "joedoe@msudenver.edu");
		
		// Calls toString method to print the object.
		System.out.println(student1.toString());
		
		System.out.println("Running Test 1b:");
 
		// Creates and object and instantiates using given parameters.
		gradeItem1 = new GradeItem(1, "900458764", "23456", "HW", "20170112", 100, 95);
		
		// Calls toString method to print the object.
		System.out.println(gradeItem1.toString());
		
		//************************************************************
		
		/**
		 * Test set 2.
		 * Tests the constructors and getters, and will also test reading data from 
		 * the input file. 
		 */
		
		// Creates a new scanner object 'stdIn' to read the input file. 
		Scanner stdIn = new Scanner(new File(INPUT_FILENAME));
		
		//************************************************************

		/**
		 * Test 2a.
		 * Splits a line from input file by ',' character and saves to an array of strings,
		 * and tests the getter methods of class Student.   
		 */
		
		System.out.println("Running Test 2a: ");
		
		// Reads a line from input file, splitting and saving to an array of strings.
		studentFileArray = stdIn.nextLine().split(",");
		
		// Compares the first index of an array to the given parameter 'STUDENT'
		// If true, calls processStudentData method.
		if(studentFileArray[0].contentEquals("STUDENT")) {
			processStudentData(studentFileArray);
		} // end if
		else {
			System.err.println("File does not contain 'STUDENT'.");
		} // end else
		
		System.out.println("Student Object Data");
		
		// Prints the return variables from Student getter methods.
		System.out.printf("%s\n%s\n%s\n%s\n\n", student2.getStudentID(),
				student2.getFirstName(), student2.getLastName(),
				student2.getEmailAddress());
		
		//************************************************************
		
		/**
		 * Test 2b.
		 * Splits a line from input file by ',' character and saves to an array of strings,
		 * and tests the getter methods of class GradeItem. 
		 */
		
		System.out.println("Running Test 2b: "); 
		
		// Reads a line from input file, splitting and saving to an array of strings.
		gradeItemFileArray = stdIn.nextLine().split(",");
		
		// Compares the first index of an array to the given parameter 'GRADE ITEM'
		// If true, calls gradeItemFileArray method.
		if(gradeItemFileArray[0].contentEquals("GRADE ITEM")) {
			processGradeItemData(gradeItemFileArray);
		} // end if
		else {
			System.err.println("File does not contain 'STUDENT'.");
		} // end else
		
		System.out.println("GradeItem Data");
		
		// Prints the return variables from GradeItem getter methods. 
		System.out.printf("%d\n%s\n%s\n%s\n%s\n%d\n%d\n\n", 
						  gradeItem2.getGradeItemId(), gradeItem2.getStudentId(),
						  gradeItem2.getCourseId(), gradeItem2.getItemType(),
						  gradeItem2.getDate(), gradeItem2.getMaximumScore(),
						  gradeItem2.getActualScore());

		stdIn.close(); // Closes the scanner object. 
		
		//************************************************************
		
		/**
		 * Test set 3.
		 * Tests the equals method for both classes; GradeItem and Student. 
		 */
		
		System.out.println("Running Test 3a: ");
		
		// Checks for equality between two Student objects. 
		if(student1.equals(student2)) {
			System.out.println("Student objects are equal.\n");
		} // end if
		else {
			System.out.println("Student objects are not equal.\n");
		} // end else
		
		System.out.println("Running test 3b: ");
		
		// Checks for equality between two GradeItem objects.
		if(gradeItem1.equals(gradeItem2)) {
			System.out.printf("Grade Item objects are equal.\n");
		} // end if
		else {
			System.out.println("Grade Item objects are not equal.\n");
		} // end else
	} // end main
		
	//************************************************************
		
	private static void processStudentData (String[] studentFileArray) {
		
		/**
		 * Scans an array of strings from text file for 'ADD' and creates a new object 
		 * with remaining contents of the array of strings. 
		 * 
		 * @param studentFileArray array of strings holding parameters to create
		 *        new Student object. 
		 */
		
		try {
			if(studentFileArray[1].contentEquals("ADD")) {
				student2 = new Student(studentFileArray[2], studentFileArray[3], 
									   studentFileArray[4], studentFileArray[5]); 
			} // end if 
		} // end try
		catch (Exception e) {
			System.err.println("Could not create object error.");
		} // end catch
	} // end processStudentData 
	
	//************************************************************
	
	private static void processGradeItemData(String[] gradeItemFileArray) {
	
		/**
		 * Scans an array of strings from text file for 'ADD' and creates a new object 
		 * with remaining contents of the array of strings. 
		 * 
		 * @param gradeItemFileArray array of strings holding parameters to create
		 *        new GradeItem object. 
		 */
		
		try {
			if(gradeItemFileArray[1].contentEquals("ADD")) {
				gradeItem2 = new GradeItem(Integer.parseInt(gradeItemFileArray[2]), 
										   gradeItemFileArray[3], gradeItemFileArray[4], 
										   gradeItemFileArray[5], gradeItemFileArray[6], 
										   Integer.parseInt(gradeItemFileArray[7]),
										   Integer.parseInt(gradeItemFileArray[8]));
			} // end if 
		} // end try
		catch (Exception e) {
			System.err.println("Could not create object error.");
		} // end catch
	} // end processGradeItemData
} // end ZackKhalid_02
