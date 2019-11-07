import java.util.Arrays;
class SelectionSort {
    public static void main(String[] args) {
        
        int[] a = {5, 4, 2, 10, 7, 9, 1};
        int t;
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
                    // System.out.println(min);
            }
            // break;
            t = a[min];
            a[min] = a[i];
            a[i] = t;

        }
        System.out.println(Arrays.toString(a));
    }
}