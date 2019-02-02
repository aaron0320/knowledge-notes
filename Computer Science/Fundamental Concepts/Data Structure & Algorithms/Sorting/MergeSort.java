class MergeSort {
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		// Check if there's only 1 element between lo and hi
		if (lo >= hi) {
			return;
		}
		
		int mid = (lo + hi) / 2;
		// Sort the left part
		sort(a, aux, lo, mid);
		// Sort the right part
		sort(a, aux, mid + 1, hi);
		// Merge left and right
		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j];
				j++;
			} else if (j > hi) {
				a[k] = aux[i];
				i++;
			} else if (less(aux[i], aux[j])) {
				a[k] = aux[i];
				i++;
			} else {
				a[k] = aux[j];
				j++;
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
}