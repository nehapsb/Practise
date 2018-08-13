package geeksforgeeks.ds.stack.impl;


public class StackNode {
  /**
   * Holds the head of list
   * @author ashi
   *
   */
      private Object data;
      private StackNode next;
      public StackNode(Object data) {
          this.data=data;
      }
      public Object getData() {
          return data;
      }
      public void setData(Object data) {
          this.data = data;
      }
      public StackNode getNext() {
          return this.next;
      }
      public void setNext(StackNode next) {
          this.next = next;
      }


}
