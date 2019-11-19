import java.util.*;
class BinarySearchSTMain {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> bsInput = new BinarySearchST<String, Integer>();
        Scanner scan = new Scanner(System.in); // Scanner class object 'scan'
        System.out.println("Enter no. of key-value pairs: ");
        int n = scan.nextInt(); // input no. of key-value pairs to put(insert)
        for (int i = 0; i < n; i++) {
            // input keys and values
            String k = scan.next();
            int v = scan.nextInt();
            // put(insert) in binary search symbolTable
            bsInput.put(k,v);
        }
        // printing Key and it's value as String
        System.out.println("Key-Value pairs: \n" + bsInput.KeyVal());
    }
}