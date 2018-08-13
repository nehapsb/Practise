package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

/**
 * 
 * Problem-10: Can we solve problem-7 in O(n)?
 * 
 * Solution: Yes, Efficient Approach (Memory Less Approach).
 * 
 * Using Floyd Cycle Finding Algorithm
 * It takes 2 ptrs moving at diff speeds to walk linked list.
 * Once they enter loop, they are expected to meet, which denotes there is loop.
 * This works because the only way a faster moving ptr will point to same loc as
 * slow moving ptr is, if somehow the entire list or a part of it is circular.
 *  
 * So, here slow ptr moves one ptr at a time and fast ptr moves two ptr at a time.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *  
 * 
 */
public class Problem010 {
	
	public static boolean isCyclic(LinkedList linkedList){
		ListNode head = linkedList.getHead();
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while(fastPointer!= null && fastPointer.getNext() != null){
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(fastPointer == slowPointer){
				return true;
			}
		}
		return false;
		
	}

	public static void main (String [] args) {
		LinkedList list = LinkedListUtil.getDummylinkedList();
		System.out.println("isCyclic " +isCyclic(list));
		LinkedList cyclicList = LinkedListUtil.getDummyCycliclinkedList();
		System.out.println("isCyclic " +isCyclic(cyclicList));
	}
}
