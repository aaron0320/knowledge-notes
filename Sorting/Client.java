class Client {
	public static void main(String[] args) {
		Integer[] arr = {5, 0, 2, 9, 8, 10, 1, 3, 4};
		for (Integer i : arr) {
			System.out.print(i);
		}
		System.out.println(isSorted(arr));
		
		
		StdRandom.shuffle(arr);
		for (Integer i : arr) {
			System.out.print(i);
		}
		System.out.println(isSorted(arr));
		
		QuickSort.sort(arr);
		for (Integer i : arr) {
			System.out.print(i);
		}
		System.out.println(isSorted(arr));
	}
	
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}