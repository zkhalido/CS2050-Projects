/*
 * GradeItem class is used to store students grade type and specifications.
 * Zack Khalidov
 * Project #1
 * Windows, PC, Eclipse.
 * renounce noun - formally declare one's abandonment of a claim.
 * "People forget that their lives will end soon. For those who remember,
 * 	quarrels come to an end."
 *  - The Dhammapada pp. 106
 */

package zackKhalidov_03;

import java.util.Arrays;
import java.util.Objects;


/**
 * GradeItem class is used to store students grade type and specifications.
 * 
 * @author Zack Khalidov
 * @version 08/29/2018
 */

public class GradeItem 
{
	
	// Declare variables
	
	private int gradeItemId = 0; // Grade Item ID number
	private String studentId = ""; // Student ID number
	private String courseId = ""; // Course ID number
	private String itemType = ""; // Grade Item type 
	private String date = ""; // Date of the grade posted
	private int maximumScore = 0; // Maximum Score of the grade
	private int actualScore = 0; // Actual Score of the grade

	// Array of available Grade Item Types
	private String[] itemTypeValue = {"HW","Quiz","Class Work","Test", "Final"};
		
	/**
	 * Creates a new Grade Item object. Validating the imported instance variables; 
	 * String is validated by using isEmpty method to make sure the String is not 
	 * empty, the integers are set to a range between 1 and 100, and itemType is 
	 * compared to a String array containing the valid types (HW, Quiz, Class Work,
	 * Test, or Final.
	 * 
	 * @param gradeItemId this is the ID # for the grade.
	 * @param studentId this is the student ID thats associated with the grade.
	 * @param courseId this is the course ID from which the grade is being applied.
	 * @param itemType this is the type of grade being received (HW, Quiz, Test, Final...)
	 * @param date this is the date of the grade (format: yyyymmdd)
	 * @param maximumScore this is the maximum score that can be posted.
	 * @param actualScore this is the actual score of the grade.
	 */
	
	public GradeItem (int gradeItemId, String studentId, String courseId
			, String itemType, String date, int maximumScore, int actualScore) {

		if (studentId.isEmpty() || courseId.isEmpty() || itemType.isEmpty() 
				|| date.isEmpty()) {
			System.out.println(studentId + courseId + itemType 
				+ date);
			throw new IllegalArgumentException ();
		} // end if
				
		if (maximumScore < 1) { // Verifies maximumScore is not smaller than 1.
			throw new IllegalArgumentException ();
		} // end if
		
		/*
		 * Verifies that the actualScore value is between the of maximumScore and 0.
		 */
		
		if (actualScore <= 0  && actualScore >= maximumScore) { 
			throw new IllegalArgumentException ();
		} // end if
		
		/*
		* This if statement converts the array itemTypeVerification into a list, then 
		* scans the list by using contain() method to validate that itemType input 
		* is a valid type. 
		*/
				
		if (!Arrays.asList(itemTypeValue).contains(itemType)) {
			throw new IllegalArgumentException ();
		} // end if
				
		this.gradeItemId = gradeItemId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.itemType = itemType;
		this.date = date;
		this.maximumScore = maximumScore;
		this.actualScore = actualScore;

	} // end GradeItem
	
	//***************************************************************
	
	/**
	 * This method returns variable gradeItemId.
	 *  
	 * @return gradeItemId
	 */
	
	public int getGradeItemId (){
		return this.gradeItemId;
	} // end getGradeItemId
		
	//***************************************************************
	
	/**
	 * This method returns variable studentId.
	 * 
	 * @return studentId
	 */
	
	public String getStudentId () {
		return this.studentId;
	} // end getStudentId
		
	//***************************************************************
	
	/**
	 * This method returns variable courseId.
	 * 
	 * @return courseId
	 */
	
	public String getCourseId () {
		return this.courseId;
	} // end getCourseId
		
	//***************************************************************
	
	/**
	 * This method returns variable itemType.
	 * 
	 * @return itemType
	 */
	
	public String getItemType () {
		return this.itemType;
	} // end getItemType
		
	//***************************************************************
	
	/**
	 * This method returns variable date.
	 * 
	 * @return date
	 */
	
	public String getDate () {
		return this.date;
	} // end getDate
		
	//***************************************************************
	
	/**
	 * This method returns variable maximumScore.
	 * 
	 * @return maximumScore
	 */
	
	public int getMaximumScore() {
		return this.maximumScore;
	} // end getMaximumScore
		
	//***************************************************************
	
	/**
	 * This method returns variable actualScore.
	 * 
	 * @return actualScore
	 */
	
	public int getActualScore() {
		return this.actualScore;
	} // end getActualScore
		
	//***************************************************************
	
	/*
	 * This method converts an instance of an object into a String and saves it
	 * to a String variable that is returned.
	 * 
	 * @return toString is a String variable containing an instance of an object.
	 */
	
	@Override
	public String toString () {
		
		return String.format ("GradeItem{gradeItemID=%d,studentID=%s,courseID="
				+ "%s,\ntype=%s,date=%s,maximumScore=%d,actualScore=%d}\n"
				, gradeItemId, studentId, courseId, itemType, date
				, maximumScore, actualScore);
	} // end toString
		
	//***************************************************************
	
	/**
	 * This method compares equality of two objects in the same class and returns boolean.
	 * 
	 * @param other is the object being compared against. 
	 * 
	 * @return boolean, if true objects are same, else objects are different.
	 */
	@Override
	public boolean equals (Object other) {	
		
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		}
		
        final GradeItem object = (GradeItem) other;

        if (!Objects.equals(this.gradeItemId, object.gradeItemId)) {
            return false;
        }
        if (!Objects.equals(this.studentId, object.studentId)) {
            return false;
        }
        if (!Objects.equals(this.courseId, object.courseId)) {
            return false;
        }
        if (!Objects.equals(this.itemType, object.itemType)) {
            return false;
        }
        if (!Objects.equals(this.date, object.date)) {
            return false;
        }
        if (!Objects.equals(this.maximumScore, object.maximumScore)) {
            return false;
        }
        if (!Objects.equals(this.actualScore, object.actualScore)) {
            return false;
        }
        
		return true;
		
	} // end equals
	
	// Generic hash code generation for comparing objects. 
	@Override
	public int hashCode() {
		int hash = 0;
		
		hash = 97 * hash + Objects.hashCode(this.gradeItemId);
		hash = 97 * hash + Objects.hashCode(this.studentId);
		hash = 97 * hash + Objects.hashCode(this.courseId);
		hash = 97 * hash + Objects.hashCode(this.itemType);
		hash = 97 * hash + Objects.hashCode(this.date);
		hash = 97 * hash + Objects.hashCode(this.maximumScore);
		hash = 97 * hash + Objects.hashCode(this.actualScore);

		return hash;
	} // end hashCode
} // end GradeItem
