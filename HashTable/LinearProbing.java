class LinearProbing<K, V> {
	private int M = 97;
	private Node<K, V>[] st = new Node[M];
	
	private static class Node<K, V> {
		K key;
		V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(K key, V value) {
		// FIXME - Assume that M is always > N
		int i;
		for (i = hash(key); st[i] != null; i = (i + 1) % M) {
			if (key.equals(st[i].key)) {
				break;
			}
		}
		st[i] = new Node(key, value);
	}
	
	public V get(K key) {
		// FIXME - Assume that M is always > N
		int i;
		for (i = hash(key); st[i] != null; i = (i + 1) % M) {
			if (key.equals(st[i].key)) {
				return st[i].value;
			}
		}
		return null;
	}
}