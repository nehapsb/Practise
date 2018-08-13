package DataStructures.linkedList;

public class LinkedListImpl {
private Node head;
public LinkedListImpl () {
	this.head= new Node("head");
}
public void appendToTail (Node node) {
	Node current = head;
	System.out.println("current is "+current+" and current.next() is "+current.next());
	while (current.next()!=null) {
		System.out.println("Setting"+ current +" to "+ current.next );
		current=current.next();
		System.out.println("After setting "+ current);
	}
	current.setNext(node);
	System.out.println("After setting current.next() is "+current.next());
	System.out.println("Completed");
	System.out.println("");
}
public boolean isCyclic () {
	Node fast= head;
	Node slow=head;
	while (fast!=null && fast.next() !=null) {
		slow=slow.next();
		fast=fast.next().next();
		if (slow==fast) {
			return true;
		}
	}
	return false;
}
public String toString () {
	StringBuilder obj = new StringBuilder();
	Node current = head.next();
	while (current != null) {
		obj.append(current).append("-->");
		current=current.next ();
	}
	return obj.toString();
}
}
