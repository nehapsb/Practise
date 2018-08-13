package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class DeleteAlternateNodes {

	public  static void removeAlternativeNode(ListNode head){
		ListNode current = head;
		
		while(current != null && current.getNext() != null){
			current.setNext(current.getNext().getNext());
			current = current.getNext();
		}
	}
	
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		linkedList.toString();
		ListNode head = linkedList.getHead();
		removeAlternativeNode(head);
		while(head != null){
			System.out.println(head.getData() + "-> ");
			head = head.getNext();
		}
		
	}
}
