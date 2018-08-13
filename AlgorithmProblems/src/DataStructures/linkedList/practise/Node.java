package DataStructures.linkedList.practise;

public class Node {
Node next=null;
String data;
Node (String data) {
	this.data=data;
}
public Node next () {
	return next;
}
public void setNext (Node next) {
	this.next=next;
}
public String getData () {
	return data;
}
}
