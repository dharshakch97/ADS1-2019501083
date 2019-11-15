/**
 * @author Dharshak
 */
import java.util.*;
/**
 * Node class
 * it contains data and next
 */
class Node {
    int data;
    Node next;
    // Node constructor
    Node(int d) {
        data = d;
        next = null;
    }
}

/**
 * QueueCircular Class
 * It contains 'rear' and size 'n'
 */
class QueueCircular {
    Node rear;
    int n;

    // QueueCircular Constructor
    QueueCircular() {
        rear = null;
        n = 0;
    }

    /**
     * Enqueueing the input data to the queue
     * @param data input data that to be enqueued to queue.
     */
    public void enqueue(int data) {
        if (n == 0) { // if 'n' is 0
            Node old = new Node(data);
            rear = old; 
            rear.next = rear; 
        }
        else {
            Node t = new Node(data);
            t.next = rear.next;
            rear.next = t;
            rear = t;
        }
        n++; //incrementing 'n'
        System.out.print(data + "->");
    }

    /**
     * Dequeueing first element from the queue
     */
    public int dequeue() {
        if (n == 0)
            rear = null;
        else {
            int NodeData = rear.next.data;
            rear.next = rear.next.next;
            n--;
            return NodeData;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Creating object for QueueCircular
        QueueCircular qc = new QueueCircular();
        // adding 4 elements to the queue circular 'qc'
        qc.enqueue(10);
        qc.enqueue(20);
        qc.enqueue(30);
        qc.enqueue(40);
        System.out.println();
        System.out.println("Enqueued");
        // removing the first two elements from the queue      
        System.out.println("Dequeueing..." + qc.dequeue());
        System.out.println("Dequeueing..." + qc.dequeue());
        System.out.println("Dequeueing..." + qc.dequeue());
        System.out.println("Dequeueing..." + qc.dequeue());
        System.out.println("Dequeueing..." + qc.dequeue());

    }
}
