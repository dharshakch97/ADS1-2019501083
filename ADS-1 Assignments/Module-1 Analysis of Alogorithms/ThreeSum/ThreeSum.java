// @author Sai Dharshak
import java.util.Arrays;

class ThreeSum {
    /**
     * @param a integer array
     * Count the number of triplets that equal to sum zero.
     */
    public void threesum(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int l = i + 1;
            int h = a.length - 1;

            while (l < h) {
                // count increments if sum of three values equals zero
                if (a[i] + a[l] + a[h] == 0) { 
                    count++;
                    l++;
                    h--;
                }
                else if (a[i] + a[l] + a[h] < 0)
                    l++;
                else
                    h--;
            }
        }
        System.out.println(count); //O(n^2)
    }
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();

        int[] a = {0,0,1};
        Arrays.sort(a);
        ts.threesum(a);

        int[] b = {0, -1, 2, -3, 1};
        Arrays.sort(b);
        ts.threesum(b);
    }
}

