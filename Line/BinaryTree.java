class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node0 = new Node(0);
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		Node node10 = new Node(1);
		
		node2.left = node1;
		node2.right = node3;
		node1.left = node0;
		node1.right = node7;
		node3.left = node9;
		node3.right = node10;
		node10.left = new Node(10);
		
		root = node2;
	}
	
	public Node getRoot() {
		return root;
	}
}