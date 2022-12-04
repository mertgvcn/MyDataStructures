package LinkedList_Single;

public class TestClass {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		list.insertLast(10);
		list.insertLast(2);
		list.insertLast(1);
		list.insertLast(5);
		list.printList();
		
		list.ReverseTheList();
		list.printList();
		
		
	}

}
