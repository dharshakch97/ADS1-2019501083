class Solution{
    /**
     * @param arr input integer array
     * Sort the integer array using insertion sort method
     */
	public int[] sortInsertion(int[] arr) {
        // fill you code Here
        for (int i = 0; i < arr.length; i++) {
            int f = arr[i]; // storing arr[i] in f
            int j = i - 1; // j is before i
            /* Sort the 'i' value to all of it's left side values 
            until j >= 0 and arr[j] > f */
            while (j >= 0 && arr[j] > f) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = f;
        }
		return arr; // return the sorted array
    }
    /**
     * @param arr input integer array
     * Sort the integer array using selection sort method
     */
	public int[] sortSelection(int[] arr) {
		// fill you code Here
        int t;
		for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j; // minimum value is storing in min
                    // System.out.println(min);
            }
            // swap the min value to it's 'i' index position
            t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;

        }
        return arr; // return the sorted array
	}
}