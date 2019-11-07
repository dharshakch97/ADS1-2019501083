/**
 * @author Dharshak
 */
class Solution {
    public static double[] dynamicMedian(double[] arr) {
        int n = arr.length;
        double[] median = new double[n];
        double med = 0.0;
        int size = 0;

        MinPQ<Double> minpq = new MinPQ<Double>(n);
        MaxPQ<Double> maxpq = new MaxPQ<Double>(n);

        for (int i = 0; i < n; i++) {
            // double in = arr[i];

            if (arr[i] > med)
                minpq.insert(arr[i]);
            else
                maxpq.insert(arr[i]);
                
            if ((minpq.size() - maxpq.size()) > 1) {
                maxpq.insert(minpq.delMin());
                // double in1 = minpq.delMin();
                // maxpq.insert(in1);
            }

            if ((maxpq.size() - minpq.size()) > 1) {
                minpq.insert(maxpq.delMax());
                // double in2 = maxpq.delMax();
                // minpq.insert(in2);
            }

            if (maxpq.size() == minpq.size()) {
                med = (maxpq.getMax() + minpq.getMin()) / 2;
                // System.out.println(med);
                median[size++] = med;
            }

            if (maxpq.size() > minpq.size()) {
                med = maxpq.getMax();
                // System.out.println(med);
                median[size++] = med;
            }

            if (minpq.size() > maxpq.size()) {
                med = minpq.getMin();
                // System.out.println(med);
                median[size++] = med;
            }
        }
        return median;
    }
}