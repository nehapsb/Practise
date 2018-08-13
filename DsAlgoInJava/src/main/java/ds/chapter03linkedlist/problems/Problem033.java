package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem033 {

	public static ListNode mergeTwoSortedLists(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		ListNode current = head;

		while (head1 != null && head2 != null) {
			//if (head1 != null && head2 != null) {
				if (head1.getData() <= head2.getData()) {
					current.setNext(head1);
					current = current.getNext();
					head1 = head1.getNext();
				} else {
					current.setNext(head2);
					current = current.getNext();
					head2 = head2.getNext();
				}
		//	}
			if(head1 == null){
				current.setNext(head2);
			}
			if(head2 == null){
				current.setNext(head1);
			}
			
		}
		return head.getNext();

	}

	public static void main(String[] args) {
		LinkedList linkedList1 = new LinkedList();
		linkedList1.insert(0, 20);
		linkedList1.insert(1, 22);
		linkedList1.insert(3, 32);

		LinkedList linkedList2 = new LinkedList();
		linkedList2.insert(0, 18);
		linkedList2.insert(1, 21);
		linkedList2.insert(3, 36);

		ListNode head = mergeTwoSortedLists(linkedList1.getHead(),
				linkedList2.getHead());
		System.out.println(head.getData());
		LinkedListUtil.displayLinkedList(head);

	}

}
