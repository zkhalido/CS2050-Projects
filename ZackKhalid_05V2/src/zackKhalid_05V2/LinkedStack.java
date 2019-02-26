/*
 * LinkedStack is a data structure that saves 
 * data type <T> in single pointer Nodes.
 *
 * Zack Khalidov
 * Project #4
 * Windows, PC, Eclipse.
 */
package zackKhalid_05V2;

import java.util.EmptyStackException;

/**
 * LinkedStack is a data structure that saves 
 * data type <T> in single pointer Nodes.
 * 
 * @author Zack Khalidov
 * @param <T>
 * @version 11/14/2018
 */
public class LinkedStack <T> {
	
	private Node topNode; // Pointer to top Node.
	
	// Constructor sets topNode to null.
	public LinkedStack() {
		topNode = null;
	} // end LinkedStack
	
	/**
	 * Adds a new entry to the top of the stack.
	 * 
	 * @param item is a new entry.
	 */
	public void push(T character) {
		
		// Adds a new Link to list and points topNode to the Link.
		Node newNode= new Node(character, topNode);
		topNode = newNode;
	} // end push
	
	/**
	 * Removes and returns the stack's top entry.
	 * 
	 * @return Returns the stack's top entry.
	 * @exception Throws exception if the stack is empty
	 * 			  before the operation.
	 */
	public T pop() {

		T top = peek(); // Throws exception if stack is empty.
		
		// Sets top of stack to next link. 
		topNode = topNode.getNext();
		
		return top;
		
	} // end pop

	/**
	 * Retrieves the stacks top entry without changing the stack.
	 * 
	 * @return Returns the stack's top entry.
	 */
	public T peek() {
		
		if (isEmpty()) { // Throws exception if empty.
			throw new EmptyStackException();
		} else {
			// Returns the data in top Link of stack.
			return topNode.getData();
		} // end if else
		
	} // end peek
	
	/**
	 * Detects whether the stack is empty.
	 * 
	 * @return Returns true if stack is empty.
	 */
	public boolean isEmpty() {
		
		return topNode == null; // Checks if topNode is null;
		
	} // end isEmpty
	
	/**
	 * Removes all entries from the stack.
	 */
	public void clear() {
		
		topNode = null; // Sets topNode pointer to null.
		
	} // end clear
	
	/**
	 * Node class with one pointer to next Node.
	 */
	private class Node {
		
		private T data;
		private Node next;
		
		private Node (T anEntry, Node next) {
			data = anEntry;
			this.next = next;
		}
		
		private T getData() {return data;}
		
		private Node getNext() {return next;}
		
		private void setData(T anEntry) {data = anEntry;}
		
		private void setNext (Node next) {this.next = next;}
		
	} // end Node
} // end LinkedStack
