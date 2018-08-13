package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem017ListReverse {

	public static ListNode reverseSinglyLinkedList(LinkedList linkedList){
		ListNode head = linkedList.getHead();
		ListNode current = head;
		
		ListNode previous = null;
		while(current != null){
			//save the next node
			ListNode next = current.getNext();
			// make current node point to prev
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}
	
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		ListNode node = reverseSinglyLinkedList(linkedList);
		System.out.println(linkedList.toString());
		System.out.println("head " + linkedList.getHead().getData() + " new "+ node.getData());
		
		System.out.println(displayList(node));
	}
	
	private static String displayList(ListNode head) {
		String result="[";
		if(head==null) {
			return result+"]";
		}
		//result=result+" head -> "+head.getData();
		
		result=result+" , "+head.getData()+" -> "+head.getNext().getData();
		ListNode temp=head.getNext();
		while(temp != null) {
			if(temp.getNext()!= null){
			result=result /*+ " , "+temp.getData()*/+" -> "+temp.getNext().getData();
			} else {
			//	result=result+" , "+temp.getData()+" -> "+temp.getNext();
			}
				
			temp=temp.getNext();
		}
		result=result+"]";
		
		return result;
	
}
	
}
