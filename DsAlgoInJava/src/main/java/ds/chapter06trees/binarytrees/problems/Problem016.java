package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem016 {

	public int numberOfLeavesInTree(BinaryTreeNode root) {
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
				if(current.getLeft() == null && current.getRight() == null){
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
		Problem016 problem016 = new Problem016();
		System.out.println("no of leaves " +problem016.numberOfLeavesInTree(root));
	}
}
