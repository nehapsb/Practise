package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem017 {

	public int numberOfFullNodesInTree(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		BinaryTreeNode current = null;
		int count = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current != null) {
				if(current.getLeft() != null && current.getRight() != null){
					count++;
				}
				if (current.getLeft() != null) {
					queue.offer(current.getLeft());
				}

				if (current.getRight() != null) {
					queue.offer(current.getRight());
				}
			}
		}
		return count;
	}
	
	public int numberOfhalfNodesInTree(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		BinaryTreeNode current = null;
		int count = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current != null) {
				if((current.getLeft() == null && current.getRight() != null) || 
						(current.getLeft() != null && current.getRight() == null)){
					count++;
				}
				if (current.getLeft() != null) {
					queue.offer(current.getLeft());
				}

				if (current.getRight() != null) {
					queue.offer(current.getRight());
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem017 problem017 = new Problem017();
		System.out.println("no of full nodes " +problem017.numberOfFullNodesInTree(root));
		
		System.out.println("no of half nodes " +problem017.numberOfhalfNodesInTree(root));
	}
}
