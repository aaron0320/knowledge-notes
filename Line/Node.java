class Node {
	int value;
	Node left;
	Node right;
	int depth; // Dynamically allocated depth when exploring the tree
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getValue() {
		return value;
	}
}