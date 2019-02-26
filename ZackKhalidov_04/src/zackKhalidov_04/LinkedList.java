/*
 * ListList class is a data structure that saves
 * data of type <T> in single pointer Nodes.
 * 
 * Zack Khalidov
 * Project #4
 * Windows, PC, Eclipse.
 */
package zackKhalidov_04;
/**
 * LinkedList class stores data of type <T> by 
 * implementing MycollectionInterfaceProject04. 
 * 
 * @author zack1
 * @param <T>
 * @version 10/26/2018
 */

public class LinkedList<T> implements MyCollectionInterfaceProject04<T> {
	
	private Node firstNode; // Pointer to first Node in LinkedList. 
	
	// Counter for the number of entries in the LinkedList 
	private int numberOfEntries; 
								 
	// Constructor calls method to initialize data fields. 
	LinkedList () {
		// initializes empty LinkedList
		initializeDataFields();
	}

    /**
     * Adds a new entry to this collection
     * 
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
	@Override
	public boolean add(T newItem) {
		boolean result = false;
		
		Node newNode = new Node(newItem);
		
		newNode.next = firstNode;
		firstNode = newNode;
		
		// Changes result to true firstNode equals newNode
		if (firstNode.equals(newNode)) {
			result = true;
			numberOfEntries ++; // Increments number of entries. 
		}

		return result;
	}

    /**
     * Adds a new entry to this collection at the given position
     * 
     * @param newItem The object to be added to the collection
     * @param position The location where newItem will be inserted.
     * @return True if the addition is successful, or false if not.
     */
	@Override
	public boolean add(T newItem, int givenPosition) {
		boolean result = false;
		
		if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
			Node newNode = new Node(newItem);
			
			if (givenPosition == 0) { // Case 1
				newNode.next = firstNode;
				firstNode = newNode;
				numberOfEntries ++;
				add(newItem);
				result = true;
			} else {
				Node currentNode = firstNode;
				
				for (int i = 1; i < givenPosition; i++) {
					currentNode = currentNode.next;
				}
				
				newNode.next = currentNode.next;
				currentNode.next = newNode; 
				numberOfEntries ++;
			} // end if else
		} else {
			throw new IndexOutOfBoundsException("Illegal position given.");
		}
		return result;
	}
	
	/**
	 * Removes the first Node in LinkedList. 
	 * Exclaimer: Removed Node still exists, rather it's existence
	 * is ignored by Node's next field (pointer). 
	 * 
	 * @return T data Node's data field that was removed. 
	 */
	public T remove() {
		
		T data = firstNode.data; // Sets Node data field to local variable.  
		firstNode = firstNode.next; // Points firstNode field to next Node. 
		
		return data;
	}

    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
	@Override
	public boolean remove(T anEntry) {

		boolean result = false;
		
		Node currentNode = find (anEntry);
		Node previousNode = firstNode;
		
		while (previousNode != null && previousNode != currentNode.getNext()) {
			
			if (previousNode == currentNode) {
				remove();
				numberOfEntries--;
				result = true;
			} else if (previousNode.next == currentNode) {
				previousNode = currentNode.getNext();
				numberOfEntries --;
				result = true;
			} // end else if
			
			previousNode = previousNode.next; // Iterates through the list. 
		} // end while
			return result;
	} // end remove
	
    /**
     * Removes all entries from this collection.
     */
	@Override
	public void clear() {
		initializeDataFields();
	} // end clear

    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
	@Override
	public int getCurrentSize() {
		 
		return numberOfEntries;
	}
	
    /**
     * Checks to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
	@Override
	public boolean isEmpty() {
		
		boolean result;
		
		// firstNode == null
		if (numberOfEntries == 0) {
			result = true;
		} else { // firsNode != null
			result = false;
		} // end if
		
		return result;
	} // end isEmpty

    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
	@Override
	public int getFrequencyOf(T anEntry) {
		
		Node currentNode = new Node(anEntry);
		int count = 0;
		
		for (int i = 0; i <= numberOfEntries; i++) {
			
			if (anEntry.equals(currentNode.getData())) {
				count ++;
			}
			currentNode = currentNode.getNext();
		}
		return count;
	}

    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
	@Override
	public boolean contains(T anEntry) {
		
		boolean found = false;
		
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData())) {
				found = true;
			} else {
				currentNode = currentNode.getNext();
			} // end if else
		} // end while
		
		return found;
		
	} // end contains

    /**
     * Retrieves all entries that are in this collection, saving 
     * to the passed array. 
     */
	@Override
	public void toArray(T[] result) {
		
		Node currentNode = firstNode;
		
		for (int i = numberOfEntries; i > 0; i--) {
			
			result[i - 1] = (T) currentNode.getData();
			currentNode = currentNode.getNext();
	
		} // end for
	} // end toArray
	
	/**
	 * Initializes class fields. 
	 */
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	/**
	 * Finds Node in the LinkedList that is same as given value.
	 * @param anEntry
	 * @return Node with same data field as given value. 
	 */
	private Node find (T anEntry) {
		Node pn = firstNode;
		
		while (pn != null && !pn.data.equals(anEntry)) {
			pn = pn.next;
		}
		return pn;
	}
	
	/**
	 * Node class with one pointer to next Node.
	 * 
	 * @author zack1
	 * @version 10/16/2018
	 */
	private class Node {
		
		private T data;
		private Node next;
		
		private Node (T anEntry) {
			data = anEntry;
			next = null;
		}
		
		private T getData() {return data;}
		
		private Node getNext() {return next;}
		
		private void setData(T anEntry) {data = anEntry;}
		
		private void setNext (Node next) {this.next = next;}
		
	} // end Node
} // end LinkedList
		