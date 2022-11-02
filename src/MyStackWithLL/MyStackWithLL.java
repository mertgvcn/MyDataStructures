package MyStackWithLL;

public class MyStackWithLL<Type> {
	Node top;

	public MyStackWithLL() {
		top = null;
	}

	// PUSH & POP & PEEK
	public void push(Type data) { // we are gonna use the first node as top of the list
		Node newNode = new Node(data);

		newNode.next = top;
		top = newNode;
	}

	public Node<Type> pop() {
		
		if (isEmpty()) {
			System.out.println("List is empty");
			return null;
			
		} else {
			Node<Type> oldTop = top;
			top = top.next;
			return oldTop;
		}
	}
	
	public Node<Type> peek() {
		return top;
	}
	
	// SUPPORT
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}

		return false;
	}

	public String toString() {

		if (isEmpty())
			return "List is empty";

		StringBuilder msg = new StringBuilder();
		Node pointer = top;

		while (pointer != null) {
			msg.append(pointer.data + " ");
			pointer = pointer.next;
		}

		return msg.toString();
	}
}
