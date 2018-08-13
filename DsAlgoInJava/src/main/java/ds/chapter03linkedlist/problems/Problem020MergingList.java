package ds.chapter03linkedlist.problems;

import java.util.HashSet;
import java.util.Set;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

/**
 * Problem-20: Can we solve Problem-18 using hashing?
 * Solution: Yes, 
 * Algorithm
 * a) Select a list which have less number of nodes (or select list randomly incase 
 * 	  length is not known).
 * b) Now, traverse the other list and for each node ptr of this list check whether
 * 	  the same entry exists in hashtable.
 * c) If there is a merger ptr for given lists, then we will definately encounter
 * 	  the node ptr in hash table.
 * 
 * Time Complexity: Time for creating hash table + Time for scanning the
 * 					second list=O(m)+O(n)(or O(n)+O(m), depends on which list we 
 * 					select for hashtable.)
 * Space Complexity: O(n) or O(m)
 * 					 	
 * 
 * @author ashi
 *
 */
public class Problem020MergingList {
	public static ListNode findInterSectingNode(ListNode head1, ListNode head2){
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		Set<ListNode> addressList = new HashSet<ListNode>();
		while(temp1 != null){
			addressList.add(temp1);
			temp1 = temp1.getNext();
		}
		//ListNode
		while(temp2 != null){
			if(addressList.contains(temp2)){
				return temp2;
			}
		temp2 = temp2.getNext();
		}
		return null;
		
	}
	
	public static void main(String[] args){
		LinkedList list1 = LinkedListUtil.getDummylinkedList(10);
		LinkedList list2 = LinkedListUtil.getDummylinkedList(5);
		
		ListNode list1Node = list1.getNode(3);
		ListNode list2Node = list2.getNode(4);
		list2Node.setNext(list1Node);
		ListNode intersectingNode = findInterSectingNode(list1.getHead(), list2.getHead());
		System.out.println("intersectingNode " + intersectingNode.getData());
	}
}
