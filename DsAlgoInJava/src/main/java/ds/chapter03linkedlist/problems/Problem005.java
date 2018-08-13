package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;


/**
 * Problem-5: Can we solve problem -2 in one scan?
 * Solution: Use two pointers pNthNode and pTemp. Initially, both points to head node. pNthNode starts moving
 * only after pTemp made n moves. From there both moves forward until pTemp reaches end of list. As a result, pNthNode
 * points to nth node from end of linked list.
 *  
 *  Let us say we have a list of 10 elements and we want to find 3rd element from last.
 *  So, pTemp and pNthNode points to head element initially.
 *  According to the solution, pTemp makes n=3 moves (remaining 7 moves till end). 
 *  Now, pNthNode also starts moving till pTemp.next=null; 
 *  pNthNode points to 7th element in this case, 3rd from last.
 *  
 *  Time complexity: O(n)
 *  Space complexity: O(1)
 * @author ashi
 *
 */
public class Problem005 {
	public static int findNthNodeFromEnd(LinkedList linkedList, int position){
		ListNode head = linkedList.getHead();
		ListNode temp = head;
		ListNode nthNode = head;
		for(int i =0; i<position; i++){
			temp = temp.getNext();
		}
		while(temp.getNext() != null){
			temp = temp.getNext();
			nthNode = nthNode.getNext();
		}
		
		return nthNode.getData();
	}
	
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		System.out.println("nth node" +findNthNodeFromEnd(linkedList, 9));
	}
}
