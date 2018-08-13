package DataStructures.linkedList;

public class MainClass {
	public static void main (String [] args) {
		Node n1 = new Node ("a");
		Node n2 = new Node ("b");
		Node n3 = new Node ("c");
		Node n4 = new Node ("d");
		
		LinkedListImpl pbj = new LinkedListImpl();
		
		pbj.appendToTail(n1);
		pbj.appendToTail(n2);
		pbj.appendToTail(n3);
		pbj.appendToTail(n4);
		System.out.println(pbj.toString());
		
	}
}
