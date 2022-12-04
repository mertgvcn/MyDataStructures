package Examples;
import LinkedList_Single.*;

public class c_sumOfLastKElements {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertLast(3);
		list.insertLast(7);
		list.insertLast(6);
		list.insertLast(5);
		list.insertLast(2);
		list.printList();
		
		sumOfLastKElements(list, 3);
		list.printList();


	}
	
	public static void sumOfLastKElements(SingleLinkedList list, int k) {
		if(list.length() == 0) {
			System.out.println("List is empty!");
			return;
		}
		
		Node pointer = list.head;
		for (int i = 1; i < (list.length() - k) ; i++) {
			pointer = pointer.next;
		}
		
		int sum = 0;
		Node temp = pointer;
		while(temp.next != null) {
			sum += temp.next.data;
			temp = temp.next;
		}
		
		Node newNode = new Node(sum);
		pointer.next = newNode;
	}

}
