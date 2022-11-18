package SingleLinkedList;

public class TestClass {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertLast(7);
		list.insertLast(3);
		list.insertLast(10);
		list.insertFirst(13);
		list.insertFirst(92);
		list.insertFirst(32);
		list.insertFirst(12);
		list.insertFirst(102);
		list.insertFirst(10);
		list.printList();
		
		System.out.println(list.smallest().data);
		
		
		
	}

}
