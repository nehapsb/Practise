package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem015 {

	public static int findLengthOfCycle(LinkedList linkedList){
		ListNode head = linkedList.getHead();
		ListNode slowPointer = head, fastPointer = head;
		boolean isCyclic = false;
		while(fastPointer != null ){
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer){
				isCyclic = true;
				break;
			}
		}
		int length = 0;
		if(isCyclic){
			do{
				//slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
				length ++;
			}while(fastPointer != slowPointer);
		}
		return length;
	}
	
	public static void main (String [] args) {
		LinkedList list = LinkedListUtil.getDummylinkedList();
		System.out.println("findLengthOfCycle " +findLengthOfCycle(list));
		LinkedList cyclicList = LinkedListUtil.getDummyCycliclinkedList();
		System.out.println("findLengthOfCycle " +findLengthOfCycle(cyclicList));
	}
}