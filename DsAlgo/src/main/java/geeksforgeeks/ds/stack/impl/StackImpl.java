package geeksforgeeks.ds.stack.impl;

public class StackImpl implements Stack{
  private StackNode top;
  private int length;
  public StackImpl(){
    top = null;
    length=0;
  }
  public void push(Object data) {
    StackNode temp = new StackNode(data);
    temp.setNext(top);
    top=temp;
    length++;
  }

  public Object pop() {
    if(isEmpty()) {
      return null;
    }
    Object result = top.getData();
     top = top.getNext();
     length--;
    return result;
  }

  public Object peek() {
    if(isEmpty()) {
      return null;
    }
    return top.getData();
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return length==0;
  }

//Returns a string representation of stack as a list of elements, with
//the top element at the end. This method runs in O(n) time, where n is
//the size of stack.
public String toString() {
    String s ="[";
    StackNode current = top;
    s+=s+current.getData();
    current = current.getNext();
    while(current != null ) {
        s+= ","+current.getData();
        current = current.getNext();
    }
    return s+"]";
}
}
