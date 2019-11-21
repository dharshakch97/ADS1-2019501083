import java.util.*;
class LPMain {
    /**
    * Main class for LPProb
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner class object 'scan'
        int N = scan.nextInt(); // input size N of keys and values size
        LPProb<Integer, Integer> lpHT = new LPProb<Integer, Integer>(N); // object creation for LinearProboingHT
        Random r = new Random(); // Random class
        for (int i = 0; i < N/2; i++) {
            int k = r.nextInt(6734); // reading random integer from 0 to 6784
            int v = r.nextInt(12903); // reading random integer from 0 to 12903
            lpHT.put(k,v); // put key-value into linear probing HashTable
        }
        
        int c = lpHT.checkNull(); // calling checknull() 
        System.out.println(c); // displaying no. of 100th indexes are occupied
        Double prob = ((double)c/N); // calculating probability of count 'c' to the total size (10,00,000).
        System.out.println(prob); // displaying probability
    }
}