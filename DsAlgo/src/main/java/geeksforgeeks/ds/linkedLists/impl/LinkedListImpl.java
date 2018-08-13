package geeksforgeeks.ds.linkedLists.impl;

public class LinkedListImpl implements LinkedList {
  ListNode head;
  /**
   *
   * Inserts data at beg of linked list.
   * @param data
   */
  public void insertAtBeginning(int data) {
    if(head==null) {
      head = new ListNode(data);
      return;
    }
    ListNode new_node = new ListNode(data);
    new_node.next=head;
     head=new_node;
  }
  public ListNode getHead() {
    return head;
  }
  public void insertAtPosition(int data, int position) {
    if(position < 0) {
      position =0;
    }
    if(position == 0 && head==null) {
      ListNode new_node = new ListNode(data);
      head = new_node;
    } else {
      ListNode temp = head;
      for(int i=0; i< position-1 && temp!=null; i++) {
        temp = temp.getNext();
      }
      ListNode new_node = new ListNode(data);
      new_node.next=temp.next;
      temp.next=new_node;
    }
  }
  /**
   * Inserts node at end.
   * @param data
   */
  public void append(int data) {
    ListNode temp = head;
    while(temp.next !=null) {
      temp = temp.next;
    }
    ListNode new_node = new ListNode(data);
    temp.next=new_node;
  }
  /**
   * Deleting a given key.
   * @param data
   */
  public void delete(int data) {
    ListNode temp = head;
    ListNode prev = null;
    while(temp != null && temp.data!=data) {
      prev=temp;
      temp = temp.next;
    }
    if(temp==null) {
      return;
    }
    prev.next= temp.next;
    temp = null;
  }
  /**
   * Deleting a data at given position
   */
  public int deleteAtPosition(int position) {
    if(position < 0 || position ==0) {
      ListNode temp = head;
      head=null;
      return temp.data;
    }
    ListNode prev = head;
    ListNode curr = head.next;
    for(int i=1; i<position-1;i++) {
      prev=curr;
      curr=curr.next;
    }
    prev.next=curr.next;
    ListNode temp = curr;
    curr = null;
    return temp.data;

  }
}
