/**
 * @author Dharshak
 */
import java.util.Scanner;
/**
 * Linear Probing class
 * It contains Key-Value pair
 * @param <Key> key
 * @param <Value> value
 */
public class LinearProbingHT<Key, Value> {
    Key[] keys;
    Value[] values;
    int m;
    int n;
    int CAPACITY = 4;

    /**
     * Constructor for LinearProbing() 
     */
    // public LinearProbingHT() {
    //     this(CAPACITY);
    // }

    /**
     * Constructor for LinearProbing() 
     * @param capacity
     */
    public LinearProbingHT(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }

    /**
     * size() returns the size of the ST
     */
    public int size() {
        return n;
    }

    /**
     * isEmpty() returns boolean value whether the ST is empty or not
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains(Key key) returns boolean value True, if we find the required key in the ST
     * @param  key key
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * calculate hash for a given key
     * this hash function returns the value index between 0 and M - 1
     * @param key key
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * resizing all the hash table to the required capacity by re-hashing all the keys
     * @param capacity capacity
     */
    private void resize(int capacity) {
        LinearProbingHT<Key, Value> temp = new LinearProbingHT<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m = temp.m;
    }

    /**
     * Inserts the given input key-value pair to the symbol table.
     * @param  key key
     * @param  val value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m/2) resize(2*m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        n++;
    }

    /**
     * get(Key key) returns the value for the given key.
     * If key not found in the ST, return null
     * @param key key
     */
    public Value get(Key key) {       
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    /**
     * Removes the given input key and its value from the ST
     * @param  key key
     */
    public void delete(Key key) {        
        if (!contains(key)) return;        
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }        
        keys[i] = null;
        values[i] = null;       
        i = (i + 1) % m;
        while (keys[i] != null) {           
            Key   keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;        
        if (n > 0 && n <= m/8) resize(m/2);        
    }
    /**
     * Main class for LinearProbingHT
     */
    public static void main(String[] args) {
        LinearProbingHT<String, Integer> lpHT = new LinearProbingHT<String, Integer>(10); // object creation for LinearProboingHT
        lpHT.put("harsha", 7);
        lpHT.put("dh", 2);
        lpHT.put("akhil", 10);
        lpHT.put("rakesh", 5);
        lpHT.delete("shadow");
        lpHT.delete("akhil");
        System.out.println(lpHT.get("harsha"));
        System.out.println(lpHT.get("dh"));
        System.out.println(lpHT.get("akhil"));

    }
}    
