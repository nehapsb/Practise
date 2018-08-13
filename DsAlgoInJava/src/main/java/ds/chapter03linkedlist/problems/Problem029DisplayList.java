package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem029DisplayList {
	public static void dispalyLinkedListFromEnd(ListNode head){
		if(head == null){
			return;
		}
		dispalyLinkedListFromEnd(head.getNext());
		System.out.print(head.getData() +" -> ");
	}

	public static boolean isLinkedListLengthEven(ListNode head){
		ListNode current = head;
		while(current != null &&current.getNext() != null){
			current = current.getNext().getNext();
		}
		if(current == null){
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList(10);
		dispalyLinkedListFromEnd(linkedList.getHead());
		System.out.println(isLinkedListLengthEven(linkedList.getHead()));
	}
}
