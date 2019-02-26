/*
 * Student class is used to store students personal information.
 * Zack Khalidov
 * Project #1
 * Windows, PC, Eclipse.
 * coagulate: verb - change to a solid or semisolid state.
 * "There are two kings of immature people: those who do not see their own mistakes
 * 	as mistakes, and those who do not forgive mistakes committed by someone else."
 * 	- Aguttara Nikoya (I.59) 
 */

package zackKhalidov_2_01;

/**
 * Student class is used to store students personal information.
 * 
 * @author Zack Khalidov
 * @version 08/29/2018
 */

public class Student {
	
	// Declare variables
	
	private String studentId = ""; // Student ID number
	private String firstName = ""; // Students first name
	private String lastName = ""; // Students last name
	private String emailAddress = ""; // students email address

	private String emailCharValue = "@"; // Contains '@' character
	
	/**
	 * Creates a new Student object. Validating the imported instance variables; 
	 * String is validated by using isEmpty method to make sure the String is not 
	 * empty. emailAddress is validated by using contains() method to search for 
	 * char '@' that is saved in the private String emailCharValue.  
	 * 
	 * @param studentId this is the student ID.
	 * @param firstName this is the students first name.
	 * @param lastName this is the students last name.
	 * @param emailAddress this is the students email address 
	 * 		  (must contain @ symbol). 
	 */
	
	public Student (String studentId, String firstName, String lastName, 
			String emailAddress) {
		
		if (studentId.isEmpty() || firstName.isEmpty() || lastName.isEmpty()
				|| emailAddress.isEmpty()) {
			throw new IllegalArgumentException ();
		} // end if
		
		if (!(emailAddress.contains(emailCharValue))) {
			throw new IllegalArgumentException ();
		} // end if
		
		// Declare Variables
		
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;

	} // end Student
	
	//***************************************************************
	
	/**
	 * This method returns variable studentId. 
	 * @return studentId
	 */
	
	public String getStudentID () {
		return this.studentId;
	} // end getStudentID
	
	//***************************************************************
	
	/**
	 * This method returns variable firstName.
	 * @return firstName
	 */
	
	public String getFirstName () {
		return this.firstName;
	} // end getFirstName
	
	//***************************************************************
	
	/**
	 * This method returns variable lastName.
	 * @return lastName
	 */
	
	public String getLastName () {
		return this.lastName;
	} // end getLastName
	
	//***************************************************************
	
	/**
	 * This method returns variable emailAddress.
	 * @return emailAddress
	 */
	
	public String getEmailAddress () {
		return this.emailAddress;
	} // end getEmailAddress
	
	//***************************************************************
	
	/*
	 * This method return an object variables as a formatted String.
	 * 
	 * @return a String variable containing instances of an object.
	 */
	
	@Override
	public String toString () {
		 return  String.format ("Student{studentID=%s,firstName= %s,lastName=%s,"
		 		+ "\nemailAddress=%s}\n", this.studentId, this.firstName, 
		 		this.lastName, this.emailAddress); 
		 
	} // end toString
	
	//***************************************************************
	
	/**
	 * Compares equality of two objects from the same class and returns boolean.
	 * 
	 * @param other is the object being compared against. 
	 * 
	 * @return boolean, if true objects are same, else objects are different.
	 */
	
	public boolean equals (Student other) {	
		
		if(studentId.equals(other.studentId) && firstName.equals(other.firstName) 
				&& lastName.equals(other.lastName) 
				&& emailAddress.equals(other.emailAddress)) {
			
			return true;
		} // end if

		return false;
		
	} // end equals
} // end Student
