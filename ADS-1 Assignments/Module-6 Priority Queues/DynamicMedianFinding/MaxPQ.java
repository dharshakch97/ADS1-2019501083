/**
 * @author Dharshak
 */
import java.util.*;
class MaxPQ<Key> {

	Key[] pqArray; // create Key[] array
	int size;
	Comparator<Key> comparator; // comparator for Key

	public MaxPQ(int s) {
		pqArray = (Key[]) new Object[s + 1]; // constructor for MaxPQ, declaring array size
		size = 0;
	}
		
	public int size() {
		return size; // return size of pqArray
	}
	
	public void insert(Key k) { // insert a new value to the pqArray[]
		if (size == pqArray.length - 1) { 
			resize(2 * pqArray.length); // resizing the array, if elements size equals array length
		}
		pqArray[++size] = k; // inserting new element to the array
		swim(size); // swim the pqArray
	}
	/**
	 * @param chld input parameter of child index
	 * swim'ming is done from bottom to top
	 * exchange parent with child when parent is less than child.
	 */
	public void	swim(int chld) {  
		while (chld > 1 && min(chld / 2, chld)) { //chld is child and chld/2 is parent.
			swap(chld, chld / 2); // exchg child and parent, when parent is smaller
			chld = chld / 2; // now, making child's parent as child now
		}
	}
	
	public boolean min(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) pqArray[i]).compareTo(pqArray[j]) < 0;
		} else {
			return comparator.compare(pqArray[i], pqArray[j]) < 0;
		}
	}
	
	public Key getMax() {
		return pqArray[1]; // return max element
	}
	/**
	 * delete the max element from the MaxPQ, 
	 * swap the max element with the last element in the pqArray
	 * and sink from top to bottom
	 */
	public Key delMax() { 
		Key max = pqArray[1];
		swap(1, size--);
		sink(1);
		pqArray[size + 1] = null; // after sinking, make last element as null
		if ((size > 0) && (size == (pqArray.length - 1) / 4)) {
			resize(pqArray.length / 2); // resize, if pqArray length is 1/4th occupied
		}
		return max; //return the max deleted element 
	}

	/**
	 * sink function from the top to bottom
	 * exchnge parent with it's child,
	 * until all it's parent values are 'max' than their childs' 
	 * @param a input index i.e., top parent index
	 */
	public void sink(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && min(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
		}
	}

	/**
	 * @param nsize input size of pqArray
	 */
	public void resize(int nsize) {
		Key[] temp = (Key[]) new Object[nsize]; //create temp[], double the pqArray[] length in temp[]
		for (int i = 1; i <= size; i++) {
			temp[i] = pqArray[i]; // and, copy all elements to that array
		}
		pqArray = temp; //Finally, assign temp[] to pqArray[]
	}

	/**
	 * @param i i index
	 * @param j j index
	 * swap two i and j index values of the pqArray
	 */
	public void swap(int i, int j) {
		Key temp = pqArray[i];
		pqArray[i] = pqArray[j];
		pqArray[j] = temp;
	}
}