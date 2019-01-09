import java.util.*;

class IndexMinPQ<Key extends Comparable<Key>> {
	private final int maxN;
	private int n;
	
	// binary heap for the priority queue
	private final int[] pq;
	// inverse of pq, i.e. pq[qp[i]] = i
	private final int[] qp;
	// keys for storing priority and other useful data
	private final Key[] keys;
	
	public IndexMinPQ(int maxN) {
		this.maxN = maxN;
		n = 0;
		
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		keys = (Key[]) new Comparable[maxN + 1];
		for (int i = 0; i < maxN + 1; i++) {
			pq[i] = -1;
			qp[i] = -1;
		}
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public boolean contains(int i) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		return qp[i] != -1;
	}
	
	public int size() {
		return n;
	}
	
	public void insert(int i, Key key) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (contains(i)) {
			if (keys[i].compareTo(key) > 0) {
				decreaseKey(i, key);
			}
		} else {
			insertOnly(i, key);
		}
	}
	
	public void insertOnly(int i, Key key) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (contains(i)) throw new IllegalArgumentException("i already existed");
		
		n++;
		pq[n] = i;
		qp[i] = n;
		keys[i] = key;
		swim(n);
	}
	
	public int minIndex() {
		if (n == 0) throw new NoSuchElementException("priority queue is empty");
		return pq[0];
	}
	
	public Key minKey() {
		if (n == 0) throw new NoSuchElementException("priority queue is empty");
		return keys[pq[0]];
	}
	
	public Key delMin() {
		if (n == 0) throw new NoSuchElementException("priority queue is empty");
		
		exch(1, n);
		int index = pq[n];
		Key key = keys[index];
		pq[n] = -1;
		qp[index] = -1;
		keys[index] = null;
		n--;
		sink(1);
		return key;
	}
	
	public Key keyOf(int i) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (!contains(i)) throw new NoSuchElementException("i not found in queue");
		return keys[i];
	}
	
	public void changeKey(int i, Key key) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (!contains(i)) throw new NoSuchElementException("i not found in queue");
		
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	public void decreaseKey(int i, Key key) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (!contains(i)) throw new NoSuchElementException("i not found in queue");
		if (keys[i].compareTo(key) <= 0)
			throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
		
		keys[i] = key;
		swim(qp[i]);
	}
	
	public void increaseKey(int i, Key key) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (!contains(i)) throw new NoSuchElementException("i not found in queue");
		if (keys[i].compareTo(key) >= 0)
			throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
		
		keys[i] = key;
		sink(qp[i]);
	}
	
	public void delete(int i) {
		if (i < 0 || i > maxN) throw new IllegalArgumentException("i is not valid");
		if (!contains(i)) throw new NoSuchElementException("i not found in queue");
		
		exch(qp[i], n);
		pq[n] = -1;
		qp[i] = -1;
		keys[i] = null;
		n--;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	/***************************************************************************
	* General helper functions.
	***************************************************************************/
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}
	
	private void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	/***************************************************************************
	* Heap helper functions.
	***************************************************************************/
	private void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j + 1 <= n && greater(j, j+1)) j++;
			if (greater(j, k)) break;
			exch(k, j);
			k = j;
		}
	}
}