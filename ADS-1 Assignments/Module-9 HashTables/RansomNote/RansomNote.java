import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static boolean canMake(String[] magazine, String[] ransom){
        
        Map<String, Integer> magazineHashMap = new HashMap<String, Integer>();
        Map<String, Integer> ransomHashMap = new HashMap<String, Integer>();

        for(String w: magazine){
            if (!magazineHashMap.containsKey(w)) 
                magazineHashMap.put(w, 0);
            magazineHashMap.put(w, magazineHashMap.get(w) + 1);
        }

        for(String w: ransom){
            if (!ransomHashMap.containsKey(w)) 
                ransomHashMap.put(w, 0);
            ransomHashMap.put(w, ransomHashMap.get(w) + 1);
        }

        for(String key: ransomHashMap.keySet()){
            if (!magazineHashMap.containsKey(key)) 
                return false;
            int needed = ransomHashMap.get(key);
            if (magazineHashMap.get(key) < needed) 
                return false;
        }
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