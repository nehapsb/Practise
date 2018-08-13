package ds.chapter04stack.problems;

import java.util.Stack;

/**
 * Design a stack such that getMinium should be o(1)
 * Problem-7: Can we improve space complexity of Problem-6?
 * 
 * Solution: Yes, The main problem of previous approach is, for each push operation,
 * we are pushing the element on to min stack also. That means, we are pushing the
 * duplicate min elems onto stack.
 * Now, let us chnge algo to improve space complexity. We still have the min stack,
 * but we only pop from it when the value from main stack is equal to the one
 * from min stack.
 * We only push to the min stack when the value being pushed onto main stack is
 * less than or equal to current min value.
 * 
 * @author ashi
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(n) (for min stack). But this algo has much better usage 
 * 					if we rarely get a "new minimum or equal". 
 */

public class Problem007 {
	private Stack<Integer> elementStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int data){
		elementStack.push(data);
		if(minStack.isEmpty() || data <= minStack.peek()){
			minStack.push(data);
		}
		
	}
	
	public int pop(){
		if(elementStack.isEmpty()) return Integer.MIN_VALUE;
		if(elementStack.peek() == minStack.peek()){
			minStack.pop();
		}
		return elementStack.pop();
		
	}

	public int getMinimum(){
		return minStack.peek();
	}
	
	public static void main(String [] args) {
		Problem007 stack = new Problem007();
		stack.push(42);
		stack.push(32);
		stack.push(22);
		stack.push(82);
		stack.push(92);
		stack.push(20);
		stack.push(2);
		stack.push(45);
		stack.push(11);
		stack.push(4);
		System.out.println(stack.getMinimum());
	}
}
