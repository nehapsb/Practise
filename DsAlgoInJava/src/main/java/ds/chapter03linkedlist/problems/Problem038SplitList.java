package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem038SplitList {
	
	public static void splitCircularList(ListNode head){
		ListNode slowPointer = head, fastPointer = head;
		
		while(fastPointer.getNext() != head && fastPointer.getNext().getNext() !=head){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			
		}
		if(fastPointer.getNext().getNext() == head) {
			fastPointer=fastPointer.getNext();
		}
		fastPointer.setNext(slowPointer.getNext());
		slowPointer.setNext(head);
		LinkedListUtil.displayCLLLinkedList(head);
		LinkedListUtil.displayCLLLinkedList(fastPointer.getNext());
	}

	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList(11);
		ListNode node = linkedList.getNode(10);
		node.setNext(linkedList.getHead());
//		System.out.println(linkedList.toString());
		System.out.println(node.getData());
		splitCircularList(linkedList.getHead());
	}
}
