import java.util.*;

public class Deque<Item> implements Iterable<Item> {
    Node first;
    Node last;
    int n;
   
    class Node<Item> {
       Item item;
       Node next;
       Node prev;
    }
   
    Deque() {
       n = 0;
       first = null;
       last = null;
    }
      
    public boolean isEmpty() { 
       return n == 0; 
    }
   
    public int n() { 
        return n; 
    }
   
    public void addFirst(Item item) 
    {
        if (item == null) throw new NullPointerException(); 
        Node oldF = first;
        first = new Node();
        first.item = item;
        first.next = oldF;
        first.prev = null;
        if (isEmpty()) 
            last = first;
        else 
            oldF.prev = first;
        n++;
    }
       
    public void addLast(Item item)
    {
        if (item == null) throw new java.lang.NullPointerException();
        Node oldL = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldL;
        if (isEmpty()) 
            first = last;
        else 
            oldL.next = last;
        n++;
    }
   
    public Item removeFirst()
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;  
        first = first.next;
        n--;
        if (isEmpty()) 
            last = first;
        else 
            first.prev = null;
        return item;
    }
   
    public Item removeLast()
    {
        if (isEmpty()) throw new java.util.NoSuchElementException(); 
        Item item = last.item;
        last = last.prev;
        n--;
        if (isEmpty()) 
            first = last;
        else 
            last.next = null;
        return item;
    }
    
    public Iterator<Item> iterator() { 
       return new DequeIterator(); 
    }
   

//   public static void main(String[] args) { ; }
}
