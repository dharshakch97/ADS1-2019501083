/**
 * @author Dharshak
 */
import java.util.*;
class PQ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Input array length
        System.out.println("Enter an array length(N): ");
        int N = scan.nextInt();

        int[] a = new int[N]; // array declaration of size N
        // input array values
        System.out.println("Enter array values: ");
        for (int i = 0; i < N; i++)
            a[i] = scan.nextInt();

        MinPQ minpq = new MinPQ(N); // object creation for MinPQ

        // input K value that 'K' elements to be in the MinPQ after delete the N - K elements
        System.out.println("Enter K value: "); 
        int K = scan.nextInt();

        // inserting N elements to MAxPQ and MinPQ
        for (int i = 0; i < N; i++) {
            minpq.insert(a[i]);
        }

        // Difference of 'N' and 'K'
        int diff = N - K;
        for (int i = 1; i <= diff; i++) {
            minpq.delMin(); // delete N - K elements from MinPQ
        }
        
        int[] minArray = minpq.returnArray(); // return the remaining elements in minpq array
        String max = "";
        String min = "";
        for (int i = 1; i <= K; i++) {
            // adding minArray elements to 'min' String i.e., K largest elements
            min += minArray[i] + " "; 
        }
        /* Adding N elements to the 'minpq' and after to find 'K' largest elements in minpq.
        In order to do find that, remove (or) delete N - K elements from 'minpq'
        So, the remaining 'K' elements are the largest because the elements satisfy the MinPQ Heap 
        property. */
        System.out.println("K largest elements are: " + min);
    }
}
