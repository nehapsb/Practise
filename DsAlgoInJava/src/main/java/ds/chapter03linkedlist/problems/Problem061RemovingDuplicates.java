package ds.chapter03linkedlist.problems;

import java.util.HashSet;
import java.util.Set;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem061RemovingDuplicates {

	public ListNode removeDuplicatesFromUnsortedLinkedList(ListNode head){
		ListNode current = head;
		if(current == null || current.getNext() == null){
			return null;
		}
		ListNode previous, next = head;
		while(current != null){
			next = current.getNext();
			previous = current;
			while(next != null){
				if(current.getData() == next.getData()){
					previous.setNext(next.getNext());
				}
				previous = next;
				next = next.getNext();
			}
			current = current.getNext();
		}
		return head;
		
	}
	
	public ListNode removeDuplicatesUsingHashing(ListNode head){
		ListNode current = head;
		if(current == null || current.getNext() == null){
			return null;
		}
		Set<Integer> nodes = new HashSet<Integer>();
		ListNode previous = null;
		while(current != null){
			if(!nodes.contains(current.getData())){
				nodes.add(current.getData());
				previous = current;
			}
			else{
				previous.setNext(current.getNext());
			}
			current = current.getNext();
		}
		return head;
		
	}
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		linkedList.toString();
		ListNode head = linkedList.getHead();
		Problem061RemovingDuplicates removingDuplicates = new Problem061RemovingDuplicates();
	//	ListNode head1 = removingDuplicates.removeDuplicatesFromUnsortedLinkedList(head);
		removingDuplicates.removeDuplicatesUsingHashing(head);
		while(head != null){
			System.out.println(head.getData() + "-> ");
			head = head.getNext();
		}
		
	}
}
