package geeksforgeeks.ds.linkedLists.impl;


public class ListNode {
  ListNode next;
  int data;
  public ListNode() {
    data =0;
    next=null;
  }
  public ListNode(int data) {
    this.data=data;
    this.next=null;
  }
  public ListNode getNext() {
    return next;
  }
  public void setNext(ListNode next) {
    this.next = next;
  }
  public int getData() {
    return data;
  }
  public void setData(int data) {
    this.data = data;
  }
}