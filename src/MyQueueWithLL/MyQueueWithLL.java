package MyQueueWithLL;

public class MyQueueWithLL<Type> {
	Node first;
	Node last;
	
	public MyQueueWithLL() {
		first = null;
		last = null;
	}
	
	//Enqueue & Dequeue
	public void enqueue(Type data) { //when we add a person to queue, we should insert rear of queue (insert last)
		Node<Type> newNode = new Node<Type>(data);
		
		if(isEmpty()) {
			first = newNode;
			last = newNode;
		}else {
			last.next = newNode;
			last = newNode;
		}
	}
	
	public void dequeue() { //when we remove a person from queue, we should remove from front of queue(deleteFirst)
		if(isEmpty()) {
			System.out.println("List is empty");
		}else {
			first = first.next;
		}
	}
	
	//SUPPORT
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		Node<Type> pointer = first;
		StringBuilder msg = new StringBuilder();
		
		while(pointer != null) {
			msg.append(pointer.data);
			msg.append(" ");
			
			pointer = pointer.next;
		}
		
		return msg.toString();
	}
}
