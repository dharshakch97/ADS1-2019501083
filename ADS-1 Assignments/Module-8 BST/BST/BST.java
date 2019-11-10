/**
 * @author Dharshak
 * 
 * Binary Search Tree(BST) class
 * This BST ST contains key-value pairs
 * 
 * @param <Key> key 
 * @param <Value> value
 */
class BST<Key extends Comparable <Key>,Value> // Key extends Comparable<Key>
{
    private Node root;     

    /**
     * Node class
     */
    private class Node {
        private Key key;          
        private Value val;         
        private Node left, right;  
        private int size;
        /**
         * Node constructor which initializes key, value, and size
         * @param key key
         * @param val value
         * @param size size
         */
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    /**
     * isEmpty() returns boolean value true if BST ST is empty
     * It's complexity is O(1)
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * size() method returns the size of BST STi.e., no of elements in binary search tree.
     * It's Complexity is O(1).
     */
    public int size() {
        return size(root);
    }

    /**
     * In this size(), we pass root as parameter.
     * @param x node.
     * @return total size of BST ST .
     * size(Node x) Complexity is O(1).
     */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * contains() returns boolean value, if we find required key in the BST ST
     * @param  key key
     * contains(Key key) Complexity is O(n).
    */
    public boolean contains(Key key) {   
        return get(key) != null;
    }

    /**
     * get() method used to get the value for the key what we required
     * @param  key key
     * get(Key, key) Complexity is O(n).
     */
    public Value get(Key key) {
        return get(root, key);
    }
    /**
     * get(Node x, Key key) is used to find the value for the required key.
     * @param x node
     * @param key key
     * get(Node x, Key key) Complexity is O(n).
     */

    public  Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * put() is used to add a key-value to the BST ST, if key not exists
     * otherwise, if key found it updates the value of that particular key
     * @param key key.
     * @param val value.
     * put() complexity is O(n).
     */

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }
    /**
     * this is put method in which it takes Node, Key, value
     * if Node is null, return new Node of key, value else, it compares with key using compareTo
     * if compareTo < 0, put in x.left
     * if compareTo > 0, put in x.right
     * else update the value to that key 
     * @param x node.
     * @param key key.
     * @param val value.
     * put(Node x, Key key, Value value) Complexity is O(n).
     */

    private  Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    /**
     * delMin() removes the minimum key and it's value from the BST ST
     * deleteMin() complexity is O(n).
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * delMin(Node x) checks for node to delete if found, delete the key and it's value from BST ST
     * @param x node.
     * deleteMin() complexity is O(n).
     */

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * delMin() removes the minimum key and it's value from the BST ST
     * deleteMax() complexity is O(n).
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * delMin(Node x) checks for node to delete if found, delete the key and it's value from BST ST
     * @param x node.
     * deleteMax() complexity is O(n).
     */

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * delete(Key key) removes the required key and its value from the BST ST
     * @param  key the key
     * delete(Key key) complexity is O(n).
     */
    public void delete(Key key) {
        root = delete(root, key);
    }
    /**
     * delete(Node x, Key key) removes the Node x of required key and it's value from the BST ST
     * @param x node.
     * @param key key.
     * delete() complexity is O(n).
     */

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * min() returns min key from the BST ST
     * min() complexity is O(n).
     */
    public Key min() {
        return min(root).key;
    }
    
    /**
     * min() returns min key from the BST ST
     * @return the minimum key from the BST symbol table. 
     * @param x node.
     * Complexity:O(n).
     */
    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    /**
     * max() returns max key from the BST ST
     * max() complexity is O(n).
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * max() returns max key from the BST ST 
     * @param x node.
     * Complexity:O(n).
     */

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /**
     * floor(Key key) rturns the key from the BST ST below to the given key
     * @param  key key
     * floor(Key key) complexity is O(n).
     */
    public Key floor(Key key) {        
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * floor(Nodex, Key k) return the key from the BST ST below to the given key
     * @param x node
     * @param key key
     * floor(Node x, Key k) complexity is O(n).
     */

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * ceiling(Key key) return the key from the BST ST above to the given key
    * @param  key key
    * ceiling(Key key) complexity is O(n).
    */
    public Key ceiling(Key key) {        
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }
    /**
     * ceiling(Node x, Key key) return the key from the BST ST above to the given key
     * @param x node
     * @param key key
     * ceiling(Node x, Key key) complexity is O(n). 
     */

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * select(int k) returns the (k + 1)th minimum key from the symbol table
     * @param  k input key
     * select() complexity is O(n).
     */
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * select(int k) returns the (k + 1)th minimum key from the symbol table
     * @param x node
     * @param key k
     * select(Node x, int k) omplexity is O(n).
     */
   
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }
}
