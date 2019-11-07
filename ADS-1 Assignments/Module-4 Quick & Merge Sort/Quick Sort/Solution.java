/**
 * @author Dharshak
 */
import java.util.*;
import java.util.Random;

public class Solution {

	public static int[] quickSort(final int[] arr) {
		sort(arr); // call sort method
		return arr;
	}
	/**
	 * @param a input array
	 */
	public static void sort(final int[] a) {
		sort(a, 0, a.length - 1);
	}
	/**
	 * @param a input array
	 * @param low low value
	 * @param high high value
	 */
	private static void sort(final int [] a, final int low, final int high) {
		if (high <= low) {
			return;
		}
		int j = partition(a, low, high);
		sort(a, low, j-1);
		sort(a, j+1, high);
	}

	/**
	 * @param a input array
	 * @param low low value
	 * @param high high value
	 * 
	 * partitioning the array based on fixed value
	 */
	public static int partition(final int[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		while(true) {
			while(less(a[++i], a[low])) {
				if (i == high) {
					break;
				}
			}
			while(less(a[low], a[--j])) {
				if(j == low) {
					break;
				}
			}
			if(i >= j) {
				break;
			}
            exchange(a, i, j);
		}
        exchange(a, low, j);
        return j;
    }

	/**
	 * @param a b value
	 * @param b a value
	 * 
	 * difference of a and b values
	 */
    public static boolean less(final int a, final int b) {
        int diff = a - b;
        if (diff < 0) {
            return true;
        }
        return false;
    }

	/**
	 * @param a input array
	 * @param i 
	 * @param j
	 * 
	 * swap two values a[i] and a[j]
	 */
    public static void exchange(final int[] a, final int i, final int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
}