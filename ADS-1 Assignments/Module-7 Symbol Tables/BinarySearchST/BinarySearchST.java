import java.util.*;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int n = 0;
    int capacity = 1;

    BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        values = (Value[]) new Object[1];
        n = 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if(isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length)
            resize(keys.length * 2);
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public int rank(Key key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int toCompare = key.compareTo(keys[mid]);
            if (toCompare < 0)
                high = mid - 1;
            else if (toCompare > 0)
                low = mid + 1;
            else 
                return mid;
        }
        return low;
    }

    public void delete(Key key) {
        int i = rank(key);

        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public Key max() {
        return keys[n - 1];
    }

    public Key min() {
        return keys[0];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) 
            return null;

        else if (i < n && key.compareTo(keys[i]) == 0) 
            return keys[i];
        else 
            return keys[i-1];
    }

    public String keys() {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += keys[i] + " ";
        }
        return res;
    }
}