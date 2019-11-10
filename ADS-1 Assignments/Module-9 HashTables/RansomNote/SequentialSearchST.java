/**
 * @author Dharshak
 */
public class SequentialSearchST<Key, Value> {
    private int n; // number of key-value pairs
    private Node first; // the linked list of key-value pairs

    /**
     * Node class
     */
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        // constructor for Node class
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }


    /**
     * Returns the number of key-value pairs in this symbol table. 
     */
    public int size() {
        return n;
    }

    /**
     * Is this symbol table empty?
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * contains(Key key) checks if the key is in symbol table or not.
     * @param key the key
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table. If the value is
     * {@code null}, this effectively deletes the key from the symbol table.
     * 
     * @param key the key
     * @param val the value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * Removes the key and associated value from the symbol table (if the key is in
     * the symbol table).
     * 
     * @param key the key
     */
    public void delete(Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}. To iterate over
     * all of the keys in the symbol table named {@code st}, use the foreach
     * notation: {@code for (Key key : st.keys())}.
     * 
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}