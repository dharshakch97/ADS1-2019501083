class SequentialSearchST<Key extends Comparable<Key>, Value> {
    
    int n = 0;
    Node first;
    
    public class Node {
    Key key;
    Value val;
    Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public Value get(Key k) {
        Node n = first;
        while (n != null) {
            if (k.equals(n.key))
                return n.val;
            n = n.next;
        }
        return null;
    }

    public void put(Key k, Value v) {
        Node x = first;
        while (x != null) {
            if (k.equals(x.key)) {
                x.val = v;
                return;
            }
            x = x.next;
        }
        
        first = new Node(k, v, first);
        n++;
    }

    // public String keys() {
    //     String res = "";
    //     for (int i = 0; i < n; i++)
    //         res += keys[i] + " ";
    //     return res;
    // }
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}