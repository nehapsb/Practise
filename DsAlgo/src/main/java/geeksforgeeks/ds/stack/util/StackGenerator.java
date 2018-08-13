package geeksforgeeks.ds.stack.util;

import geeksforgeeks.ds.stack.impl.Stack;
import geeksforgeeks.ds.stack.impl.StackImpl;

public class StackGenerator {
  public static Stack getDummyStack(int size, int data) {
    Stack s = new StackImpl();
    for(int i=0; i< size; i++) {
      s.push(data++);
    }
    return s;
  }
}
