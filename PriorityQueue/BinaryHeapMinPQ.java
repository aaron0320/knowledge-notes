import java.util.*;

public class BinaryHeapMinPQ<Key extends Comparable<Key>> {
	private Key[] a;
	private int currentIndex;
	
	public BinaryHeapMinPQ(int capacity) {
		a = (Key[]) new Comparable[capacity + 1];
		currentIndex = 1;
	}
	
	public boolean isEmpty() {
		return currentIndex == 1;
	}
	
	public void insert(Key item) {
		a[currentIndex] = item;
		currentIndex++;
		
		swim(currentIndex - 1);
	}
	
	public Key delMin() {
		Key min = a[1];
		exch(a, 1, currentIndex - 1);
		a[currentIndex - 1] = null;
		currentIndex--;
		
		sink(1);
		return min;
	}
	
	private void swim(int index) {
		while(index > 1) {
			int parentIndex = index / 2;
			if(less(a[index], a[parentIndex])) {
				exch(a, parentIndex, index);
				index = parentIndex;
			} else {
				break;
			}
		}
	}
	
	private void sink(int index) {
		while(true) {
			int childIndex = index * 2;
			if (childIndex > currentIndex - 1) {
				break;
			}
			if (childIndex + 1 <= currentIndex - 1 &&
				less(a[childIndex + 1], a[childIndex])) {
				childIndex = childIndex + 1;
			}
			if (less(a[childIndex], a[index])) {
				exch(a, index, childIndex);
				index = childIndex;
			} else {
				break;
			}
		}
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