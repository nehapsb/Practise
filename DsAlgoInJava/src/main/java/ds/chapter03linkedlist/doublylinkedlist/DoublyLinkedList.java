package ds.chapter03linkedlist.doublylinkedlist;



public class DoublyLinkedList {
	private int length;
	private DLLNode head;
	private DLLNode tail;
	
	public DoublyLinkedList(){
		length = 0;
	}
	
	public void insertAtTheBegin(DLLNode node){
		if(head == null){
			head = node;
		}
		else{
			node.setNext(head);
			head.setPrevious(node);
			head = node;
		}
		length ++;
	}
	
	public void insertAtEnd(DLLNode node){
		if(head == null){
			head = node;
		}
		else{
			DLLNode temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			node.setNext(null);
			node.setPrevious(temp);
			temp.setNext(node);
		}
		length ++;
	}
	
	public void insert(int position, DLLNode node){
		if (head == null) {
			head = node;
		}
		if (position > length) {
			position = length;
		}
		if (position < 0) {
			position = 0;
		}
		if(position == 0){
			node.setNext(head);
			head = node;
		}
		else{
			DLLNode temp = head;
			for(int i = 0; i<position; i++){
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			node.setPrevious(temp);
			temp.setNext(node);
		}
		length ++;
	}
	
	public DLLNode removeFromBegin(){
		DLLNode temp = head;
		if (temp != null) {
			head = head.getNext();
			head.setPrevious(null);
			temp.setNext(null);
		}
		length --;
		return temp;
		
	}
	
	public DLLNode removeFromEnd(){
		if(head == null){
			return null;
		}
		DLLNode p = head;
		if(head.getNext() == null){
			head = null;
			return p;
		}
		DLLNode temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		DLLNode previous = temp.getPrevious();
		previous.setNext(null);
		temp.setPrevious(null);;
		return temp;
		
		
	}
	
	@Override
	public String toString() {
		String result="[]";
		if(length == 0) {
			return result;
		}
		result = "["+head.getNext().getData();
		DLLNode temp = head.getNext().getNext();
		while(temp != null ) {
			result = result+temp.getData();
			temp = temp.getNext();
		}
		result=result+"]";
		return result;
	}
}
