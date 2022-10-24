package DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList {
	public Node head;
	public Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	// INSERTIONS
	public void insertFirst(int data) {
		Node newNode = new Node(data);

		if (isContainElement()) {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);

		if (isContainElement()) {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
	}

	public void insertMiddle(int data) {
		Node newNode = new Node(data);
		Node pointer = head;

		if (isContainElement()) {
			if (length() == 1) {
				System.out.println("You cannot add middle if there is one element in list.");
				return;
			}

			for (int i = 1; i < length() / 2; i++) {
				pointer = pointer.next;
			}

			newNode.previous = pointer;
			newNode.next = pointer.next;
			pointer.next.previous = newNode;
			pointer.next = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
	}

	public void insertToSpesificIndex(int data, int index) {
		Node newNode = new Node(data);

		if (isContainElement()) {
			if (index == 0) {

				newNode.next = head;
				head.previous = newNode;
				head = newNode;

			} else if (index > length() - 1) {

				// if index bigger than list lenght
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;

			} else {

				Node pointer = head;
				for (int i = 1; i <= index; i++) {
					pointer = pointer.next;
				}

				newNode.previous = pointer.previous;
				newNode.next = pointer;
				pointer.previous.next = newNode;
				pointer.previous = newNode;

			}
		} else {
			head = newNode;
			tail = newNode;
		}
	}

	// DELETIONS
	public void deleteFirst() {
		if (isContainElement()) {

			if (head == tail) { // if there is one element in list
				head = null;
				tail = null;
			}

			head = head.next;
			head.previous = null; // there is still a old head exists but we cant reach it. Java garbage collecter
									// deletes it otomatically.

		} else {
			System.out.println("You cannot delete from empty list.");
		}
	}

	public void deleteLast() {
		if (isContainElement()) {

			if (head == tail) { // if there is one element in list
				head = null;
				tail = null;
			}

			tail = tail.previous;
			tail.next = null;

		} else {
			System.out.println("You cannot delete from empty list.");
		}
	}

	public void deleteMiddle() {
		Node pointer = head;

		if (isContainElement()) {

			if (head == tail) {
				head = null;
				tail = null;
			}

			for (int i = 1; i < (length()+1) / 2; i++) {
				pointer = pointer.next;
			}
			
			pointer.next.previous = pointer.previous;
			pointer.previous.next = pointer.next;
			pointer.previous = null;
			pointer.next = null;

		} else {
			System.out.println("You cannot delete from empty list.");
		}
	}

	
	public void deleteSpesificIndex(int index) {
		if (isContainElement()) {
			
			if (index == 0) {
				
				deleteFirst();
				
			} else if (index >= length() - 1) {
				// if index bigger than list lenght
				deleteLast();				

			} else {

				Node pointer = head;
				for (int i = 1; i <= index; i++) {
					pointer = pointer.next;
				}

				pointer.next.previous = pointer.previous;
				pointer.previous.next = pointer.next;
				pointer.next = null;
				pointer.previous = null;

			}
		} else {
			System.out.println("You cannot delete from empty list.");
		}
	}
	
	// SUPPORT
	public void printList() {
		Node pointer = head;

		for (int i = 0; i < length(); i++) {
			System.out.print(pointer.data + " ");
			pointer = pointer.next;
		}

		System.out.println();
	}

	public int length() {
		int counter = 0;
		Node pointer = head;

		while (pointer != null) {
			pointer = pointer.next;
			counter++;
		}

		return counter;
	}

	public boolean isContainElement() {
		if (length() == 0) {
			return false;
		}

		return true;
	}
}
