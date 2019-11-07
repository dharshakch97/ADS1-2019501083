import java.util.*;
class MinPQ<Key> {

	public Key[] pqArray;

	public int size;

	public Comparator<Key> comparator;

	public MinPQ(final int sz) {
		pqArray = (Key[]) new Object[sz + 1];
		size = 0;
	}

	// public MinPQ() {
	// 	this(1);
	// }

	public int size() {
		return size;
	}

	public void insert(final Key k) {
		if (size == pqArray.length - 1) {
			resize(2 * pqArray.length);
		}
		pqArray[++size] = k;
		swim(size);
	}

	public void swim(int chld) {
		while (chld > 1 && greater(chld / 2, chld)) { //chld is child and chld/2 is parent.
			swap(chld, chld / 2); //exchange parent with child when parent is less than child.
			chld = chld / 2;
		}
	}

	public boolean greater(int i, int j) {
		if (comparator == null) {
			return  ((Comparable<Key>) pqArray[i]).compareTo(pqArray[j]) > 0;
		} else {
			return comparator.compare(pqArray[i], pqArray[j]) > 0;
		}
	}

	Key delMin() {
		Key min = pqArray[1];
		swap(1, size--);
		sink(1);
		pqArray[size + 1] = null;
		if ((size > 0) && (size == (pqArray.length - 1) / 4)) {
			resize(pqArray.length / 2);
		}
		return min;
	}

	Key getMin() {
		return pqArray[1];
	}

	void sink(int a) {
		while (2 * a <= size) {
			int j = 2 * a;
			if (j < size && greater(j, j + 1)) {
				j++;
			}
			swap(a, j);
			a = j;
		}
	}

	void resize(int nsize) {
		Key[] temp = (Key[]) new Object[nsize];
		for (int i = 1; i <= size; i++) {
			temp[i] = pqArray[i];
		}
		pqArray = temp;
	}

	void swap(int i, int j) {
		Key temp = pqArray[i];
		pqArray[i] = pqArray[j];
		pqArray[j] = temp;
	}

	void show() {
		for (int i = 1; i < size + 1; i++) {
			System.out.print(pqArray[i] + " ");
		}
		System.out.println();
	}
}