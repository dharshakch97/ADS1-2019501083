/**
 * @author Dharshak
 */
class Solution {
    public static double[] dynamicMedian(double[] arr) {
        int n = arr.length; // array length as n
        double[] median = new double[n]; // create median of double-type array
        double med = 0.0;
        int size = 0;

        MinPQ<Double> minpq = new MinPQ<Double>(n); // object creation for MinPQ<Double>
        MaxPQ<Double> maxpq = new MaxPQ<Double>(n); // object creation for MaxPQ<Double>

        for (int i = 0; i < n; i++) {
            if (arr[i] > med)
                minpq.insert(arr[i]); // insert element into minpq
            else
                maxpq.insert(arr[i]); // insert element into maxpq
        
            // if difference > 1, delete from minpq and insert into maxpq
            if ((minpq.size() - maxpq.size()) > 1) { 
                maxpq.insert(minpq.delMin());
                // double in1 = minpq.delMin();
                // maxpq.insert(in1);
            }

            // if difference > 1, delete from maxpq and insert into minpq
            if ((maxpq.size() - minpq.size()) > 1) {
                minpq.insert(maxpq.delMax());
                // double in2 = maxpq.delMax();
                // minpq.insert(in2);
            }

            // if both equals, delete from minpq and insert into maxpq
            if (maxpq.size() == minpq.size()) {
                med = (maxpq.getMax() + minpq.getMin()) / 2;
                // System.out.println(med);
                median[size++] = med;
            }

            // if maxpq size > minpq size, add max from maxpq to median array
            if (maxpq.size() > minpq.size()) {
                med = maxpq.getMax();
                // System.out.println(med);
                median[size++] = med;
            }

            // if minpq size > maxpq size, add min from minpq to median array
            if (minpq.size() > maxpq.size()) {
                med = minpq.getMin();
                // System.out.println(med);
                median[size++] = med;
            }
        }
        return median;
    }
}