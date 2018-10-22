class Client {
	public static void main(String[] args) {
		BinaryHeapMinPQ pq = new BinaryHeapMinPQ(50);
		
		Integer[] arr = {5, 0, 2, 9, 8, 10, 1, 3, 4,99,12,94,918,-1,0};
		for (Integer i : arr) {
			System.out.print(i + ",");
			pq.insert(i);
		}
		System.out.println();
		
		while(!pq.isEmpty()) {
			System.out.print(pq.delMin() + ",");
		}
	}
}