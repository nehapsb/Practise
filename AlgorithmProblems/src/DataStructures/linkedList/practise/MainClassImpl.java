package DataStructures.linkedList.practise;

public class MainClassImpl {
	public static void main (String [] args) {
		Node n1 = new Node ("a");
		Node n2 = new Node ("b");
		Node n3 = new Node ("c");
		LinkedListImp obj = new LinkedListImp();
		obj.appendToTail(n1);
		obj.appendToTail(n2);
		obj.appendToTail(n3);
		System.out.println(obj.toString());
	}
}
