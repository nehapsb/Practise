package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class MergeTwoLinkedListInPlace {

	public void mergeList(ListNode head1, ListNode head2){
		ListNode previ = head1, list2Prev=null;
		while(head1 != null && head2 != null){
			if(head1.getData() > head2.getData()){
				int temp = head1.getData();
				head1.setData(head2.getData());
				head2.setData(temp);
				ListNode current = head2;
				// To keep list2 sorted, place first element of l8ist2 at its correct place
				if(head2.getNext() != null && head2.getData() > head2.getNext().getData()){
					head2 = head2.getNext();
					ListNode ptr = head2, prev = null;
					while(ptr!= null && ptr.getData() < current.getData()){
						prev = ptr;
						ptr = ptr.getNext();
					}
					
					prev.setNext(current);
					current.setNext(ptr);
					System.out.println("ptr " + ptr.getData() + " current " + current.getData());
					list2Prev = ptr;
				}
			}
			previ = head1;
			head1 = head1.getNext();
		}
		System.out.println("data " + previ.getData());
		previ.setNext(head2);
	}
	
	public static void main(String[] args){
		LinkedList linkedList1 = new LinkedList();
		linkedList1.insert(0, 2);//2,4,7,8,10
		linkedList1.insert(1, 4);//1,3,12
		linkedList1.insert(2, 7);
		linkedList1.insert(2, 8);
		linkedList1.insert(2, 10);
		System.out.println("first list : " + linkedList1.toString());
		LinkedList linkedList2 = new LinkedList();
		linkedList2.insert(0, 1);
		linkedList2.insert(1, 3);
		linkedList2.insert(2, 12);
		System.out.println("second list : " + linkedList2.toString());
		
		MergeTwoLinkedListInPlace mergeTwoLinkedListInPlace = new MergeTwoLinkedListInPlace();
		mergeTwoLinkedListInPlace.mergeList(linkedList1.getHead(), linkedList2.getHead());
		System.out.println("after merging ");
		System.out.println("first list : " + linkedList1.toString());
		System.out.println("second list : " + linkedList2.toString());
	}
}
