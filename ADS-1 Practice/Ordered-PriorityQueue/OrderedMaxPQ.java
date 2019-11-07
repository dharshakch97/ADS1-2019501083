class OrderedMaxPQ<Key extends Comparable<Key>> {
    Key[] pq;
    int n;

    OrderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public Key delMax() {
        return pq[--n];
    }

    public void insert(Key k) {
        int i = n - 1;
        while (i >= 0 && less(k, pq[i])) {
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = k;
        n++;
    }

    public boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

    public static void main(String[] args) {
        OrderedMaxPQ<Integer> pq = new OrderedMaxPQ<Integer>(10);
        pq.insert(7);
        pq.insert(10);
        pq.insert(1);
        pq.insert(20);
        while(!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}