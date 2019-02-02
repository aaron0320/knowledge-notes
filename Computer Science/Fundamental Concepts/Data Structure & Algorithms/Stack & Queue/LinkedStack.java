import java.util.*;

public class LinkedStack<E> implements Iterable<E>{
	private class Node<E> {
		E item;
		Node<E> next;
	
		public E getItem() {
			return item;
		}
	}
	
	private Node<E> first;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(E item) {
		Node<E> newFirst = new Node();
		newFirst.item = item;
		newFirst.next = first;
		first = newFirst;
	}
	
	public E pop() {
		if (first == null) {
			return null;
		}
		
		Node<E> oldFirst = first;
		first = oldFirst.next;
		return oldFirst.getItem();
	}
	
	public Iterator<E> iterator() {
		return new ListIterator(first);
	}
	
	private class ListIterator<E> implements Iterator<E> {
		private Node<E> current;
		
		public ListIterator(Node<E> first) {
			this.current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public E next() {
			E item = current.getItem();
			current = current.next;
			return item;
		}
	}
}