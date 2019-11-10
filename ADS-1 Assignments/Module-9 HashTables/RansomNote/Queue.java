/**
 * @author Dharshak
 */
import java.util.*;
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first; // first in queue
    private Node<Item> last; // last in queue
    private int n; // size of the queue

    /**
     * Node class for 'Item' type
     * @param item
     * @param next
     * Node class takes two params item of Item type and next of Node type
     */
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Constructor class for queue
     */
    public Queue() {
        // first and last are null for an empty queue and size is 0.
        first = null;
        last = null;
        n = 0;
    }

    /**
     * isEmpty() returns boolean value if first element in queue is null.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * size() returns the number of items in the queue.
     */
    public int size() {
        return n;
    }

    /**
     * peek() in queue returns the first item from the queue.
     */
    public Item peek() {
        return first.item;
    }

    /**
     * enqueueing an item to the queue (i.e., add an item to the list)
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
        n++; // increment the size of the queue
    }

    /**
     * dequeueing an item from the queue which was first added to the queue
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        return item; // return the dequeued item
    }

    /**
     * Return all items in the queue in string representation
     * and return the string by using toString()
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
     */
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}