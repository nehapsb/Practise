package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

/**
 * Problem-12: Check whether the given linked list is either Null-Terminated or not.
 * If there is a cycle, find the start node of loop.
 * 
 * Solution: Solution is an extension of Problem-10.
 * After finding the loop, we initialize the slowPtr to head of linked list.
 * 
 * From that point onwards slowPtr and fastPtr moves one node at a time.
 * The point at which they meet is the start of loop. 
 * This is how we remove the loop.
 * 
 *
 */
public class Problem012 {

	public static ListNode findStartOfCycle(LinkedList linkedList){
		ListNode head = linkedList.getHead();
		ListNode slowPointer = head, fastPointer = head;
		boolean iscyclic = false;
		while(fastPointer != null && fastPointer.getNext() != null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if(fastPointer == slowPointer){
				iscyclic = true;
				break;
			}
		}
		if(iscyclic){
			slowPointer = head;
			while(fastPointer != slowPointer){
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
			}
			return fastPointer;
			
		}
		return null;
		
	}
	
	public static void main (String [] args) {
		LinkedList list = LinkedListUtil.getDummylinkedList();
		System.out.println("findStartOfCycle " +findStartOfCycle(list));
		LinkedList cyclicList = LinkedListUtil.getDummyCycliclinkedList();
		System.out.println("findStartOfCycle " +findStartOfCycle(cyclicList).getData());
	}
}
