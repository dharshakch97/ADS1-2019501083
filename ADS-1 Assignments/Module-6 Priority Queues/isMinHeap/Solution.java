/**
 * @author Dharshak
 */
class Solution {
	/**
	 * @param arr input array
	 */
	public static boolean isMinHeap(double[] arr) { // input array
		if (arr.length <= 0) 
			return false; // if array length <= 0
		for (int i = 0; i < arr.length-1; i++) { 
			if ((2*i+1) < arr.length && (2*i+ 2) < arr.length) { // check 2*i+1 and 2*i+2 are within the array length
				if (arr[2*i+1]<arr[i] && arr[2*i+2] <arr[i])
					return false; // return false check arr[2*i+1], arr[2*i+2] lessthan arr[i]
			}
		}
		return true; // else, return true
	}
}