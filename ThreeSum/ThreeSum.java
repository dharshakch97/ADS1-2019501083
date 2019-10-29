import java.util.Arrays;

class ThreeSum {
    public static void main(String[] args) {
        int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
        // int[] a = {0, -1, 2, -3, 1};

        Arrays.sort(a);
        
        int countOn3 = 0;
        int countOn2 = 0;
        int countOnBinary = 0;

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0)
                        countOn3++;
                }
            }
        }
        System.out.println(countOn3); //O(n^3)

        for (int i = 0; i < a.length - 1; i++) {
            int l = i + 1;
            int h = a.length - 1;

            while (l < h) {

                if (a[i] + a[l] + a[h] == 0) {
                    countOn2++;
                    l++;
                    h--;
                }
                else if (a[i] + a[l] + a[h] < 0)
                    l++;
                else
                    h--;

            }
        }
        System.out.println(countOn2); //O(n^2)

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Arrays.binarySearch(a, j + 1, a.length, -(a[i] + a[j])) > 0)
                    countOnBinary++;
            }
        }
        System.out.println(countOnBinary);
    }
}

