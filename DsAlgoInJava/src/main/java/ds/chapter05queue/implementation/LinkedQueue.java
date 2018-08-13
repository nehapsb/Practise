package ds.chapter05queue.implementation;

import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class LinkedQueue {

	private int length;
	private ListNode front, rear;
	
	public LinkedQueue(){
		length = 0;
		front = rear = null;
	}
	
	public void enquque(int data){
		ListNode node = new ListNode(data);
		if(isEmpty()){
			front = node;
			rear = node;
		}
		else{
			rear.setNext(node);
			rear = node;
		}
		length++;
	}
	
	public int dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("");
		}
		int result = front.getData();
		front = front.getNext();
		length --;
		if(isEmpty()) rear=null;
		return result;
	}
	
	public boolean isEmpty(){
		return length == 0;
	}
	
	public int size(){
		return length;
	}
	
	public String toString(){
		String result = "";
		ListNode current = front;
		while(current!=null){
			result = result + current.getData() + " ";
			current = current.getNext();
		}
		return result;
	}
}
