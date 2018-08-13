package DataStructures.linkedList.practise;
/**
 * 1. Take a header node 
 * @author ashijune
 *
 */

public class LinkedListImp {
Node head;
	public LinkedListImp() {
		this.head= new Node ("head");
		// TODO Auto-generated constructor stub
	}
	public void appendToTail (Node node) {
		Node current = head;
		while (current.next()!=null) {
			current=current.next();
		}
		current.setNext(node);		
	}
	public String toString () {
		StringBuilder obj = new StringBuilder();
		Node current = head.next();
		while (current!=null) {
			obj.append(current.getData() +" ---> ");
			current=current.next();
		}
		return new String (obj);
		
	}
}
