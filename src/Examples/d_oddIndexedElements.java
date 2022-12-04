package Examples;

import LinkedList_Single.*;

public class d_oddIndexedElements {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertLast(8); // 0
		list.insertLast(9); // 1
		list.insertLast(4); // 2
		list.insertLast(7); // 3
		list.insertLast(3);
		list.printList();
		oddIndexedElements(list).printList();
		System.out.println();
		list.printList();

	}

	public static SingleLinkedList oddIndexedElements(SingleLinkedList list) {
		SingleLinkedList oddIndexedList = new SingleLinkedList();
		SingleLinkedList temp = new SingleLinkedList();

		if (list.length() == 0) {
			System.out.println("List is empty");
			return null;
		}

		// add odd indexed elements to new list
		Node pointer = list.head;
		for (int i = 0; i < list.length(); i++) {
			if (i % 2 != 0) {
				oddIndexedList.insertLast(pointer.data);
			}

			pointer = pointer.next;
		}

		for (int i = 0; i < list.length(); i++) {
			if (i % 2 != 0) {
				list.deleteSpecificIndex(i);
			}
		}
		
		return oddIndexedList;
	}
}
