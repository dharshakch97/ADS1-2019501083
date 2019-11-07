/**
 * @author Dharshak
 * Queue class.
 * Here, we implement enqueue() and dequeue() on queue class
 */
class Queue<Item> {
    /**
     * @param Item[] queue
     */
    Item[] queue;
    /**
     * @param size size = 0
     */
    int size = 0;

    public Queue(int capacity) {
        /**
         * Giving capacity for the queue
         */
        queue = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        /**
         * checks if queue is empty or not.
         * If empty, returns size = 0
         */
        return size == 0;
    }

    public int getSize() {
        return size;
    }
    public void enqueue(Item item) {
        /**
         * Adding an item to the queue
         */
        queue[size++] = item;
     }

     public Item dequeue() {
        /**
         * returning the item that dequeued from the queue
         */
        Item t = queue[0];

         if(isEmpty())
             return null;
         else{
            for(int i = 0; i < size-1; i++)
                queue[i] = queue[i+1];
            size--;
        }
        return t;
    }
}