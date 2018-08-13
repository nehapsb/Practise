package ds.chapter05queue.problems;

import java.util.*;

public class Problem010 {

	public void reverserQueueFirstKElements(Queue<Integer> queue, int k){
		int length = queue.size();
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		while(i<k){
			stack.push(queue.remove());
			i++;
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		for(int x=0; x<length-k; x++){
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
		System.out.println(queue.toString());
		
		Problem010 problem010 = new Problem010();
		problem010.reverserQueueFirstKElements(queue, 2);
		System.out.println(queue.toString());
	}
}
