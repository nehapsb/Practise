package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

/**
 * Problem-16: Insert a node in a sorted linked list.
 * Solution: Traverse the list and find a position for the element and
 * 	traverse it.
 * 
 * Space Complexity: O(n)
 * Time Complexity: O(1)
 * 
 * @author pasbola
 *
 */
public class Problem016SortedLinkedList {
	
	public static ListNode insertInSortedLinkedList(ListNode node, LinkedList linkedList){
		ListNode head = linkedList.getHead();
		ListNode current = head;
		if(head == null){
			head = node;
			return node;
		}
		if(head.getData() > node.getData()){
			node.setNext(head);
			head = node;
		}
		else{
			ListNode temp=null;
			while(current != null && current.getData() < node.getData()){
				temp = current;
				current = current.getNext();
			}
			node.setNext(current);
			temp.setNext(node);
		}
		return head;
	}

	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		insertInSortedLinkedList(new ListNode(70), linkedList);
		System.out.println(linkedList.toString());
		System.out.println("length " + linkedList.getLength());
		ListNode node = insertInSortedLinkedList(new ListNode(20), linkedList);
		System.out.println(linkedList.toString());
		System.out.println(linkedList.getHead().getData());
		System.out.println(displayList(node));
	}
	
	private static String displayList(ListNode head) {
		String result="[";
		if(head==null) {
			return result+"]";
		}
		result=result+" head -> "+head.getData();
		
		result=result+" , "+head.getData()+" -> "+head.getNext().getData();
		ListNode temp=head.getNext();
		while(temp != null) {
			if(temp.getNext()!= null){
			result=result+" , "+temp.getData()+" -> "+temp.getNext().getData();
			} else {
				result=result+" , "+temp.getData()+" -> "+temp.getNext();
			}
				
			temp=temp.getNext();
		}
		result=result+"]";
		
		return result;
	
}
}
