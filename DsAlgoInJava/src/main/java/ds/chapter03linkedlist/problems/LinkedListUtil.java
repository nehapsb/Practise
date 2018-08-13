package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.circularlinkedlist.CLLNode;
import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class LinkedListUtil {

	public static LinkedList getDummylinkedList() {
		LinkedList linkedList = new LinkedList();
		int data = 40;
		for(int i=0; i<5; i++) {
			linkedList.insert(i, data++);
		}
//		linkedList.insert(2, 41);
//		linkedList.insertAtTheBegin(new ListNode(44));
		System.out.println(linkedList.toString());
		return linkedList;
		}
	
/*	public static LinkedList getDummyCycliclinkedList() {
		LinkedList linkedList = new LinkedList();
		int data = 40;
		for(int i=0; i<15; i++) {
			linkedList.insert(i, data++);
		}
		// last node (14) now points to node (10) for a cyclic loop. 
		ListNode lastNode = linkedList.getNode(14);
		System.out.println("get 14 "+ lastNode.getData());
		lastNode.setNext(linkedList.getNode(9).getNext());
		
		System.out.println(linkedList.toString());
		return linkedList;
	}*/
	public static LinkedList getDummyCycliclinkedList() {
		LinkedList linkedList = new LinkedList();
		int data = 40;
		for(int i=0; i<15; i++) {
			linkedList.insert( i, data++);
		}
		// last node (14) now points to node (10) for a cyclic loop. 
		ListNode lastNode = linkedList.getNode(14);
		lastNode.setNext(linkedList.getNode(9).getNext());
		//System.out.println(linkedList.toString());
		return linkedList;
	}
	
	public static LinkedList getDummylinkedList(int size) {
		LinkedList linkedList = new LinkedList();
		int data = 40;
		for(int i=0; i<size; i++) {
			linkedList.insert(i,data++);
		}
		System.out.println(linkedList.toString());
		return linkedList;
		}
	
	public static void displayLinkedList(ListNode head) {
		ListNode temp = head;
		System.out.print("head->");
		while(temp.getNext()!=null) {
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.print(temp.getData());
		System.out.println("");
		
	}
	
	public static void displayCLLLinkedList(ListNode head) {
		ListNode temp = head;
		System.out.print("head->");
		while(temp.getNext()!=head) {
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.print(temp.getData());
		System.out.println("");
		
	}
	public static void displayCircularLinkedList(CLLNode head) {
		CLLNode temp = head;
		System.out.print("head->");
		while(temp.getNext()!=head) {
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.print(temp.getData());
		System.out.println("");
		
	}
	public static void main(String[] args){
/*		LinkedList linkedList = getDummylinkedList();
		System.out.println("get position "+linkedList.getPosition(42));
		System.out.println("getNode " + linkedList.getNode(3).getData());
	//	linkedList.removeFromBegin();
		System.out.println(linkedList.toString());
	//	linkedList.removeFromEnd();
	//	System.out.println(linkedList.toString());
		ListNode node = linkedList.getNode(-1);
		System.out.println("required node " + node.getData());
		System.out.println(getDummyCycliclinkedList());*/
		System.out.println(4<<2);
	}
		
}
