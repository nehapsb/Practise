package ds.chapter03linkedlist.problems;

/**
 * Problem-44: N people have decided to elect a leader by arranging themselves in 
 * a circle and eliminating every Mth person around the circle, closing ranks as
 * each person drops. Find out which person will be the last one 
 * remaining (with rank 1).
 * Solution: 	
 * Assume the input is a circular linked list with N nodes and 
 * each node has a number (range 1 to N) associated with it. 
 * The head node has number 1 as data.
 * 
 * @author ashi
 *
 */
import ds.chapter03linkedlist.circularlinkedlist.CLLNode;

public class Problem044JosephusCircle {

	public static CLLNode getPosition(int n, int m){
		CLLNode tail = new CLLNode(1);
		CLLNode head  = tail;
		for(int i =2; i<= n; ++i){
			CLLNode node = new CLLNode(i);
			tail.setNext(node);
			tail = tail.getNext();
		}
		tail.setNext(head);
		LinkedListUtil.displayCircularLinkedList(head);
	//	int count = n;
	//	while(count > 1){
		for(int count=n; count>0; --count) {
			for(int i=0 ; i<m-1; i++){
				head = head.getNext();
			}
			head.setNext(head.getNext().getNext());
			//--count;
		}
		return head;
		
	}
	
	public static void main(String[] args){
		CLLNode node = getPosition(6, 3);
		System.out.println(node.getData());
	}
}
