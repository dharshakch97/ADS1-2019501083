import java.util.*;
class BSTMain {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>(); // BST object 'bst'
        Scanner scan = new Scanner(System.in); // Scanner class object 'scan'
        System.out.println("Enter number of Key-Value pairs to insert: ");
        int N = scan.nextInt(); // input N i.e., no. of key-value pairs to insert in BST

        for (int i = 0; i < N; i++) {
            System.out.println("Enter Key-Value (with space seperated): ");
            String s = scan.next(); // String input for key
            int n = scan.nextInt(); // Integer input for value
            bst.put(s,n); // put key-value in BST
        }

        System.out.println("Enter Minimum Key: ");
        String min = scan.next(); // minimum key
        System.out.println("Enter Maximum Key: ");
        String max = scan.next(); // maximum key
        /* check for BST is in correct order or not, 
           returns true, if BST is in correct order
           returns false, if BST is not in correct order
        */
        System.out.println(bst.isOrdered(min, max));
        // bst.isOrdered("A","D");
    }
}