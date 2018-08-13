package ds.chapter05queue.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem003StackWithTwoQueue {

	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public void push(int data){
		if(!queue2.isEmpty()){
			queue2.offer(data);
		}else{
			queue1.offer(data);
		}
	}
	
	public int pop(){
		int i=0, size;
		if(queue2.isEmpty()){
			size = queue1.size();
			while(i<size-1){
				queue2.offer(queue1.poll());
				i++;
			}
			return queue1.poll();
		}
		else{
			size = queue2.size();
			while(i<size-1){
				queue1.offer(queue2.poll());
				i++;
			}
			return queue2.poll();
		}
	}
}
