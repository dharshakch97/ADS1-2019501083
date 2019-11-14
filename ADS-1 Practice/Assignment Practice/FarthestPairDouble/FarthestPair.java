/**
 * @author Dharshak
 */
import java.util.*;
/**
 * This class 'FarthestPair' to find out the pair whose difference is
 * maximum when compared to other pairs in the array.
 * TO FIND OUT THE FARTHEST PAIR, WE FIND THE MAXIMUM AND MINIMUM
 * FROM THE GIVEN INPUT ARRAY AND RETURN THAT PAIR.
 */
class FarthestPair {
    /**
     * 'lesser' method to used to find the minimum element
     *  in the given input array.
     *  @param arr input array
     *  @param n input array size
     *  @param min assume first element in the array as minimum element  
     */
    public static Double lesser(Double[] arr, int n,Double min) {
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) // if arr[i] is min, update 'min' with arr[i] value 
                min = arr[i];
        }
        return min; // return the 'min' element in the array
    }

    /**
     * 'greater' method to used to find the maximum element
     *  in the given input array.
     *  @param arr input array
     *  @param n input array size
     *  @param max assume first element in the array as maximum element  
     */
    public static Double greater(Double[] arr, int n, Double max) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) // if arr[i] is max, update 'max' with arr[i] value
                max = arr[i];
        }
        return max; // return the 'max' element in the array
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // first take input 'n' for array size

        // if (n < 2) {
        //     System.out.println("Input n greater than 1...");
        //     System.out.println("Give another input:");
        //     n = scan.nextInt();
        // }
        while (n <= 1) { // 'n' should be greater than 1
            System.out.println("Input n is less than 1...");
            System.out.println("Give another input that to be '> 1':");
            n = scan.nextInt(); // to prompt another input for size 'n'
        }
            
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextDouble();
    
        Double min = a[0]; // Make first element as minimum element
        Double max = a[0]; // Make first element as maximum element
    
        // Call 'lesser' method to find minimum element in the array
        Double lessElem = lesser(a,n,min);
        // Call 'greater' method to find maximum element in the array
        Double greatElem = greater(a,n,max);
        // Double d = greatElem - lessElem;
        // System.out.println(d);
        System.out.println("Farthest pair is: (" + greatElem + "," + lessElem + ")");
       
    }
}