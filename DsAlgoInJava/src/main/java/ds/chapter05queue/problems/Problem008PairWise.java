package ds.chapter05queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem008PairWise {
	
	public boolean checkStackPairwiseorder(Stack<Integer> stack){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean pairedOrderwise = true;
		/*while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		while(!queue.isEmpty()){
			stack.push(queue.remove());
		}*/
		
		while(!stack.isEmpty()){
			int n = stack.pop();
			//queue.add(n);
			if(!stack.isEmpty()){
				int m = stack.pop();
				if(Math.abs(n-m) != 1){
					pairedOrderwise = false;
					break;
				}
			}
		}
		
		/*while(!queue.isEmpty()){
			stack.push(queue.remove());
		}*/
		return pairedOrderwise;
	}
	
	public static void main(String[] args){
		Problem008PairWise problem008 = new Problem008PairWise();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(6);
		stack.push(5);
		stack.push(-2);
		stack.push(-3);
		stack.push(11);
		stack.push(12);
		boolean pairedOrder = problem008.checkStackPairwiseorder(stack );
		System.out.println("pairedOrder : " + pairedOrder);
	}
	
	
	
	
	
	
	
	

}
