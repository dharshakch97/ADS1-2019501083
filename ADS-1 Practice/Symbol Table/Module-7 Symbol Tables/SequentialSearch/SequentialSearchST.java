public class SequentialSearchST<Key, Value> {
    
    int n;
    Node first;
    
    public class Node {
    private Key key;
    private Value val;
    private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {

    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key k) {
        return get(k) != null;
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

    public void delete(Key k) {
        first = delete(first, k);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    // public Iterable<Key> keys()  {
    //     Queue<Key> queue = new Queue<Key>();
    //     for (Node x = first; x != null; x = x.next)
    //         queue.enqueue(x.key);
    //     return queue;
    // }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> symbolTable = new SequentialSearchST<String, Integer>();
        // for (int i = 0; !StdIn.isEmpty(); i++) {
        // String key = StdIn.readString();
        // }
        symbolTable.put("S",0);
        symbolTable.put("O",1);
        symbolTable.put("R",2);
        symbolTable.put("T",3);
        symbolTable.put("E",4);
        symbolTable.put("X",5);
        symbolTable.put("A",6);
        symbolTable.put("M",7);
        symbolTable.put("P",8);
        symbolTable.put("L",9);
        symbolTable.put("E",10);
        // for (String s : symbolTable.keys())
            // System.out.println(s + " " + symbolTable.get(s));
    }
}