class SeparateChaining<K, V> {
	private int M = 97;
	private Node[] st = new Node[M];
	
	private static class Node<K, V> {
		K key;
		V value;
		Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		} 
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V value) {
		int hash = hash(key);
		Node<K, V> node = st[hash];
		while(node != null) {
			if (key.equals(node.key)) {
				node.value = value;
				return;
			}
			node = node.next;
		}
		st[hash] = new Node(key, value, st[hash]);
	}
	
	public V get(K key) {
		int hash = hash(key);
		Node<K, V> node = st[hash];
		while(node != null) {
			if (key.equals(node.key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
}