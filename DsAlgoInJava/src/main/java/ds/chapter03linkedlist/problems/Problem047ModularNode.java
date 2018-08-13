package ds.chapter03linkedlist.problems;

/**
 * Problem-47: Find Modular Node: Given a singly linked list, write a function
 * to find the last element from the beginning whose n%k==0, where n is the
 * number of elements in the list and k is an integer constant. For example,
 * if n=19 and k=3 then we should return 18th node.
 * 
 * Solution:
 * For this problem, the value of n is not known in advance.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * @author ashi
 *
 */

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem047ModularNode {
	
	public static ListNode findModularNode(ListNode head, int k){
		ListNode modularNode = null;
		if(k < 0){
			return null;
		}
		int i = 0;
		while(head != null){
			if(i%k == 0){
				modularNode = head;
			}
			head = head.getNext();
			i++;
		}
		return modularNode;
		
	}

	public static void main(String[] args){
		LinkedList linkedList  = LinkedListUtil.getDummylinkedList(6);
		ListNode modular = findModularNode(linkedList.getHead(), 3);
		System.out.println("modular "+ modular.getData());
	}
}
