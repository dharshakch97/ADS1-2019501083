import java.lang.Comparable;
import java.util.*;

/**
 * @author Dharshak
 * 
 * @param Key key extends Comparable<Key>
 * @param Value
 */
class SequentialSearchST<Key extends Comparable<Key>, Value> {
    Node first; // first Node

    /**
     * Create Node class 
     * with Key, Value, and Node
     * @param key Key type
     * @param value Value type
     * @param next Node type
     */
    class Node {
        Node next;
        Key key;
        Value value;

        Node(Key key, Value value) { // Node class constructor
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " " + value; // toString for Node class to return key + " " + value
        }
    }

    /**
     * @param key input key
     * @param value input value
     * input the key and value to the keys and values
     * Add to the SequentialSearchST. 
     */
    public void put(Key key, Value value) {
        Node node = new Node(key, value);
        if (first == null) {
            first = node; // if first is null
            return;
        } 
        Node n = first; // first in temp (n)
        // traverse until n != null
        while (n != null) {
            // compare n.key with input key equals 0
            if (n.key.compareTo(key) == 0) {
                n.value = value;
                return;
            }
            n = n.next;
        }
        Node old = first; // make first in old
        first = new Node(key, value); // create new node and assign to first
        first.next = old; // assign old to first.next
    }

    /**
     * @param n input Node n
     */
    private  Value exchange(Node n) {
        Node temp = n.next;
        Value value = temp.value;
        n.next = n.next.next;
        Node node = first;
        while (node.next != null) {
            node = node.next;
        }
        node.next = temp;
        temp.next = null;
        return value;
    }

    /**
     * @param key input key
     * compare input key with keys in linked list
     * If key found return key
     * Or else, return null
     */
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        if(first.key.compareTo(key) == 0) {
            return exchange(first);
        }
        Node n = first;
        while(n != null) {
            if (n.next.key.compareTo(key) == 0) {
                return exchange(n);
            }
            n = n.next;
        }
        return null;
    }

    /**
     * Key Iterable<Key> uses Queue<Key> class
     * enqueue all the keys to the queues and
     * return queue.
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        Node n = first;
        while(n != null) {
            queue.enqueue(n.key);
            n = n.next;
        }
        return queue;
    }
}