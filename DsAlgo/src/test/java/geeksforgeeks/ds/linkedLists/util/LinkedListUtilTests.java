package geeksforgeeks.ds.linkedLists.util;

import org.junit.Test;

import geeksforgeeks.ds.linkedLists.impl.LinkedList;
import geeksforgeeks.ds.linkedLists.impl.LinkedListImpl;
import geeksforgeeks.ds.linkedLists.impl.ListNode;
import junit.framework.Assert;

public class LinkedListUtilTests {

//  @Test
  public void testGetLength() {

  }

//  @Test
  public void testGetLengthRecursive() {

  }

//  @Test
  public void testSearchIterative() {
  }

  //  @Test
  public void testSearchRecursive() {
  }

  @Test
  public void testSwapNodes() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    int val1 = 44;
    int val2 = 48;

    int pos1 = LinkedListUtil.getPosition(list.getHead(), val1);
    int pos2 = LinkedListUtil.getPosition(list.getHead(), val2);
    System.out.println("Before swap: pos1 44: "+pos1+" pos2 48:"+pos2);

    LinkedListUtil.swapNodes(list.getHead(), val1, val2);

    int pos1Changed = LinkedListUtil.getPosition(list.getHead(), val1);
    int pos2Changed = LinkedListUtil.getPosition(list.getHead(), val2);
    System.out.println("After Sqap: pos1 44: "+pos1Changed+" pos2 48:"+pos2Changed);

  }
  @Test
  public void testGetDataAtPosition() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    Assert.assertEquals(44,LinkedListUtil.getDataAtPosition(list.getHead(), 4));
  }

  @Test
  public void testGetMiddle() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    Assert.assertEquals(45,LinkedListUtil.getMiddle(list.getHead()));

  }

  @Test
  public void testPrintNthDataFromLast() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    System.out.println(LinkedListUtil.printNthDataFromLast(list.getHead(), 4));
    LinkedListUtil.displayList(list.getHead());
  }

  @Test
  public void testReverseIterative() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    LinkedListUtil.displayList(list.getHead());
    ListNode reversed = LinkedListUtil.reverseIterative(list.getHead());
    System.out.println("");
    LinkedListUtil.displayList(reversed);
  }

  @Test
  public void testDeleteLesserNodes() {
    //LinkedList list = LinkedListGenerator.getDummyLinkedList(10, 40);
    LinkedList list = new LinkedListImpl();
    list.insertAtPosition(12, 0);
    list.insertAtPosition(15, 1);
    list.insertAtPosition(10, 2);
    list.insertAtPosition(17, 3);
    list.insertAtPosition(5, 4);
    list.insertAtPosition(6, 5);
    list.insertAtPosition(2, 6);
    list.insertAtPosition(3, 7);

    ListNode changedList = LinkedListUtil.deleteLesserNodes(list.getHead());
    LinkedListUtil.displayList(changedList);
  }

  @Test
  public void testSumLists() {
    LinkedList l1= new LinkedListImpl();
    l1.insertAtPosition(5, 0);
    l1.insertAtPosition(6, 1);
    l1.insertAtPosition(3, 2);

    LinkedList l2= new LinkedListImpl();
    l2.insertAtPosition(8, 0);
    l2.insertAtPosition(4, 1);
    l2.insertAtPosition(2, 2);

    ListNode l3 = LinkedListUtil.sumLists(l1.getHead(), l2.getHead());
    LinkedListUtil.displayList(l3);

  }

  @Test
  public void testRotateList() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(6, 10);
    LinkedListUtil.displayList(list.getHead());
    ListNode rotatedListHead = LinkedListUtil.rotateList(list.getHead(), 4);

    LinkedListUtil.displayList(rotatedListHead);
  }

  @Test
  public void testRearrange() {
    LinkedList list = LinkedListGenerator.getDummyLinkedList(6, 10);
    LinkedListUtil.displayList(list.getHead());
    ListNode rearrangedHead = LinkedListUtil.rearrange(list.getHead());
    LinkedListUtil.displayList(rearrangedHead);

  }
}
