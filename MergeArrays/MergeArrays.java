import java.util.Arrays;
class MergeArrays {
    public static void main(String[] args) {
        
        int i = 0,j = 0,k = 0;

        int[] a = {2,3,7,9,10};
        int[] b = {3,4,7,110,120};
        int[] c = new int[a.length+b.length];

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

        /* while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        Arrays.sort(c); */ // Using Arrays.sort();
        System.out.println(Arrays.toString(c));
    }

}