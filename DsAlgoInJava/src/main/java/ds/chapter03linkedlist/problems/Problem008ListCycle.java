package ds.chapter03linkedlist.problems;

import java.util.HashSet;
import java.util.Set;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

/**
 * Problem-8: Can we use hashing technique to solve the above problem?
 * Solution: Yes,
 * Algo:
 *  a) Traverse the linked list nodes one by one.
 *  b) Check if address of node is already available in hash table or not.
 *  c) If available, then that indicates we are visiting the node that was already visited. This is possible only if the given linked list has loop in it.
 *  d) If address is not available, then insert the node's address into hash table.
 *  e) Continue till we reach end or we find a loop.
 * 
 * Time Complexity: O(n) for scanning linked list. Only scan of input.
 * Space Complexity: O(n) for HashSet
 * 
 *
 */

public class Problem008ListCycle {
	
	public static boolean findLoopExistUsingHashing(LinkedList linkedList){
		ListNode head = linkedList.getHead();
		Set<ListNode> listNodes = new HashSet<ListNode>();
		
		ListNode temp = head;
		while(temp != null){
			if(listNodes.contains(temp)){
				return true;
			}
			listNodes.add(temp);
			temp = temp.getNext();
		}
		return false;
		
	}

	public static void main(String [] args) {
		LinkedList cyclicList = LinkedListUtil.getDummyCycliclinkedList();
		LinkedList nonCyclicList = LinkedListUtil.getDummylinkedList();
		System.out.println(findLoopExistUsingHashing(cyclicList));
		System.out.println(findLoopExistUsingHashing(nonCyclicList));
		
	}
}
