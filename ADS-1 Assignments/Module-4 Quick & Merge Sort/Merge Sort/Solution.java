/**
 * @author Dharshak
 */
class Solution {
	public static String[] mergeSort(String[] arr) {
		
		// Create aux[] string array of arr length
		String[] aux = new String[arr.length];
		// call sort method
		sort(arr, aux, 0, arr.length - 1);
		return arr;
	}
	/**
	 * merge two subarrays
	 * @param a input array
	 * @param aux copy array
	 * @param lo low value
	 * @param mid mid value
	 * @param hi high value
	 */
	private static void merge(String[] a, String[] aux, int lo, int mid, int hi) {
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if ((aux[j].compareTo(aux[i]) < 0)) // compare aux[j] and aux[i]
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	/**
	 * Implement sort method for the subarray
	 * @param a array
	 * @param aux copy array
	 * @param lo low value
	 * @param hi high value
	 */
	public static void sort(String[] a, String[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}		
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid); // subarray first half
		sort(a, aux, mid+1, hi); // subarray second half
		merge(a, aux, lo, mid, hi); // merge two subarrays
	}

}