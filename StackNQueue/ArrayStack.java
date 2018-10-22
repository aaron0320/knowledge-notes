import java.util.*;

class ArrayStack<E> implements Iterable<E>{
	private E[] arr;
	private int currentId;
	
	public ArrayStack(int N) {
		arr = (E[]) new Object[N];
		currentId = 0;
	}
	
	public boolean isEmpty() {
		return currentId == 0;
	}
	
	public void push(E item) {
		if (currentId == arr.length) {
			resizeArr(2 * arr.length);
		}
		
		arr[currentId] = item;
		currentId++;
	}
	
	public E pop() {
		currentId--;
		System.out.println(currentId + " " + arr.length);
		
		if (currentId < arr.length/4) {
			resizeArr(arr.length / 2);
		}
		
		return arr[currentId];
	}
	
	private void resizeArr(int newLength) {
		E[] newArr = (E[]) new Object[newLength];
		
		int min = Math.min(newLength, arr.length);
		for (int i = 0; i < min; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<E>{
		int itIndex = 0;
		
		public boolean hasNext() {
			return itIndex < currentId;
		}
		
		public E next() {
			E item = arr[itIndex];
			itIndex++;
			return item;
		}
	}
}