package ds.chapter03linkedlist.problems;

import ds.chapter03linkedlist.singlylinkedlist.LinkedList;
import ds.chapter03linkedlist.singlylinkedlist.ListNode;

public class Problem024 {

	public static ListNode findInterSectingNode(ListNode head1, ListNode head2){
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		int length1 = 0, length2 = 0, diff=0;
		while(temp1 != null){
			temp1 = temp1.getNext();
			length1++;
		}
		while(temp2 != null){
			temp2 = temp2.getNext();
			length2++;
		}
		//int d = (length1 > length2) ?(length1-length2) : (length2 - length1);
		if(length1>length2) {
			temp1=head1;
			temp2=head2;
			diff = length1-length2;
		} else {
			temp1=head2;
			temp2=head1;
			diff=length2-length1;
		}
		
		for(int i =0; i<diff; i++){
			temp1 = temp1.getNext();
		}
			while(temp1 != null && temp2 !=null){
				if(temp1 == temp2){
					return temp1;
				}
				temp1 = temp1.getNext();
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
		LinkedListUtil.displayLinkedList(list2.getHead());
		ListNode intersectingNode = findInterSectingNode(list1.getHead(), list2.getHead());
		System.out.println("intersectingNode " + intersectingNode.getData());
	}
}
