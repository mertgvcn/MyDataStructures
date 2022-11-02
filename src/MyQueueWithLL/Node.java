package MyQueueWithLL;

public class Node<Type> {
	Type data;
	Node next;
	
	public Node(Type data) {
		this.data = data;
		this.next = null;
	}
}
