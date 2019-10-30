class Solution{
	public int[] sortInsertion(int[] arr){
		// fill you code Here
		int t;
		for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
                    // System.out.println(min);
            }
            // break;
            t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;

        }
		return arr;
	}
	public int[] sortSelection(int[] arr){
		// fill you code Here
		for (int i = 0; i < arr.length; i++) {
            int f = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > f) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = f;
        }
		return arr;
	}
}