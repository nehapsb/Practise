package geeksforgeeks.ds.linkedLists.util;

import geeksforgeeks.ds.linkedLists.impl.LinkedList;
import geeksforgeeks.ds.linkedLists.impl.LinkedListImpl;

public class LinkedListGenerator {

  public static LinkedList getDummyLinkedList(int size, int startData) {
    LinkedList list = new  LinkedListImpl();
    for(int i=0; i<size; i++) {
      list.insertAtPosition(startData++, i);
    }
    return list;
  }
}
