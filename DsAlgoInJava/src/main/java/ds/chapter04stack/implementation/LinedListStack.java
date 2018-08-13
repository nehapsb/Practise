package ds.chapter04stack.implementation;

import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class LinedListStack {
	private int length;
	private ListNode top;
	
	public LinedListStack(){
		length = 0;
		top = null;
	}
	
	public void push(int data){
		if(top == null){
			top = new ListNode(data);
		}else{
			ListNode node = new ListNode(data);
			node.setNext(top);
			top = node;
		}
		length++;
	}
	
	public int pop() throws Exception{
		if(top == null){
			throw new Exception("Stack is empty");
		}
		ListNode temp = top;
		top = top.getNext();
		temp.setNext(null);
		length --;
		return temp.getData();
		
	}
	
	public int peek() throws Exception{
		if(top == null){
			throw new Exception("Stack is empty");
		}
		
		return top.getData();
	}
	
	public boolean isEmpty(){
		return length == 0;
	}
	
	public int size(){
		return length;
	}
	
	public String toString(){
		String result = " ";
		ListNode current = top;
		
		while(current != null){
			result = result + current.toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
}
