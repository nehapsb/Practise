package ds.chapter04stack.problems;

import java.util.Stack;

public class Problem011StackReversal {

	public void reverseStack(Stack<Integer> integerStack){
		if(integerStack.isEmpty()){
			return;
		}
		int data = integerStack.pop();
		reverseStack(integerStack);
		insertAtBottom(integerStack, data);
	}

	private void insertAtBottom(Stack<Integer> integerStack, int data) {
		if(integerStack.isEmpty()){
			integerStack.push(data);
			return;
		}
		int temp = integerStack.pop();
		insertAtBottom(integerStack, data);
		integerStack.push(temp);
	}
	
	public static void main(String[] args){
		Stack<Integer> integerStack = new Stack<Integer>();
		integerStack.push(1);
		integerStack.push(2);
		integerStack.push(3);
		integerStack.push(4);
		displayStackElems(integerStack);
		Problem011StackReversal reverseStack = new Problem011StackReversal();
		reverseStack.reverseStack(integerStack);
		displayStackElems(integerStack);
	}
	public static void displayStackElems(Stack stack) {
		Stack copyStack = new Stack();
		copyStack.addAll(stack);
		System.out.print("[ "+copyStack.pop());
		while(!copyStack.isEmpty()) {
			System.out.print(", "+copyStack.pop());
		}
		System.out.print(" ]");
		System.out.println("");
	}
}
