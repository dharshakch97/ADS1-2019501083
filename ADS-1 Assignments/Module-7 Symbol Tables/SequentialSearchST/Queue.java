import java.util.*;
/**
 *  @author Dharshak
 */
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first; // first in queue
    private Node<Item> last; // last in queue
    private int n; // queue size

    // helper linked list class
    private static class Node<Item> {
        private Item item; // Node item
        private Node<Item> next; // Node type next item
    }

    /**
     * Initializes Queue using constructor
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;  //if this queue is empty, else return false
    }

    public int size() {
        return n; // return number of items in queue
    }

    public Item peek() {
        return first.item; // returns first item in the queue
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) 
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) 
            last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  
            return current != null;

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}