package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem028MiddleNode {
	public static ListNode findMiddleNode(ListNode head){
		ListNode slowPointer = head, fastPointer = head;
		while(fastPointer != null && fastPointer.getNext()!=null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			
		}
		return slowPointer;
		
	}
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList(10);
		ListNode middle = findMiddleNode(linkedList.getHead());
		System.out.println("get middle " + middle.getData());
	}

}
