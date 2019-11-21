/**
 * @author Dharshak
 * 
 * Linear Probing class
 * It contains Key-Value pair
 * @param <Key> key
 * @param <Value> value
 */
public class LPProb<Key, Value> {
    Key[] keys;
    Value[] values;
    int m;
    int n;
    int CAPACITY;

    /**
     * Constructor for LinearProbing() 
     * @param capacity
     */
    public LPProb(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        values = (Value[]) new Object[m];
    }

    /**
     * calculate hash for a given key
     * this hash function returns the value index between 0 and M - 1
     * @param key key
     */ 
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m; // calculating hashCode for key
    }

    /**
     * Inserts the given input key-value pair to the symbol table.
     * @param  key key
     * @param  val value
     */
    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = val; // update val if key exists in the keys array
                return;
            }
        }
        // add key and value to keys[i] and values[i]
        keys[i] = key;
        values[i] = val;
        n++;
    }

    public int checkNull() {
        int c = 0;
        for (int i = 0; i < keys.length; i = i + 100) {
            // checking all 100th indexes are null or not, if null increment 'c'
            if (keys[i] != null) {
                // System.out.println(i);
                c += 1;
            }
        }
        return c; // returning count
    }
}    
