class UnOrderedMaxPQ<Key extends Comparable<Key>> {
    Key[] pq;
    int n;

    UnOrderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getSize() {
        return n;
    }

    public void insert(Key k) {
        pq[n++] = k;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (less(max, i)) max = i;
        exch(max, n - 1);
        }
        return pq[--n];
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void show() {
        for (int i = 0; i < pq.length; i++)
            System.out.println(pq[i]);
    }

    public static void main(String[] args) {
        UnOrderedMaxPQ<Integer> pq = new UnOrderedMaxPQ<Integer>(10);
        pq.insert(9);
        pq.insert(1);
        pq.insert(5);
        pq.insert(10);
        // pq.show();
        while(!pq.isEmpty())
            System.out.println(pq.delMax());

        pq.show();
    }
}