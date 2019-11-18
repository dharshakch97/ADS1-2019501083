import java.util.*;
class PQ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an array length(N): ");
        int N = scan.nextInt();

        int[] a = new int[N];
        System.out.println("Enter array values: ");
        for (int i = 0; i < N; i++)
            a[i] = scan.nextInt();

        System.out.println(Arrays.toString(a));

        MaxPQ maxpq = new MaxPQ(N);
        MinPQ minpq = new MinPQ(N);

        System.out.println("Enter K value: ");
        int K = scan.nextInt();

        for (int i = 0; i < N; i++) {
            minpq.insert(a[i]);
            maxpq.insert(a[i]);
        }
        // System.out.println(maxpq.toString());

        // for (int i = 0; i < (n - k); i++)
        //     minpq.delMin();

        // System.out.println(minpq.toString());


        int diff = N - K;

        for (int i = 1; i <= diff; i++) {
        // System.out.println(maxpq.getMax());    
            minpq.delMin();
        }
        System.out.println(minpq.toString());
        System.out.println(maxpq.toString());

    }
}
