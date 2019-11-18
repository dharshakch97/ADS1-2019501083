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

        // System.out.println(Arrays.toString(a));

        MaxPQ maxpq = new MaxPQ(N); // object creation for MaxPQ
        MinPQ minpq = new MinPQ(N); // object creation for MinPQ

        // input K value that 'K' elements to be in the MinPQ after delete the N - K elements
        System.out.println("Enter K value: "); 
        int K = scan.nextInt();

        // inserting N elements to MAxPQ and MinPQ
        for (int i = 0; i < N; i++) {
            minpq.insert(a[i]);
            maxpq.insert(a[i]);
        }
        // System.out.println(maxpq.toString());

        // for (int i = 0; i < (n - k); i++)
        //     minpq.delMin();

        // System.out.println(minpq.toString());


        // Difference of 'N' and 'K'
        int diff = N - K;

        for (int i = 1; i <= diff; i++) {
        // System.out.println(maxpq.getMax());
            minpq.delMin(); // delete N - K elements from MinPQ
        }
        // System.out.println(minpq.toString());
        // System.out.println(maxpq.toString());

        int[] MinArray = maxpq.returnArray(); // return MinPQ array
        int[] MaxArray = maxpq.returnArray(); // return MaxPQ array

        String max = "";
        String min = "";
        for (int i = 0; i < K; i++) {
            max += MinArray[i] + " ";
            min += MaxArray[i] + " ";
        }
        System.out.println(max + " " + min); 
    }
}
