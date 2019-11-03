/**
 * Stack LinkedList.
 * @author Dharshak
 */
class LinkedList {
    /**
     * Node Firstelement
     */
    Node first = null;
    /**
     * Class for node.
     */
    class Node {
        /**
         * int item
         */
        String data;
        /**
         * next
         */
        Node next;
    }

    /**
     * top() returns the first element
     * @return     return first item
     */
    public char top() {
        return first.data;
    }

    /**
     * checks stack if empty
     *
     * @return     True if empty, else False
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push an item into stack
     * @param      item  item
     */
    public void push(final String d) {
        Node oldfirst = first;
        first = new Node();
        first.data = d;
        first.next = oldfirst;
    }
    /**
     * pop an element from the stack
     *
     * @return   return the poppped item from the stack
     */
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}