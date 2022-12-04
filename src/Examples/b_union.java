package Examples;

import LinkedList_Single.*;

public class b_union {

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertLast(5);
		list1.insertLast(8);
		list1.insertLast(12);
		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertLast(3);
		list2.insertLast(8);
		
		union(list1, list2).printList();
		
	}

	public static SingleLinkedList union(SingleLinkedList list1, SingleLinkedList list2) {
		SingleLinkedList union = new SingleLinkedList();
		Node i = list1.head;
		Node j = list2.head;
		boolean isUniqueForFirstList;
		
		while(i != null) {
			isUniqueForFirstList = true;
			
			while(j != null) {
				
				if(i.data == j.data) {
					isUniqueForFirstList = false;
				}
				
				j = j.next;
			}
			
			if(isUniqueForFirstList) {
				union.insertLast(i.data);
			}
			
			i = i.next;
			j = list2.head;
			
		}
		
		while(j != null) {
			union.insertLast(j.data);
			j = j.next;
		}
		
		return union;
	}
}
