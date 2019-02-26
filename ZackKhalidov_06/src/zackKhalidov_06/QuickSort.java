/*
 * QuickSort class takes in an array of int and sorts numbers in array 
 * from lowest order to highest. 
 * 
 * Zack Khalidov
 * Project #6
 * Windows, PC, Eclipse.
 */

package zackKhalidov_06;

/**
 * ShellSort class takes in an array of int and sorts numbers in array 
 * from lowest order to highest.
 * 
 * @author Zack Khalidov
 * @version 11/30/2018
 */

public class QuickSort {
	
	// Declare fields.
	private int i;
	private int j;
	private int tmp;
	private int pivot;
	private int pi;
	
	public void quickSort(int[] array, int low, int high) {
		pi = partition(array, low, high);
		
		if (low < pi - 1) {
			quickSort(array, low, pi -1);
		} // end if
		if (pi < high) {
			quickSort(array, pi, high);
		} // end if
	} // end quickSort
	
	//***********************************************************************

	/*
	 * Finds an element on the left that is larger than on the right, 
	 * and swaps the two elements.
	 */
	private int partition(int[] array, int low, int high) {
		
		// Pointers keeping location in array.
		i = low;
		j = high;

		pivot = array[(low + high) / 2];
		
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			} // end while
			while (array[j] > pivot) {
				j--;
			} // end while
			if (i <= j) {
				tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
				j--;
			} // end if
		} // end while
		return i;
	} // end partition
} // end QuickSort
