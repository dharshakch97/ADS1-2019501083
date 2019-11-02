class Solution{
	public static int[] quickSort(int[] arr){
		// fill you code Here
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	public static void sort(int a[], int l, int h) {
		if (l < h) 
        { 
            int p = partition(a, l, h); 
            sort(a, l, p - 1); 
            sort(a, p + 1, h); 
        } 
    }
    

	
	public static int partition(int a[], int low, int high) 
    { 
        int pivot = a[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        {  
            if (a[j] < pivot) 
            { 
                i++; 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
		} 
		
        int temp = a[i+1]; 
        a[i+1] = a[high]; 
        a[high] = temp; 
        return i + 1; 
    }  
}