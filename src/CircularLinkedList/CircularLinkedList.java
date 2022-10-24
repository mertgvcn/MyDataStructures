package CircularLinkedList;

import DoublyLinkedList.Node;

public class CircularLinkedList {
	public Node head;

	public CircularLinkedList() {
		head = null;
	}

	// INSERTIONS
	public void insert(int data) {
		Node newNode = new Node(data);

		if (head != null) {
			newNode.next = head;
			newNode.previous = head.previous;
			head.previous.next = newNode;
			head.previous = newNode;
		} else {
			newNode.next = newNode;
			newNode.previous = newNode;
		}

		head = newNode;
	}

	// DELETIONS
	public void delete() {
		if (head != null) {
			
			if(head.next == head) { //when list contains one element;
				head = null;
				return;
			}
			
			head.previous.next = head.next;
			head.next.previous = head.previous;
			head = head.next;
			
		} else {
			System.out.println("List is empty, you cannot delete an element");
		}

		
	}

	// SUPPORT
	public void printList() {
		boolean key = true;

		if (head != null) {
			Node pointer = head;

			while (key) {
				System.out.print(pointer.data + " ");
				pointer = pointer.next;
				if (pointer == head) {
					key = false;
				}
			}
		} else {
			System.out.println("List is empty");
		}

		System.out.println();
	}

	public boolean isLapComplete() {
		boolean key = true;

		return true;
	}

}
