package ds.chapter05queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem009 {
	
	public void interLeavingQueue(Queue<Integer> queue){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i<queue.size()/2; i++){
			stack.push(queue.remove());
		}
		System.out.println(stack.toString());
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		for(int i=0; i<queue.size()/2; i++){
			queue.add(queue.remove());
		}
		for(int i = 0; i<queue.size()/2; i++){
		stack.push(queue.remove());
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
			queue.add(queue.remove());
			
		}
		
	}
	

	public static void main(String[] args){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		System.out.println(queue.toString());
		
		Problem009 problem009 = new Problem009();
		problem009.interLeavingQueue(queue);
		System.out.println(queue.toString());
	}
}
