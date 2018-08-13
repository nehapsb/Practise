package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem014 {
//return the last node in level order.
	public BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode current = null;
		if(root == null) {
			return null;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			current = queue.poll();
			if(current != null){
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
			}
		}
		return current;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		Problem014 problem014 = new Problem014();
		
		System.out.println("deepest node "+ problem014.deepestNodeInBinaryTree(root).getData());
		
	}
}
