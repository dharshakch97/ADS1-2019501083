/**
 * @author Dharshak
 */
import java.util.Scanner;
/**
 * class for HashTable
 */
class HashTable {

    SeparateChainingHashST<String, Integer> hashTable; // creating hashTable using seperate chaining

    /**
     * Constructor for HashTable()
     */
    HashTable() {
        this.hashTable = new SeparateChainingHashST<String, Integer>();
    }

    /**
     * add(String word) checks if the given word is in hashTable or not 
     * if word is found, get the frequency of that word and update the frequency
     * or else, add word to the hashTable
     */
    public void add(String w) {
        if (hashTable.contains(w)) { // if true
            Integer old = hashTable.get(w);
            hashTable.put(w, old + 1);
        } else {
            hashTable.put(w, 1);
        }
    }

    /**
     * CheckAndUpdate(String w) checks the word and updates it's frequency
     * if word is found, get the frequency of that word and decrements it's frequency
     * if word fequency equals zero, delete the word.
     */
    public boolean CheckAndUpdate(String w) {
        if (hashTable.contains(w)) {
            Integer old = hashTable.get(w);
            hashTable.put(w, old - 1);
            if (hashTable.get(w) == 0) {
                hashTable.delete(w);
            }
            return true;
        }
        else {
            return false;
        }
    }
}

class RansomNote {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // SCaanner class to take input from the user
        HashTable hashTable = new HashTable(); // Hashtable object is created to use methods in Hashtable.
        String[] magazine = scan.nextLine().split(" "); // split the input by space
        for (String eachWord : magazine) {
            hashTable.add(eachWord); // add each word to magazine

        }

        String[] noteWords = scan.nextLine().split(" "); // take another input from user
        boolean can = true;
        for (String eachWord : noteWords) { // iterate each word
            if (hashTable.CheckAndUpdate(eachWord)) {// check each word, if it is present in the hashtable
                                                     // if present decrement the frequency by 1.
            } else { // if word not present
                can = false; // set canMake to false
                break;
            }

        }
        if (can) {// if true
            System.out.println("YES"); // print "YES"
        } else {// else
            System.out.println("NO");// print "NO"
        }

    }
}