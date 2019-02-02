import java.util.*;

public class BST<K extends Comparable<K>, V> {
	private class Node {
		K key;
		V value;
		Node left;
		Node right;
		int count;
		
		public Node(K key, V value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}
	
	private Node root;
	
	public void put(K key, V value) {
		root = put(root, key, value);	
	}
	
	private Node put(Node node, K key, V value) {
		if (node == null) {
			return new Node(key, value, 1);
		}
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			node.value = value;
		} else if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.right = put(node.right, key, value);
		}
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	public V get(K key) {
		Node currentNode = root;
		while(currentNode != null) {
			int cmp = key.compareTo(currentNode.key);
			if (cmp == 0) {
				return currentNode.value;
			} else if (cmp < 0) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return null;
	}
	
	public K min() {
		Node min = min(root);
		if (min == null) return null;
		else return min.key;
	}
	
	private Node min(Node node) {
		if (node == null) return null;
		
		if (node.left == null) {
			return node;
		}
		
		return min(node.left);
	}
	
	public K max() {
		Node max = max(root);
		if (max == null) return null;
		else return max.key;
	}
		
	private Node max(Node node) {
		if (node == null) return null;
		
		if (node.right == null) {
			return node;
		}
		
		return max(node.right);
	}
	
	public K floor(K key) {
		Node floor = floor(root, key);
		if (floor == null) return null;
		else return floor.key;
	}
	
	public Node floor(Node node, K key) {
		if(node == null) return null;
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			return floor(node.left, key);
		} else {
			Node floorRight = floor(node.right, key);
			if (floorRight != null) {
				return floorRight;
			} else {
				return node;
			}
		}
	}
	
	public K ceiling(K key) {
		Node ceiling = ceiling(root, key);
		if (ceiling == null) return null;
		else return ceiling.key;
	}
	
	public Node ceiling(Node node, K key) {
		if (node == null) return null;
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			Node ceilingLeft = ceiling(node.left, key);
			if (ceilingLeft != null) return ceilingLeft;
			else return node;
		} else {
			return ceiling(node.right, key);
		}
	}
	
	public int rank(K key) {
		return rank(root, key);
	}
	
	private int rank(Node node, K key) {
		if (node == null) return 0;
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return size(node.left);
		} else if (cmp < 0) {
			return rank(node.left, key);
		} else {
			return size(node.left) + 1 + rank(node.right, key);
		}
	}

		
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if (node == null) return 0;
		else return node.count;
		
	}
	
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<K>();
		inorder(queue, root);
		return queue;
	}
	
	private void inorder(Queue<K> queue, Node node) {
		if (node == null) return;
		inorder(queue, node.left);
		queue.add(node.key);
		inorder(queue, node.right);
	}
	
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node delete(Node node, K key) {
		if (node == null) return null;
		
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				Node nodeToBeDeleted = node;
				node = min(nodeToBeDeleted.right);
				node.left = nodeToBeDeleted.left;
				node.right = deleteMin(nodeToBeDeleted.right);
			}
		}
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	private Node deleteMin(Node node) {
		if (node == null) return null;
		
		if (node.left == null) return node.right;
		
		node.left = deleteMin(node.left);
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}
}