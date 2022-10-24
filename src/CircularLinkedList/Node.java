package CircularLinkedList;

public class Node {
	public int data;
	public Node next;
	public Node previous;
	
	public Node(int data) {
		this.data = data;
		next = null;
		previous = null;
	}
}
