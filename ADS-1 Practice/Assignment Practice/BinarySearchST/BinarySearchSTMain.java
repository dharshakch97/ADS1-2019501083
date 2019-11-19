import java.util.*;
class BinarySearchSTMain {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> bsInput = new BinarySearchST<String, Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no. of key-value pairs: ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter key: ");
            String k = scan.next();
            System.out.println("Enter value: ");
            int v = scan.nextInt();
            bsInput.put(k,v);
        }
        System.out.println(bsInput.keys());
    }
}