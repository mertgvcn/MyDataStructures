package SingleLinkedList;

public class TestClass {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertFirst(4);
		list.insertFirst(7);
		list.insertFirst(9);
		list.insertFirst(72);
		list.insertFirst(5);
		list.printList();
		
		list.deleteFirst();
		list.printList();
		System.out.println(list.smallest());
		
		
		
	}

}
