package SingleLinkedList;

public class SingleLinkedList {
	public Node head;
	public Node tail;

	public SingleLinkedList() {
		head = null;
		tail = null;
	}

	// INSERTIONS
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

	public void addSequentially(int data) {
		Node newNode = new Node(data);

		if (length() != 0) {

			if (data <= head.data) {
				insertFirst(data);
				
			} else if (data >= tail.data){
				insertLast(data);
				
			} else {
				Node pointer = head.next;
				Node previous = head;
						
				while(pointer != null) {
					
					if(previous.data <= data && pointer.data > data) {
						newNode.next = pointer;
						previous.next = newNode;
						return;
					}
					
					previous = pointer;
					pointer = pointer.next;
				}
			}

		} else {
			insertFirst(data);
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
		} else if (head == tail) { // if there is one element in list
			head = null;
			tail = null;
		} else {
			// if we delete first element
			if (index < 0 || index == 0) {
				head = head.next;
				pointer = null;
			} else {
				// fix if index larger than list size
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
	public Node search(int number) {
		Node pointer = head;
		int counter = 0;

		while (pointer != null) {
			if (number == pointer.data) {
				return pointer;
			}

			pointer = pointer.next;
			counter++;
		}
		
		return null;
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

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
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

		if (length() == 0) {
			System.out.println("list is empty");
		} else {
			Node pointer = head;
			min = head.data;

			while (pointer != null) {
				if (min > pointer.data) {
					min = pointer.data;
				}
				pointer = pointer.next;
			}
		}

		return min;
	}
	
	public void switchWithNextNode(int data) {
		Node firstNode = search(data);
		Node secondNode;
		
		if(length() < 2) {
			System.out.println("List does not contain enough elements to switch nodes");
			
		}else if(firstNode == tail) {
			System.out.println("Entered data is the tail of the list.");
			
		}else if(length() == 2){ //we have to update both head and tail in this case.
			secondNode = firstNode.next;
			
			secondNode.next = firstNode;
			firstNode.next = null;
			head = secondNode;
			tail = firstNode;
			
		}else if(length() > 2) {		
			secondNode = firstNode.next;				
			
			if(firstNode == head) {
				firstNode.next = secondNode.next;
				secondNode.next = firstNode;
				head = secondNode;
				
			}else if(secondNode == tail) {	//we need previous here	
				
				Node previousNode = head; //to complete bounds correctly, we need previous of firstNode for some cases.
				while(previousNode.next != firstNode) {
					previousNode = previousNode.next;
				}	
				
				previousNode.next = secondNode;
				secondNode.next = firstNode;
				firstNode.next = null;
				tail = firstNode;
				
			}else { //we need previous here		
				
				Node previousNode = head; //to complete bounds correctly, we need previous of firstNode for some cases.
				while(previousNode.next != firstNode) {
					previousNode = previousNode.next;
				}	
				
				previousNode.next = secondNode;
				firstNode.next = secondNode.next;
				secondNode.next = firstNode;				
				
			}
		} 
	}
	
	public void bubbleSort() {
		Node first = head;
		Node second = head.next;
		boolean isChanged = true;
		
		while(isChanged) {
			isChanged = false;
			
			while(second != null) {
				
				if(isDataGreaterThanSecond(first.data)) {
					switchWithNextNode(first.data);
					isChanged = true;
					
					first = head;
					second = head.next;
					break;
				}
				
				first = first.next;
				second = second.next;
			}
		}
		
		
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
	
	public boolean isDataGreaterThanSecond(int data) {
		Node firstNode = search(data);
		Node secondNode;
		
		if(firstNode == null) {
			System.out.println("Node couldn't found in the list.");
		}
		else if(firstNode == tail) {
			System.out.println("Entered data is the tail of the list.");
		}
		else {
			secondNode = firstNode.next;
			if(firstNode.data > secondNode.data) {
				return true;
			}			
		}
		
		return false;
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
