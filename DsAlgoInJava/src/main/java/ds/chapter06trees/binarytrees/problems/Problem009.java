package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem009 {

	public void reverseLevelOrderTraversal(BinaryTreeNode root){
		if(root == null){
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			
			if(current.getRight() != null){
				queue.offer(current.getRight());
			}
			if(current.getLeft() != null){
				queue.offer(current.getLeft());
			}
			stack.push(current);
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getData() + " ");
		}
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem009 problem009 = new Problem009();
		problem009.reverseLevelOrderTraversal(root);
	}
}
