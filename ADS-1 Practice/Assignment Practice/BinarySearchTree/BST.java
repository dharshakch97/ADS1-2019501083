/**
 * @author Dharshak
 * 
 * Binary Search Tree(BST) class
 * This BST ST contains key-value pairs
 * which supports Binary Search Tree property.
 * The BST contains that, all the Nodes to the left are less than to the rootNode
 * and the Nodes to the right are greater than to the rootNode. 
 * 
 * @param <Key> key 
 * @param <Value> value
 */
class BST<Key extends Comparable <Key>,Value> // Key extends Comparable<Key> 
{
    Node root; // root node

    class Node {
        Key k; // Key type 'k'
        Value v; //Value type 'v'
        Node left, right; // left and right nodes
        int n; // size of BST

        /**
         * Node constructor for assigning key, value, and size
         * @param key key in node
         * @param value value in node
         * @param sz size of tree
         */
        Node(Key key, Value value, int sz) {
            this.k = key;
            this.v = value;
            this.n = sz;
        }
    }

    public int size() {
        return size(root); // returns size of the tree i.e., size(root)
    }

    public int size(Node n) {
        /* if n is null, return 0 i.e., no tree exist;
           else, return the size of the tree*/
        if (n == null)
            return 0;
        return n.n;
    }

    /**
     * Put method takes parameter of Key k and Value v
     * and insert(put) into root of the tree or sub-tree.
     * @param k key 
     * @param v value
     */
    public void put(Key k, Value v) {
        root = put(root, k, v); // put the key-value in the 'root'
    }

    /**
     * This put method takes parameters of Key k, Value v, and Node n
     * and insert(put) into Node n and returns to the root of it's tree or sub-tree
     * and inserts there.
     * @param n Node n
     * @param k Key k
     * @param v Value v
     */
    public Node put(Node n, Key k, Value v) {
        if (n == null) // when n is null, create a new node and returns the node
            return new Node(k, v, 1);
        // compare the input key 'k' with the node 'n' key, 
        // if it is less than 0, put the node in the left side of the tree
        if (k.compareTo(n.k) < 0)
            n.left = put(n.left, k, v);
        // if it is greater than 0, put the node in the right side of the tree
        else if (k.compareTo(n.k) > 0)
            n.right = put(n.right, k, v);
        // increment 1 to the sum of size of left sub-tree and size of right sub-tree
        n.n = 1 + size(n.left) + size(n.right);
        return n; // return the inserted node
    }

    /**
     * returns minimum key of the BST 
     */
    public Key min() {
        return min(root).k;
    }
    /**
     * This min method takes parameter Node n
     * and returns the minimum Node key of the BST
     * @param n Node n
     */
    public Node min(Node n) {
        // if Node n left is null, return key of 'n'
        if (n.left == null)
            return n;
        //else, return min(n.left) i.e., recursion
        else
            return min(n.left);
    }

    /**
     * returns maximum key of the BST
     */
    public Key max() {
        return max(root).k;
    }
    /**
     * This max method takes parameter Node n
     * and returns the maximum Node key of the BST
     * @param n Node n
     */
    public Node max(Node n) {
        // if Node n right is null, return key of 'n'
        if (n.right == null)
            return n;
        // else, return max(n.right) i.e., recursion
        else
            return max(n.right);
    }

    /**
     * isOrdered() method takes parameters min and max and
     * returns true, if all the keys of the BST tree are between the min and max
     * returns false, if all the keys of the BST tree are not between the min and max
     * @param min Key type 'min'
     * @param max Key type 'max'
     */
    public boolean isOrdered(Key min, Key max) {
        // if ((min.compareTo(min()) <= 0) && (max.compareTo(max()) >= 0))
        //     return true;
        // return false;
        return isOrdered(root, min, max);
    }

    public boolean isOrdered(Node n, Key min, Key max) {
        if (n == null)
            return true; // if n is null, return true
        if (min.compareTo(n.k) >= 0)
            return false; // if min is greater than Node n.k, return false
        if (max.compareTo(n.k) <= 0)
            return false; // if max is greater than Node n.k, return false
        // return true, only if both these conditions returns true
        return isOrdered(n.left, min, max) && isOrdered(n.right, min, max);
    }
}