import java.util.*;

public class ArrayMinPQ {
	private Comparable[] pq;
	private int currentId;
	
	public ArrayMinPQ(int capacity) {
		pq = new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return currentId == 0;
	}
	
	public void insert(Comparable item) {
		pq[currentId] = item;
		currentId++;
	}
	
	public Comparable delMin() {
		if (currentId == 0) {
			return null;
		}
		
		int min = 0;
		for (int i = 0; i < currentId; i++) {
			if (less(pq[i], pq[min])) {
				min = i;
			}
		}
		exch(pq, min, currentId - 1);
		currentId--;
		return pq[currentId];
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}