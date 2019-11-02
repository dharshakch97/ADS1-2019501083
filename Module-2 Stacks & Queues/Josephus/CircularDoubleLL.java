class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
    }
}

class CircularDoubleLL {
    Node head;
    Node tail;

    public void add(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void formCircle() {
        tail.next = head;
        head.prev = tail;
    }
}