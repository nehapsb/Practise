package ds.chapter03linkedlist.doublylinkedlist;


public class DLLNode {

	private int data;
	private DLLNode next;
	private DLLNode previous;
	
	public DLLNode(int data){
		this.data = data;
	}
	
	public DLLNode(int data, DLLNode previous, DLLNode next) {
		super();
		this.next = next;
		this.previous = previous;
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}
	
	
}
