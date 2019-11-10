/**
 * @author Dharshak
 * class for BSTThreeArrays
 * It has Key, Value and
 * Key extends Comparable<Key>
 */
public class BSTThreeArrays<Key extends Comparable<Key>, Value> {

    Key[] keys; // Key[] type array
    Value[] values; // Value[] type array
    int[] leftIndices; // int[] type array leftIndices
    int[] rightIndices; // int[] type array rightIndices
    int[] sizes; // int[] type array sizes


    /**
     * BSTThreeArrays() Constructor
     * To initialize keys, values, leftIndices, rightIndices, sizes
     */
    public BSTThreeArrays() {
        this.keys = (Key[]) new Comparable[20];
        this.values = (Value[]) new Object[20];
        this.leftIndices = new int[20];
        this.rightIndices = new int[20];
        this.sizes = new int[20];

        for (int i = 0; i < 20; i++) {
            leftIndices[i] = -1;
            rightIndices[i] = -1;
        }

    }

    /**
     * size() takes input keyIndex
     * return size index in the node
     */
    public int size(int keyIndex) {
        if (keyIndex == -1) {
            return 0;
        } else {
            return sizes[keyIndex];
        }
    }

    /**
     * Here, it returns the first index sizes[0] in size[].
     */
    public int size() {
        return sizes[0];
    }



    /**
     * isEmpty() returns boolean value if key is found in keys array
     * else, return false.
     */
    public boolean isEmpty() {
        return keys[0] == null;
    }

    public boolean contains(Key key) { // takes input key of Key type
        for (Key eachKey : keys) { 
            /*compare the input key with each of key in the keys array 
            and equals return true or else return false*/
            if(eachKey.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * get(Key key) returns the Value of required input key
     */
    public Value get(Key key) {
        return get(0, key);
    }

    /**
     * get(keyIndex, keyToCompare) compares the given key with all other
     * keys in the keys array 
     * if it < 0, it goes recursively to leftIndices
     * if it > 0, it goes recursively to rightInices
     * or else, it returns the value at the required keyIndex
     * 
     * @param keyIndex
     * @param ketToCompare 
     */
    public Value get(int keyIndex, Key keyToCompare) {

        if (keyIndex < 0) {
            return null;
        }
        int cmp = keyToCompare.compareTo(keys[keyIndex]);
        if (cmp < 0) {
            return get(leftIndices[keyIndex], keyToCompare);
        } else if (cmp > 0) {
            return get(rightIndices[keyIndex], keyToCompare);
        } else {
            return values[keyIndex];
        }
    }


    /**
     * put(key, val) insert in the ThreeA where it index would be
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        put(0, key, val);
    }


    /**
     * put(keyIndex, keyToCompare) inserts the key-value pair in it's index
     * @param keyIndex
     * @param keyToCompare
     */
    public int put(int keyIndex, Key keyToCompare, Value val) {
        if (keyIndex  == -1 || keys[keyIndex] == null) {
            keyIndex = size();
            keys[keyIndex] = keyToCompare;
            values[keyIndex] = val;
            sizes[keyIndex] = 1;

            return keyIndex;
        }

        int cmp = keyToCompare.compareTo(keys[keyIndex]);
        if(cmp < 0) {
            leftIndices[keyIndex] = put(leftIndices[keyIndex],  keyToCompare, val);      
        } else if (cmp > 0) {
            rightIndices[keyIndex] = put(rightIndices[keyIndex], keyToCompare, val);
        } else {
            values[keyIndex] = val;
        }
        sizes[keyIndex] = size(leftIndices[keyIndex]) + size(rightIndices[keyIndex]) + 1; 

        return keyIndex;
    }


    /**
     * Main method,
     * Here, it creates the object for ThreeArrays
     * and perform operations get() and put()
     */
    public static void main(String[] args) {
        BSTThreeArrays<String, Integer> ThreeA = new BSTThreeArrays<String, Integer>();

        ThreeA.put("H",0);
        ThreeA.put("A",1);
        ThreeA.put("R",2);
        ThreeA.put("S",3);
        ThreeA.put("H",4);
        ThreeA.put("A",5);

        System.out.println(ThreeA.get("P"));
        System.out.println(ThreeA.get("H"));
        System.out.println(ThreeA.get("A"));


    }
}