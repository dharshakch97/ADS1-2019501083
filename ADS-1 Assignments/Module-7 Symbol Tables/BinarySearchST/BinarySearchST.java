/**
 * @author Dharshak
 */
import java.util.*;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    Key[] keys; // Key[] type array
    Value[] values; // Value[] type array
    int n = 0; 
    int capacity = 1;

    BinarySearchST() { // constructor for BinarySearchST()
        keys = (Key[]) new Comparable[1]; 
        values = (Value[]) new Object[1];
        n = 0;
    }

    public int size() {
        return n; // return size 'n'
    }

    /**
     * @param capacity capacity of array to be increased of both 'keys' and 'values'
     */
    public void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        // copy all 'keys' and 'values' present in array to 'tempk', 'tempv'
        for (int i = 0; i < n; i++) { 
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        // assign resized arrays back to 'keys' and 'values'
        values = tempv;
        keys = tempk;
    }

    public boolean isEmpty() {
        return size() == 0; // return true, if size() is 0 else, return false
    }

    public boolean contains(Key key) {
        return get(key) != null; // return true, if key contains in the Key[] array
    }

    /**
     * @param key input key of 'Key' type
     */
    public Value get(Key key) {
        if(isEmpty())
            return null; // return null if isEmpty()
        int i = rank(key); // find rank of 'key'
        // return value if we find key in Key[] array, or else return null
        if (i < n && keys[i].compareTo(key) == 0)  
            return values[i];
        return null;
    }

    /**
     * @param key input key
     * @param value input value
     */
    public void put(Key key, Value value) {
        // if value is null, delete the key
        if (value == null) {
            delete(key); // delete(key)
            return;
        }
        int i = rank(key); // find 'rank' of key
        // assign value to values[i] if we find key in array
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        // if size equals keys length, resize the array (double the array)
        if (n == keys.length)
            resize(keys.length * 2); // resize the keys[] array
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1]; // shift keys[j - 1] to keys[j] until j > i
            values[j] = values[j - 1]; // shift values[j - 1] to values[j] until j > i
        }
        // when loop terminates, assign 'key' and 'value' to keys[i] and values[i]
        keys[i] = key;
        values[i] = value;
        n++; // increment 'n'
    }

    /**
     * @param key input key
     * In 'rank' method, we find the index where the key is found at index
     * If 'key' not found, return the index where to put in the array
     */
    public int rank(Key key) {
        int low = 0, high = n - 1; // assign low = 0, high = n - 1
        while (low <= high) {
            int mid = low + (high - low) / 2; // find mid
            int toCompare = key.compareTo(keys[mid]); // compare 'key' with keys[mid]
            if (toCompare < 0) 
                high = mid - 1; // if toCompare < 0
            else if (toCompare > 0)
                low = mid + 1; // if toCompare > 0
            else 
                return mid; // else, return mid
        }
        return low; // else, return low
    }

    /**
     * @param key input key
     * find the index of the 'key' value and 
     * shift keys[j + 1] to keys[j] (shift left wards)
     * So, the key at particular index is removed
     * And also, decrement 'n' and keys[n] = null, values[n] = null
     */
    public void delete(Key key) {
        int i = rank(key); // find 'rank' for key

        for (int j = i; j < n - 1; j++) {
            // shift all the elements from i to n - 1 leftwards
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n--; // decrement 'n'
        // make last index values 'null'
        keys[n] = null; 
        values[n] = null;
    }

    public void deleteMin() {
        delete(min()); // delete min element
    }

    public void deleteMax() {
        delete(max()); // delete max element
    }

    public Key max() {
        return keys[n - 1]; // get max element
    }

    public Key min() {
        return keys[0]; // get min element
    }

    /**
     * @param key input key
     * Find 'rank' for given key
     * and compare given keys
     * If 'key' found, return that 'key'
     * or else, return the near smallest 'key' from array 
     */ 
    public Key floor(Key key) {
        int i = rank(key); // find 'rank' for key
        if (i == 0) 
            return null; //return null if i == 0

        // if key is found, return the key value or else, return nearest small key value
        else if (i < n && key.compareTo(keys[i]) == 0) 
            return keys[i];
        else 
            return keys[i-1];
    }

    /**
     * Add keys from key array to String 'res'
     * and return 'res'
     */
    public String keys() {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += keys[i] + " ";
        }
        return res;
    }
}