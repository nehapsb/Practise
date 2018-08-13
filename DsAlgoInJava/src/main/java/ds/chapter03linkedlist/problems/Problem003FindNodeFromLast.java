/**
 * Problem-3:   Can we improve the complexity of Problem-2?
 * Solution:	Yes, using HashTable.
 * In this approach, create a hashtable whose entries are <position of node, node address> i.e. key is position of node in list
 * and value is address of that node.
 * Let us say, length of list is M. To find nth node from end, we can convert this to M-n+1th from the beginning.
 * Time complexity: O(m)
 * Space Complexity: O(m) for creating a hash table of size m.
 * @author ashi
 */
package ds.chapter03linkedlist.problems;

import java.util.Hashtable;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem003FindNodeFromLast {

	public static int getPositionFromLastUsingHashTable(LinkedList list, int position){
		int length = list.getLength();
		if(position > length -1){
			return -1;
		}
		else{
			ListNode temp = list.getHead();
			Hashtable<Integer,ListNode> linkedListTable = new Hashtable<Integer, ListNode>();
			int i = 1;
			linkedListTable.put(0, temp);
			while(temp.getNext() != null){
				linkedListTable.put(i, temp.getNext());
				temp = temp.getNext();
				i++;
			}
			int requiredKey = length - position;
			System.out.println("req key " + requiredKey);
			ListNode node = linkedListTable.get(requiredKey);
			return node.getData();
		}
	}
	
public static int getPositionFromLast( LinkedList list, int n) {
		
		ListNode temp = list.getHead();
		int length = list.getLength();
		if(length < n) {
			return Integer.MIN_VALUE;
		} 
		int elementPos = length - n;
		
		for(int i=0; i< elementPos; i++) {
			temp = temp.getNext();
		}
		return temp.getData();
		
	}
	public static void main(String[] args){
		LinkedList linkedList = LinkedListUtil.getDummylinkedList();
		System.out.println(getPositionFromLastUsingHashTable(linkedList, 9));
		System.out.println(getPositionFromLast(linkedList, 9));
	}
	
}
