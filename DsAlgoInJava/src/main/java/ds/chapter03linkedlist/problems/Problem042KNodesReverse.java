package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem042KNodesReverse {

	public static ListNode reverseKNodes(ListNode head, int k){
		//start with head
		ListNode current = head;
		//last node after reverse
		ListNode prevTail = null;
		//first node before reverse
		ListNode prevCurrent = head;
		while(current != null){
			int count = k;
			ListNode tail = null;
			
			while(current != null && count > 0){
				ListNode next = current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count --;
			}
			if(prevTail != null){
				prevTail.setNext(tail);
			}else{
				head = tail;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
	
		return head;
		
	}
	
	public static void main(String[] args){
		LinkedList linkedList1 = new LinkedList();
		linkedList1.insert(0, 1);
		linkedList1.insert(1, 2);
		linkedList1.insert(2, 3);
		linkedList1.insert(3, 4);
		linkedList1.insert(4, 5);
		linkedList1.insert(5, 6);
		linkedList1.insert(6, 7);
		linkedList1.insert(7, 8);
		ListNode reversedIteratively = reverseKNodes(linkedList1.getHead(), 3);
		
		LinkedListUtil.displayLinkedList(reversedIteratively);
	}
}
