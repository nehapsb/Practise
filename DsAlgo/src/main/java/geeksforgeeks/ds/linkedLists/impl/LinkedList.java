package geeksforgeeks.ds.linkedLists.impl;



public interface LinkedList {
  public void insertAtBeginning(int data);
  public void insertAtPosition(int data, int position);
  public void append(int data);
  public void delete(int data);
  public int deleteAtPosition(int position);
  public ListNode getHead();
}
