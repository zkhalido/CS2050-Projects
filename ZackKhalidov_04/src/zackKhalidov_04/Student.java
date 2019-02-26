/*
 * Student class is used to store students personal information.
 * Zack Khalidov
 * Project #1
 * Windows, PC, Eclipse.
 * coagulate: verb - change to a solid or semisolid state.
 * "There are two kinds of immature people: those who do not see their own mistakes
 * 	as mistakes, and those who do not forgive mistakes committed by someone else."
 * 	- Aguttara Nikoya (I.59) 
 */

package zackKhalidov_04;

import java.util.Objects;

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
			System.err.printf("Error: Email address " + emailAddress + " is invalid.\n");
		} else {
			// Declare Variables
			this.studentId = studentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailAddress = emailAddress;
		}
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
		 return  String.format ("Student{studentID=%s,firstName=%s,lastName=%s,"
		 		+ "\nemailAddress=%s}\n", this.studentId, this.firstName, 
		 		this.lastName, this.emailAddress); 
		 
	} // end toString
	
	//***************************************************************
	
	/**
	 * Compares equality of two objects from the same class and returns boolean.
	 * 
	 * @param other is the object being compared against. 
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
		
        final Student object = (Student) other;

        if (!Objects.equals(this.studentId, object.studentId)) {
            return false;
        }
        if (!Objects.equals(this.firstName, object.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, object.lastName)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, object.emailAddress)) {
            return false;
        }
        
		return true;
		
	} // end equals
	
	// Generic hash code generation for comparing objects.
	@Override
	public int hashCode() {
		int hash = 0;
		
		hash = 97 * hash + Objects.hashCode(this.studentId);
		hash = 97 * hash + Objects.hashCode(this.firstName);
		hash = 97 * hash + Objects.hashCode(this.lastName);
		hash = 97 * hash + Objects.hashCode(this.emailAddress);

		return hash;
	} // end hashCode
} // end Student
