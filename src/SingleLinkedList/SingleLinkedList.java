package SingleLinkedList;

public class SingleLinkedList {
	public Node head;
	public Node tail;

	public SingleLinkedList() {
		head = null;
		tail = null;
	}

	//INSERTIONS
	public void insertFirst(int number) {
		Node newNode = new Node(number);

		if (head == null) {
			// when list is empty
			head = newNode;
			tail = newNode;
		} else {
			// when list contains elements
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertLast(int number) {
		Node newNode = new Node(number);

		if (head == null) {
			// when list is empty
			head = newNode;
			tail = newNode;
		} else {
			// when list contains elements
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void insertMiddle(int number) {
		Node newNode = new Node(number);
		Node pointer = head;

		if (head == null) {
			// when list is empty
			head = newNode;
			tail = newNode;
			return;
		}

		for (int i = 1; i < length() / 2; i++) {
			pointer = pointer.next;
		}

		newNode.next = pointer.next;
		pointer.next = newNode;

	}

	public void insertToSpecificIndex(int number, int index) {
		Node newNode = new Node(number);
		Node pointer = head;

		if (head == null) {
			// when list is empty
			head = newNode;
			tail = newNode;
			return;
		}

		if (index == 0) {
			// insert to head
			newNode.next = head;
			head = newNode;
		} else if (index > length() - 1) {
			// insert to tail
			tail.next = newNode;
			tail = newNode;
		} else {
			// insert to interval 0 and list length
			for (int i = 1; i < index; i++) {
				pointer = pointer.next;
			}

			newNode.next = pointer.next;
			pointer.next = newNode;
		}
	}

	// DELETIONS
	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node pointer = head;

			for (int i = 1; i < length() - 1; i++) {
				pointer = pointer.next;
			}

			tail = pointer;
			pointer.next = null;
		}
	}

	public void deleteMiddle() {
		Node previousOfMiddle = null;
		Node middle = head;

		if (head == null) {
			System.out.println("List is empty");
		} else if (head == tail) {
			System.out.println("You cannot add data middle of one element list");
		} else {
			for (int i = 1; i <= length() / 2; i++) {
				previousOfMiddle = middle;
				middle = middle.next;
			}

			previousOfMiddle.next = middle.next;
			middle.next = null;
		}
	}

	public void deleteSpecificIndex(int index) {
		Node pointer = head;
		Node previous = null;

		if (head == null) {
			System.out.println("List is empty");
		} 
		else if (head == tail) { // if there is one element in list
			head = null;
			tail = null;
		} 
		else {
			//if we delete first element
			if (index < 0 || index == 0) {
					head = head.next;
					pointer = null;
			}
			else {
				//fix if index larger than list size
				if (index > length() - 1) {
					index = length() - 1;
				}
				
				for (int i = 1; i <= index; i++) {
					previous = pointer;
					pointer = pointer.next;
				}

				previous.next = pointer.next;
				pointer.next = null;
			}
		}

	}

	// OTHER FUNCTIONS
	public void search(int number) {
		Node pointer = head;
		int counter = 0;

		while (pointer != null) {
			if (number == pointer.data) {
				System.out.println("The searched number was found at " + counter + ". index");
			}

			pointer = pointer.next;
			counter++;
		}
	}

	public void get(int index) {
		Node pointer = head;

		if (length() <= index) {
			// when index bigger than length of list
			index = length() - 1; // set the index as last element.
		} else if (index < 0) {
			index = 0; // set the index as first element.
		}

		for (int i = 1; i <= index; i++) {
			pointer = pointer.next;
		}

		System.out.println("List[" + index + "] = " + pointer.data);
	}
	
	public static SingleLinkedList merge(SingleLinkedList l1, SingleLinkedList l2) {
		SingleLinkedList mergedList = null;
		
		if(l1 == null) {
			return l2;
		}
		else if(l2 == null) {
			return l1;
		}else {
			l1.tail.next = l2.head;
			l1.tail = null;
			l2.head = null;
			
			mergedList = l1;
			mergedList.head = l1.head;
			mergedList.tail = l2.tail;
			
			return mergedList;
		}		
	}
	
	public int smallest() {
		int min = 0;
		
		if(length() == 0) {
			System.out.println("list is empty");
		}else {
			Node pointer = head;
			min = head.data;
			
			while(pointer != null) {
				if(min > pointer.data) {
					min = pointer.data;
				}
				pointer = pointer.next;
			}
		}
		
		return min;
	}

	// SUPPORT
	public int length() {
		int counter = 0;
		Node pointer = head;

		while (pointer != null) {
			pointer = pointer.next;
			counter++;
		}

		return counter;
	}

	public void printList() {
		Node pointer = head;

		System.out.print("Elements of list : ");
		while (pointer != null) {
			System.out.print(pointer.data + " ");
			pointer = pointer.next;
		}

		System.out.println();
	}
}
