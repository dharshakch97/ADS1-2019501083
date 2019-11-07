import java.util.Arrays;
class InsertionSort {
    public static void main(String[] args) {
        
        int[] a = {5, 4, 9, 12, 10, 20, 5, 1};

        for (int i = 1; i < a.length; i++) {
            int f = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > f) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = f;
        }
        System.out.println(Arrays.toString(a));
    }
}