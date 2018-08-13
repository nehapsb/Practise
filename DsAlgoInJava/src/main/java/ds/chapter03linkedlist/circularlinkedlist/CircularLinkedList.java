package ds.chapter03linkedlist.circularlinkedlist;


public class CircularLinkedList {
	private CLLNode head;
	private int length;
	
	public CircularLinkedList(){
		length = 0;
		head = null;
	}
	
	public void insertAtTheBegin(CLLNode node){
		if(head == null){
			head = node;
		}
		else{
			node.setNext(head);
			CLLNode temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(node);
			head = node;
		}
		length ++;
	}
}
