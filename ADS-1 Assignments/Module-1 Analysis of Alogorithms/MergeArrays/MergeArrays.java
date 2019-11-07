/** 
 * @author Dharshak 
 * 
 * */ 
import java.util.Arrays;
class MergeArrays {
    /**
     * @param a integer sorted array
     * @param b integer sorted array
     * Merges two sorted arrays into another array
     */
    public int[] merge(int[] a, int[] b) {
        int i = 0, j = 0,  k = 0;
         // create c integer array of length a.length + b.length
        int[] c = new int[a.length+b.length];
            // Merging the two arrays a and b
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    c[k++] = a[i++];
                }
                else {
                    c[k++] = b[j++];
                }
            }
            while (i < a.length)
                c[k++] = a[i++];
            while (j < b.length)
                c[k++] = b[j++];
        return c; // return c integer array
    }
    public static void main(String[] args) {

        int[] a = {2,3,7,9,10};
        int[] b = {3,4,7};

        MergeArrays ma = new MergeArrays(); // Creating object 'ma' for MergeArrays class
        int[] sorted = ma.merge(a, b); // calling merge(a, b) method
        System.out.println(Arrays.toString(sorted)); // print the sorted array
        
    }

}