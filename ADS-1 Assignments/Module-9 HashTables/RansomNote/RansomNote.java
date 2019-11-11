/**
 * @author Dharshak
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    /**
     * RansomNote Class
     * @param magazine magazine string array
     * @param ransom ransom string array
     */
    public static boolean canMake(String[] magazine, String[] ransom){
        // HashMap for magazine string array
        Map<String, Integer> magazineHashMap = new HashMap<String, Integer>();
        // HashMap for ransom string array
        Map<String, Integer> ransomHashMap = new HashMap<String, Integer>();

        for(String w: magazine){
            // if magazine hashmap not contains key of input 'w', put 'w'
            if (!magazineHashMap.containsKey(w))
                magazineHashMap.put(w, 0);
            // else, update 'w' + 1
            magazineHashMap.put(w, magazineHashMap.get(w) + 1);
        }

        for(String w: ransom) {
            // if ransom hashmap not contains key of input 'w', put 'w'
            if (!ransomHashMap.containsKey(w)) 
                ransomHashMap.put(w, 0);
            // else, update 'w' + 1
            ransomHashMap.put(w, ransomHashMap.get(w) + 1);
        }

        // iterate ransomHashMap keySet
        for(String key: ransomHashMap.keySet()) {
            // if magazineHashMap not contains key, return 'False'
            if (!magazineHashMap.containsKey(key)) 
                return false;
            // if magazineHashMap contains key
            int needed = ransomHashMap.get(key);
            // get(key) < needed, return 'False'
            if (magazineHashMap.get(key) < needed) 
                return false;
        }
        // return 'True'
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        String mgzn[] = new String[m]; // magazine string array
        for (int i = 0; i < m; i++) {
            mgzn[i] = scan.next(); //read magazine string
        }
        String ransom[] = new String[n]; //ransom String array
        for(int i = 0; i < n; i++){
            ransom[i] = scan.next(); // read ransom string
        }
        /*call canMake(mgzn, ransom) method
        if the canMake method returns True, print("YES*)
        otherwise, return False
        */
        if (canMake(mgzn, ransom))
            System.out.println("YES"); // print YES
        else
            System.out.println("NO"); // print NO
    }

}