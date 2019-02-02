class InsertionSort {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int j = i;
			while(j > 0 && less(a[j], a[j-1])) {
				exch(a, j, j-1);
				j--;
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
}