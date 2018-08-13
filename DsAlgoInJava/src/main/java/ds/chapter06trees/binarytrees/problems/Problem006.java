package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem006 {

	public int size(BinaryTreeNode root){
		int count = 0;
		if(root == null){
			return count;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			count ++;
			
			if(current.getLeft() != null){
				queue.offer(current.getLeft());
			}
			if(current.getRight() != null){
				queue.offer(current.getRight());
			}
				
		}
		return count;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem006 problem006 = new Problem006();
		int size = problem006.size(root);
		System.out.println("size " + size);
	}
}
