package ds.chapter05queue.problems;

import java.util.Stack;

import ds.chapter05queue.implementation.LinkedQueue;

public class Problem001QueueReversal {
	public LinkedQueue reverseQueue(LinkedQueue  queue) throws Exception{
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty()){
			stack.push(queue.dequeue());
		}
		
		while(!stack.isEmpty()){
			queue.enquque(stack.pop());
		}
		return queue;
	}
	
	
	public static void main(String[] args) throws Exception{
		Problem001QueueReversal queueReversal = new Problem001QueueReversal();
		LinkedQueue queue = new LinkedQueue();
		for(int i=1; i<6; i++){
			queue.enquque(i);
		}
		System.out.println(queue.toString());
		queueReversal.reverseQueue(queue);
		System.out.println(queue.toString());
	}
}
