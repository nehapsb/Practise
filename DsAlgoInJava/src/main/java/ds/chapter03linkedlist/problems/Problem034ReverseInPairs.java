package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem034ReverseInPairs {
	public static ListNode reverseLinkedListInPairs(ListNode head){
		ListNode temp1 = null, temp2=null;
		while(head != null && head.getNext() != null){
			if(temp1 != null){
				temp1.getNext().setNext(head.getNext());
			}
			temp1 = head.getNext();
			head.setNext(head.getNext().getNext());
			temp1.setNext(head);
			if(temp2 == null){
				temp2 = temp1;
			}
			head = head.getNext();
		}
		return temp2;
		
	}
	
	public static void main(String[] args){
		LinkedList linkedList1 = new LinkedList();
		linkedList1.insert(0, 1);
		linkedList1.insert(1, 2);
		linkedList1.insert(2, 3);
		linkedList1.insert(3, 4);
		ListNode reversedIteratively = reverseLinkedListInPairs(linkedList1.getHead());
		LinkedListUtil.displayLinkedList(reversedIteratively);
		
	}
}
