package geeksforgeeks.ds.linkedLists.util;

import java.util.Stack;

import geeksforgeeks.ds.linkedLists.impl.ListNode;

/**
 * Provides utility methods for linked list.
 *
 * @author ashijune
 *
 */
public class LinkedListUtil {
  /**
   * Problem-7
   * http://geeksquiz.com/find-length-of-a-linked-list-iterative-and-recursive/
   *
   * Find Length of a Linked List (Iterative and Recursive)
   * Write a C function to count number of nodes in a given singly linked list.
   * For example, the function should return 5 for linked list 1->3->1->2->1.
   * Iterative Solution
   * 1) Initialize count as 0
   * 2) Initialize a node pointer, current = head.
   * 3) Do following while current is not NULL
   *      a) current = current -> next
   *      b) count++;
   * 4) Return count
   *
   * @param head
   * @return
   */
  public static int getLength(ListNode head) {
    int count = 0;
    while(head !=null) {
      head=head.getNext();
      count++;
    }
    return count;
  }
  /**
   * Problem-7
   * http://geeksquiz.com/find-length-of-a-linked-list-iterative-and-recursive/
   *
   * Recursive Solution
   * int getCount(head)
   * 1) If head is NULL, return 0.
   * 2) Else return 1 + getCount(head->next)
   *
   * @param head
   * @return
   */

  public static int getLengthRecursive(ListNode head) {
    if(head ==null) {
      return 0;
    }
    return 1+getLengthRecursive(head.getNext());
  }
  /**
   * Problem-8
   *
   * http://geeksquiz.com/search-an-element-in-a-linked-list-iterative-and-recursive/
   *
   * Write a C function that searches a given key ‘x’ in a given singly linked list. The function should return true if x is present in linked list and false otherwise.
   * bool search(Node *head, int x)
   * For example, if the key to be searched is 15 and linked list is 14->21->11->30->10, then function should return false. If key to be searched is 14, then the function should return true.
   * Iterative Solution
   *    2) Initialize a node pointer, current = head.
   *    3) Do following while current is not NULL
   *        a) current->key is equal to the key being searched return true.
   *        b) current = current->next
   *    4) Return false
   * @param head
   * @param data
   * @return
   */
  public static boolean searchIterative(ListNode head, int data) {
    while(head!=null) {
      if(head.getData()==data) {
        return true;
      }
      head=head.getNext();
    }
    return false;
  }
/**
 * Problem-8
 * http://geeksquiz.com/search-an-element-in-a-linked-list-iterative-and-recursive/
 *
 * Recursive Solution
 * bool search(head, x)
 * 1) If head is NULL, return false.
 * 2) If head's key is same as x, return true;
 * 3) Else return search(head->next, x)

 * @param head
 * @param data
 * @return
 */
  public static boolean searchRecursive(ListNode head, int data) {
    if(head==null) {
      return false;
    }
    if(head.getData()==data) {
      return true;
    }
    return searchRecursive(head.getNext(), data);
  }

/**
 *
 *
 * @param head
 * @param data
 * @return
 */
  public static int getPosition(ListNode head, int data) {
      if(head==null) {
        return Integer.MIN_VALUE;
      }
      ListNode temp = head;
      int count = 0;
      while(temp !=null && temp.getData()!=data){
        count++;
        temp = temp.getNext();
      }
      return count;
  }
  /**
   * Problem-10
   * http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
   *
   * The idea it to first search x and y in given linked list.
   * If any of them is not present, then return. While searching for x and y, keep track of current and previous pointers.
   * First change next of previous pointers, then change next of current pointers.
   *
   * @param head
   * @param val1
   * @param val2
   */
  public static void swapNodes(ListNode head, int val1, int val2) {
    if(head==null) {
      return;
    }
    ListNode prevVal1=null, prevVal2=null, currVal1=head, currVal2 = head;
    while(currVal1!=null && currVal1.getData()!=val1) {
      prevVal1 = currVal1;
      currVal1 = currVal1.getNext();
    }
    while(currVal2!=null && currVal2.getData()!=val2) {
      prevVal2 = currVal2;
      currVal2 = currVal2.getNext();
    }
    if(prevVal1 == null) {
      head = currVal2;
    } else {
      prevVal1.setNext(currVal2);
    }
    if(prevVal2 == null) {
      head = currVal1;
    } else {
      prevVal2.setNext(currVal1);
    }
    ListNode temp = currVal1.getNext();
    currVal1.setNext(currVal2.getNext());
    currVal2.setNext(temp);
  }

  public static int getDataAtPosition(ListNode head, int index) {
    ListNode temp = head;
    int posCounter=0;
    while(temp!=null && posCounter<index) {
      temp=temp.getNext();
      posCounter++;
    }
    if(temp==null) {
      return Integer.MIN_VALUE;
    }
    return temp.getData();
  }

  public static int getMiddle(ListNode head) {
    ListNode slowPtr = head, fastPtr  = head;
    while(fastPtr!=null && fastPtr.getNext()!=null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
    }
    return slowPtr.getData();
  }

  public static void displayList(ListNode head) {
    if(head==null) {
      System.out.println("List is null");
      return;
    }
    ListNode temp = head;
    while(temp!=null) {
      System.out.print(temp.getData()+" ");
      temp = temp.getNext();
    }
    System.out.println("");
  }

  public static int printNthDataFromLast(ListNode head, int n) {
    int count=0;
    ListNode mainPtr = head;
    ListNode refPtr = head;
    if(refPtr != null) {
      while(count < n) {
        if(refPtr == null) {
          System.out.println(n+" is greater than number of nodes in list");
          return Integer.MIN_VALUE;
        }
        refPtr = refPtr.getNext();
        count++;
      }
    }
    while(refPtr!=null) {
      mainPtr=mainPtr.getNext();
      refPtr=refPtr.getNext();
    }
    return mainPtr.getData();
  }

  public static int numOfOccurences(ListNode head, int data) {
    int count=0;
    ListNode temp = head;
    while(temp != null) {
      if(temp.getData()==data) {
        count++;
      }
      temp = temp.getNext();
    }
    return count;
  }

  public static ListNode reverseIterative(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;
    while(curr!=null) {
      ListNode temp = curr.getNext();
      curr.setNext(prev);
      prev=curr;
      curr = temp;
    }
    head = prev;
    return head;
  }

  public static int findLoop(ListNode head) {
    ListNode slowPtr = head, fastPtr = head;
    while(slowPtr != null && fastPtr !=null && fastPtr.getNext() !=null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      if(slowPtr == fastPtr) {
        System.out.println("Loop founded");
        return 1;
      }
    }
    return 0;
  }
/**
 * Problem-20
 *
 * @param head
 * @param data
 */
public static void insertSortedNode(ListNode head, int data) {
  ListNode temp = head;

  if(head == null || head.getData() > data ) {
    ListNode newNode = new ListNode(data);
    newNode.setNext(head);
    head = newNode;
  }  else {
    while(temp!=null && temp.getData()<=data) {
      temp = temp.getNext();
    }
    ListNode newNode = new ListNode(data);
    newNode.setNext(temp.getNext());
    temp.setNext(newNode);
  }
}

/**
 * Problem-21:
 * http://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
 *
 * A simple solution is to traverse the linked list until you find the node you want to delete. But this solution requires pointer to the head node which contradicts the problem statement.
 * Fast solution is to copy the data from the next node to the node to be deleted and delete the next node. Something like following.
    struct node *temp  = node_ptr->next;
    node_ptr->data  = temp->data;
    node_ptr->next  = temp->next;
    free(temp);
 * @param node
 */
public static void deleteNode(ListNode node) {
  ListNode temp = node.getNext();
  node.setData(temp.getData());
  node.setNext(temp.getNext());
  temp.setNext(null);
}
/**
 * Problem-22:
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * Checking palindrome Using Stack
 *
 * @param head
 * @return
 */
public static boolean checkIfPalindromeUsingStack(ListNode head) {
  ListNode temp = head;
  Stack<ListNode> stack = new Stack<ListNode>();
  while(temp!=null) {
    stack.push(temp);
    temp = temp.getNext();
  }
  ListNode temp2 = head;
  while(!stack.isEmpty() || temp2!=null) {
    ListNode val1 = stack.pop();
    if(val1.getData()!= temp2.getData()) {
      return false;
    }
  }
  return true;
}
/**
 * Problem-22
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * Checking palindrome using Linked list reverse
 *
 */
public static boolean checkIfPalindromeUsingReverse(ListNode head) {
  ListNode slowPtr = head, fastPtr = head;
  while(slowPtr!=null && fastPtr!=null && fastPtr.getNext()!=null) {
    slowPtr = slowPtr.getNext();
    fastPtr = fastPtr.getNext().getNext();
  }
  ListNode middleNode = slowPtr;
  ListNode reversed2ndHalf = reverseIterative(middleNode.getNext());
  ListNode temp = head;
  ListNode temp2ndHalf = reversed2ndHalf;
  //Do alternate merge of 1st and second halfs.
  while(temp!=slowPtr && temp2ndHalf !=null) {
    if(temp.getData()!=temp2ndHalf.getData()) {
      return false;
    }
    temp = temp.getNext();
    temp2ndHalf = temp2ndHalf.getNext();
  }
  reverseIterative(reversed2ndHalf);
  return true;
}
/**
 * Problem-23
 *
 *http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 *
 * Method 3(Using difference of node counts)
 * 1) Get count of the nodes in first list, let count be c1.
 * 2) Get count of the nodes in second list, let count be c2.
 * 3) Get the difference of counts d = abs(c1 – c2)
 * 4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
 * 5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
 *
 */
public static int getIntersectionPoint(ListNode head1, ListNode head2) {
  ListNode temp1 = head1;
  int count1 = getCount(temp1);

  ListNode temp2 = head2;
  int count2 = getCount(temp2);

  if(count1>count2) {
    int diff = count1-count2;
    return getIntersectionPoint(diff, temp1, temp2);
  } else {
    int diff = count2-count1;
    return getIntersectionPoint(diff, temp2, temp1);
  }

}
private static int getIntersectionPoint(int diff, ListNode temp1, ListNode temp2) {
  ListNode biggerListNode = temp1;
  ListNode smallerListNode = temp2;
  while(diff>0) {
    biggerListNode = biggerListNode.getNext();
  }
  while(smallerListNode!=null && biggerListNode !=null) {
    if(smallerListNode == biggerListNode) {
      return smallerListNode.getData();
    }
    smallerListNode=smallerListNode.getNext();
    biggerListNode= biggerListNode.getNext();
  }
  return -1;
}
private static int getCount(ListNode temp1) {
  int count1=0;
  while(temp1!=null) {
    count1++;
    temp1=temp1.getNext();
  }
  return count1;
}
/**
 * Problem-24:
 * http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
 *
 * @param head
 */
public static void printReverse(ListNode head) {
  if(head==null) {
    return;
  }
  printReverse(head.getNext());
  System.out.print(head.getData()+" ");
}
/**
 * Problem-25
 * http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 *
 * @param head
 */
public static void removeDuplicatesFromSorted(ListNode head) {
  ListNode current = head;
  while(current.getNext()!=null) {
    if(current.getData()==current.getNext().getData()){
      ListNode temp = current.getNext().getNext();
      current.getNext().setNext(null);
      current.setNext(temp);
    } else {
      current=current.getNext();
    }
  }
}
/**
 * Problem-26
 * http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 *
 * METHOD 1 (Using two loops)
 * This is the simple way where two loops are used. Outer loop is used to pick the elements one by one and inner loop compares the picked element with rest of the elements.
 * TIme Complexity: O(n^2)
 *
 * METHOD 2 (Use Sorting)
 * In general, Merge Sort is the best suited sorting algorithm for sorting linked lists efficiently.
 * 1)  Sort the elements using Merge Sort. We will soon be writing a post about sorting a linked list. O(nLogn)
 * 2)  Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List. O(n)
 * Please note that this method doesn’t preserve the original order of elements.
 *
 * METHOD 3 (Use Hashing)
 * We traverse the link list from head to end. For every newly encountered element, we check whether it is in the hash table: if yes, we remove it; otherwise we put it in the hash table.
 * Thanks to bearwang for suggesting this method.
 * Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).
 *
 * @param head
 */
public static void removeDuplicates(ListNode head) {

}
/**
 * Problem-27
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 *
 * @param head
 */
public static void pairWiseSwap(ListNode head) {
  ListNode temp = head;
  while(temp != null && temp.getNext() != null) {
    int data = temp.getData();
    temp.setData(temp.getNext().getData());
    temp.getNext().setData(data);
    temp = temp.getNext().getNext();
  }
}
/**
 * Problem-29
 * http://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
 *
 * @param head
 */
public static void moveLastElemToFront(ListNode head) {
  ListNode prev = null;
  if(head == null || head.getNext()==null) {
    return;
  }
  ListNode temp = head;
  while(temp !=null && temp.getNext()!= null) {
    prev = temp;
    temp= temp.getNext();
  }
  prev.setNext(null);
  temp.setNext(head);
  head = temp;
}
/**
 * Problem-30
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 *
 */
public static void deleteAlternative(ListNode head) {
  if(head == null) {
    return;
  }
  ListNode temp = head;
  while(temp != null && temp.getNext() != null) {
    ListNode toDelete = temp.getNext();
    temp.setNext(toDelete.getNext());
    temp = temp.getNext();
    toDelete = null;
  }
}
/**
 * Problem-31
 * http://www.geeksforgeeks.org/identical-linked-lists/
 *
 * @param head1
 * @param head2
 * @return
 */
public static boolean areIdentical(ListNode head1, ListNode head2) {
ListNode temp1 = head1;
ListNode temp2 = head2;
while(temp1!=null && temp2!=null) {
  if(temp1.getData()!=temp2.getData()) {
    return false;
  }
  temp1 = temp1.getNext();
  temp2 = temp2.getNext();
}
return true;
}

/**
 * Problem-35
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 *
 * 1 2 3 4 5 6
 * 3 2 1 6 5 4
 * @param head
 * @param k
 */
public static void reverse(ListNode head, int k) {
 ListNode current = head;
 ListNode prevCurrent = null;
 ListNode prevTail = null;
 while(current != null) {
   int count =k;
   ListNode tail = null;
   while(current != null && count > 0) {
     ListNode next = current.getNext();
     current.setNext(tail);
     tail = current;
     current = next;
     count--;
   }
 if(prevTail != null) {
  prevTail.setNext(tail);
 } else {
   head = tail;
 }
 prevTail = prevCurrent;
 prevCurrent = current;
 }
}

/**
 * Problem-37
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 *
 * Delete nodes which have a greater value on right side
Given a singly linked list, remove all the nodes which have a greater value on right side.

Examples:
a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. Note that 12, 10, 5 and 2 have been deleted because there is a greater value on the right side.

When we examine 12, we see that after 12 there is one node with value greater than 12 (i.e. 15), so we delete 12.
When we examine 15, we find no node after 15 that has value greater than 15 so we keep this node.
When we go like this, we get 15->6->3

b) The list 10->20->30->40->50->60->NULL should be changed to 60->NULL. Note that 10, 20, 30, 40 and 50 have been deleted because they all have a greater value on the right side.

c) The list 60->50->40->30->20->10->NULL should not be changed.
 *
 * @param head
 */
public static ListNode deleteLesserNodes(ListNode head) {
  ListNode reversed = reverseIterative(head);

  ListNode current = reversed;
  /* Initialise max */
  ListNode maxnode = reversed;
  ListNode temp;

  while (current != null && current.getNext() != null) {
      /* If current is smaller than max, then delete
         current */
      if (current.getNext().getData() < maxnode.getData())
      {
          temp = current.getNext();
          current.setNext(temp.getNext());
          temp = null;
      }

      /* If current is greater than max, then update
         max and move current */
      else
      {
          current = current.getNext();
          maxnode = current;
      }
  }
  return reverseIterative(reversed);
}

/**
 * Problem-38
 *
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * Method 1
The idea is to get pointer to the last node of list. And then traverse the list starting from the head node and move the odd valued nodes from their current position to end of the list.

Thanks to blunderboy for suggesting this method.

Algorithm:
…1) Get pointer to the last node.
…2) Move all the odd nodes to the end.
……..a) Consider all odd nodes before the first even node and move them to end.
……..b) Change the head pointer to point to the first even node.
……..b) Consider all odd nodes after the first even node and move them to the end.
 *
 */
public static void segregateEvenOdd(ListNode head) {
  // Complete this
  ListNode end = head;
  while(end!=null) {
    end = end.getNext();
  }
}

/**
 * Problem-39
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 *
 * Using Floyd Cycling Algo
 * @param head
 */
public static void detectAndRemoveLoop(ListNode head) {
  ListNode slowPtr = head;
  ListNode fastPtr = head;
  while(slowPtr!=null && fastPtr!=null && fastPtr.getNext()!=null) {
    if(slowPtr==fastPtr) {
      removeLoop(slowPtr, head);
      break;
    }
    slowPtr = slowPtr.getNext();
    fastPtr = fastPtr.getNext().getNext();
  }

}
private static void removeLoop(ListNode slowPtr, ListNode head) {
  ListNode ptr1 = head;
  ListNode ptr2 = null;
  while(true) {
    ptr2 = slowPtr;
    while(ptr2.getNext()!=slowPtr && ptr2.getNext()!=ptr1) {
      ptr2 = ptr2.getNext();
    }
    if(ptr2.getNext()==ptr1) {
      break;
    }
    ptr1 = ptr1.getNext();
  }
  ptr2.setNext(null);
}
/**
 * Problem-40
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 *
 * Add two numbers represented by linked lists | Set 1
Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.

Example 1

Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613
Example 2

Input:
  First List: 7->5->9->4->6  // represents number 64957
  Second List: 8->4 //  represents number 48
Output
  Resultant list: 5->0->0->5->6  // represents number 65005
Solution
Traverse both lists. One by one pick nodes of both lists and add the values.
If sum is more than 10 then make carry as 1 and reduce sum.
If one list has more elements than the other then consider remaining values of this list as 0.
Following is the implementation of this approach.
 * @param head1
 * @param head2
 */
public static ListNode sumLists(ListNode head1, ListNode head2) {
  ListNode temp1 = head1;
  ListNode temp2 = head2;
  ListNode res=null; // head of resultant list.
  ListNode prev = null;
  ListNode temp = null;
  int sum = 0;
  int carry = 0;
  while(temp1!=null && temp2 !=null) {
    sum = carry+ (temp1!=null? temp1.getData():0)+ (temp2!=null? temp2.getData():0);
    carry= (sum>=10)?1:0;
    if(sum>=10) {
      sum=sum%10;
    }
    temp = new ListNode(sum);
    if(res==null) {
      res=temp;
    } else {
      prev.setNext(temp);
    }
    prev = temp;
    if(temp1!=null) {
      temp1 = temp1.getNext();
    }
    if(temp2!=null) {
      temp2 = temp2.getNext();
    }
  }
  if(carry>0) {
    temp.setNext(new ListNode(carry));
  }
  return res;
}

/**
 * Problem-44
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 *
 * Rotate a Linked List
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
 * Where k is a given positive integer. For example, if the given linked list is 10->20->30->40->50->60 and k is 4,
 * the list should be modified to 50->60->10->20->30->40.
 * Assume that k is smaller than the count of nodes in linked list.
 *
 * @param k
 */
public static ListNode rotateList(ListNode head, int k) {
  if(k==0) {
    return head;
  }
  ListNode temp = head;
  int count = 1;
  while(temp !=null && count<k) {
    temp = temp.getNext();
    count++;
  }

  ListNode kthNode = temp;
  ListNode nextToKthNode = temp.getNext();

  while(temp.getNext()!=null) {
    temp = temp.getNext();
  }
  temp.setNext(head);
  head=nextToKthNode;
  kthNode.setNext(null);
  return head;
}

/**
 * Problem-60
 * http://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
 *
 * Rearrange a given linked list in-place.
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …

Efficient Solution:

1) Find the middle point using tortoise and hare method.
2) Split the linked list in two halves using found middle point in step 1.
3) Reverse the second half.
4) Do alternate merge of first and second halves.
Time Complexity of this solution is O(n).

 * @param head
 * @return
 */
public static ListNode rearrange(ListNode head) {
  ListNode slowPtr = head, fastPtr = head;
  while(slowPtr!=null && fastPtr!=null && fastPtr.getNext()!=null) {
    slowPtr = slowPtr.getNext();
    fastPtr = fastPtr.getNext().getNext();
  }
  ListNode middleNode = slowPtr;
  ListNode reversed2ndHalf = reverseIterative(middleNode.getNext());
  ListNode temp = head;

  //Do alternate merge of 1st and second halfs.
  while(temp!=slowPtr) {
    ListNode temp2 = reversed2ndHalf;
    ListNode next1 = temp.getNext();
    temp.setNext(temp2);
    temp2.setNext(next1);
    temp = next1;
    reversed2ndHalf = reversed2ndHalf.getNext();
  }
  middleNode.setNext(null);
  return head;
}
}
