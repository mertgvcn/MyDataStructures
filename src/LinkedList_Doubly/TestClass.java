package LinkedList_Doubly;

public class TestClass {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.println(list.isContainElement());
		list.insertFirst(0);
		list.insertFirst(6);
		list.insertFirst(13);
		list.insertLast(81);
		list.insertMiddle(61);
		list.insertFirst(72);
		list.insertFirst(192);
		list.insertToSpesificIndex(40, 5);
		list.printList();

		list.deleteSpesificIndex(2);
		list.printList();
		System.out.println(list.tail.data);
	}

}
