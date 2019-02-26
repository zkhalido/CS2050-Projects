/*
 * List class is used to save Student and GradeItems of type T.
 * Zack Khalidov
 * Project #3
 * Windows, PC, Eclipse.
 */
package zackKhalidov_03;

/**
 * List class is used to save Student and GradeItems of type T.
 * 
 * @author zack1
 * @param <T>
 * @version 10/14/2018
 */


public class List<T> implements MyCollectionInterface<T>{
	
	private T[] list;
	private int numberOfEntries = 0;
	private static final int DEFAULT_CAPACITY = 25; 
	
	public List() {
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[DEFAULT_CAPACITY  + 1];
		list = tempList;
	} // end List 

	//***********************************************************************
	
	/**
	 * Adds a new entry to this collection
	 * 
	 * @param newItem The object to be added to the collection
	 * @return True if the addition is successful, or false if not.
	 */
	@Override
	public boolean add(T newItem) {
		
		try {
			list[numberOfEntries + 1] = newItem;
			numberOfEntries++;
			return true;
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			return false;
		} // end try/catch
	} // end add

	//***********************************************************************
	
   /**
	* Removes one unspecified entry from the collection, if possible.
	*
	* @return Either the removed entry, if the removal was successful, or
	* null.
	*/
	@Override
	public T remove() {
		T temp = null;
	
		if(isEmpty() == false && numberOfEntries >= 0) {
			temp = list[numberOfEntries];
			list[numberOfEntries] = null;
			numberOfEntries--;
		} // end if
		return temp;
	} // end remove

	//***********************************************************************
	
	/**
	 * Removes one occurrence of a given entry from this collection.
	 *
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
		int position = 0;
		
		for(int i = 1; i <= numberOfEntries && found == false; i++) {
			if(list[i] == anEntry) {
				position = i;
				found = true;
			} // end if
		} // end for
		
		for(int i = position; i <= numberOfEntries; i++) {
			list[i] = list[i++];
		} // end for
		
		numberOfEntries--;
		
		return found;
	} // end remove

	//***********************************************************************
	
   /**
	* Removes all entries from this collection.
	*/
	@Override
	public void clear() {
		
		numberOfEntries = 0;
		
	} // end clear

	//***********************************************************************
	
   /**
	* Gets the current number of entries in this collection.
	*
	* @return The integer number of entries currently in the collection.
	*/
	@Override
	public int getCurrentSize() {
		if(numberOfEntries <= 0) {
			return 0;
		}
		return numberOfEntries;
	}

	//***********************************************************************
	
   /**
	* Check to see if the collection is empty.
	*
	* @return True if the collection is empty, or false if not.
	*/
	@Override
	public boolean isEmpty() {
		
		if(getCurrentSize() > 0) {
			return false;
		} // end if
		return true;
	} // end isEmpty

	//***********************************************************************
	
   /**
	* Counts the number of times a given entry appears in this collection.
    *
	* @param anEntry The entry to be counted.
	* @return The number of times anEntry appears in the collection.
	*/
	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		
		for(int i = 0; i < numberOfEntries; i++) {
			if(list[i] == anEntry) {
				frequency++;
			} // end if
		} // end for
		return frequency;
	} // end getFrequencyOf

	//***********************************************************************
	
   /**
	* Tests whether this collection contains a given entry.
	*
	* @param anEntry The entry to locate.
	* @return True if the collection contains anEntry, or false if not.
	*/
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		int index = 1;
		while(!found && (index <= numberOfEntries)) {
			if(list[index].equals(anEntry)) {
				found = true;
			} // end if
			index++;
		} // end for
		
		return found;
	} // end contains

	//***********************************************************************
	
   /**
	* Takes in an array and assigns list items to array. 
	*/
	@Override
	public void toArray(T[] result) {
		
		for(int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		} // end for
		
	} // end toArray
} // end List
