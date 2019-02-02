import java.util.*;

class Client {
	public static void main(String[] args) {
//		LinkedStack<String> linkedStack = new LinkedStack();
//		linkedStack.push("hi");
//		linkedStack.push("fc");
		
//		while(!linkedStack.isEmpty()) {
//			System.out.println(linkedStack.pop());
//			System.out.println(linkedStack.isEmpty());
//		}
//		Iterator<String> it = linkedStack.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		ArrayStack<String> arrayStack = new ArrayStack(1);
		arrayStack.push("hi");
		arrayStack.push("fc");
		arrayStack.push("hi");
		arrayStack.push("fc");
		arrayStack.push("hi");
		arrayStack.push("fc");
		arrayStack.push("hi");
		arrayStack.push("fc");
//		
//		while(!arrayStack.isEmpty()) {
//			System.out.println(arrayStack.pop());
//			System.out.println(arrayStack.isEmpty());
//		}
		
		Iterator<String> it = arrayStack.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}