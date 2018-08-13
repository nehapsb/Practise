package ds.chapter03linkedlist.singlylinkedlist;

public class LinkedList {
	private int length;
	ListNode head;

	public LinkedList() {
		length = 0;
	}

	public void insertAtTheBegin(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			node.setNext(head);
			head = node;
		}
		length++;
	}

	public void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode currentNode = head;
			for (int i = 0; i < length - 1; i++) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
		length++;
	}

	public void insert(int position, ListNode node) {
		if (head == null) {
			head = node;
		}
		if (position > length) {
			position = length;
		}
		if (position < 0) {
			position = 0;
		}
		if (position == 0) {
			node.setNext(head);
			head = node;
		} else {
			ListNode temp = head;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);

		}
		length++;
	}
	
	public void insert(int position, int  data) {
		if (position > length) {
			position = length;
		}
		if (position < 0) {
			position = 0;
		}
		if (head == null) {
			head = new ListNode(data);
		}else if (position == 0) {
			ListNode node = new ListNode(data);
			node.setNext(head);
			head = node;
		} else {
			ListNode temp = head;
			for (int i = 0; i < position-1; i++) {
				temp = temp.getNext();
			}
			ListNode node = new ListNode(data);
			node.setNext(temp.getNext());
			temp.setNext(node);

		}
		length++;
	}
	

	public ListNode removeFromBegin() {
		ListNode temp = head;
		if (temp != null) {
			head = head.getNext();
			temp.setNext(null);
			length --;
		}
		return temp;
	}
	
	public ListNode removeFromEnd(){
		if(head == null){
			return null;
		}
		ListNode p = head;
		if(head.getNext() == null){
			head = null;
			return p;
		}
		ListNode temp = head;
		ListNode previousToTemp = null;
		for(int i = 0; i<length-1; i++){
			previousToTemp = temp;
			temp = temp.getNext();
		}
		previousToTemp.setNext(null);
		length --;
		return temp;
	}
	
	public void removeMatchedNode(ListNode node){
		if(head == null){
			return;
		}
		ListNode temp = head;
		if(node.equals(head)){
			head = head.getNext();
			temp.setNext(null);
			return;
		}
		while(temp.getNext() != null){
			if(node.equals(temp)){
				temp.setNext(temp.getNext().getNext());
			}
		}
		length --;
	}
	
	public void remove(int position){
		ListNode temp = head;
		if(position < 0){
			position = 0;
		}
		if(position > length){
			position = length;
		}
		if(position == 0){
			head = head.getNext();
			temp.setNext(null);
		}
		else{
			for(int i =0 ; i<position-1; i++){
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length --;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getPosition(int data){
		ListNode temp = head;
		int position = 0;
		while(temp.getNext() != null){
			if(data == temp.getData()){
				return position;
			}
			position++;
			temp = temp.getNext();
		}
		return position;
	}
	
	public ListNode getNode(int position){
		ListNode temp = head;
		if(position < 0) {
			position = 0;
			return temp;
		}
		if(position > length) {
			position = length-1;
		}
		for(int i = 0; i< position; i++){
			temp = temp.getNext();
		}
		
		return temp;
		
	}

	public ListNode getHead() {
		return head;
	}
	
	public void clearList(){
		head=null;
		length=0;
	}
	
	@Override
	public String toString() {
		String result="[head ->";
		if(head==null) {
			return result+"]";
		}
		
		
		result=result+head.getData();
		ListNode temp=head.getNext();
		while(temp != null) {
			result=result+" -> "+temp.getData();
				
			temp=temp.getNext();
		}
		result=result+"]";
		
		return result;
	}
	
}
