import java.util.*;

class BfsClient {
	public static void main(String[] args) {
		// Generate a random binary tree
		BinaryTree btree = new BinaryTree();
		listNodes(btree.getRoot());
	}
	
	public static void listNodes(Node root) {
		if (root == null) {
			throw new IllegalArgumentException("root must not be null");
		}
		
		ArrayList<Node> nodesToBePrinted = new ArrayList<Node>();
		
		Queue<Node> queue = new LinkedList<Node>();
		root.depth = 0;
		queue.add(root);
		
		// Traverse nodes with BFS, set corresponding depth and push to nodesToBePrinted array
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			nodesToBePrinted.add(current);
			
			if (current.left != null) {
				current.left.depth = current.depth + 1;
				queue.add(current.left);
			}
			if (current.right != null) {
				current.right.depth = current.depth + 1;
				queue.add(current.right);
			}
		}
		
		printNodes(nodesToBePrinted);
	}
	
	private static void printNodes(ArrayList<Node> nodesToBePrinted) {
		if (nodesToBePrinted.isEmpty()) {
			System.out.println("Tree is empty");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		// Print the root node
		printOneNode(sb, nodesToBePrinted.get(0));
		
		// Print the remaining nodes
		for (int i = 1; i < nodesToBePrinted.size(); i++) {
			// If the node i's depth is larger than node i-1's depth
			if (nodesToBePrinted.get(i).getDepth() > nodesToBePrinted.get(i-1).getDepth()) {
				// Print a new line
				System.out.println();
			}
			printOneNode(sb, nodesToBePrinted.get(i));
		}
	}
	
	private static void printOneNode(StringBuilder sb, Node node) {
		if (sb == null) {
			throw new IllegalArgumentException("String builder is null");
		}
		if (node == null) {
			throw new IllegalArgumentException("Node is null");
		}
		sb.setLength(0);
		sb.append("(");
		sb.append(node.getValue());
		sb.append(")");
		System.out.print(sb.toString());
	}
}
