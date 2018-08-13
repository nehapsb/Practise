package ds.chapter05queue.problems;

import java.util.Stack;

public class Problem002QueueWithTwoStacks {

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public void enqueue(int data){
		stack1.push(data);
	}
	
	public int dequeue(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
