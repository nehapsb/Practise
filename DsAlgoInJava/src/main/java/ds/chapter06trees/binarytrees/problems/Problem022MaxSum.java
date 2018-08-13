package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem022MaxSum {

	public int findLevelWithMaxSum(BinaryTreeNode root) {
		int maxSum = root.getData();
		System.out.println("max sum " + maxSum);
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		int nodeCount =1;
			while (!queue.isEmpty()) {
				int count = 0;
				int maxWidthSum = 0;
				
				for (int i = 0; i < nodeCount; i++) {
					BinaryTreeNode node = queue.peek();
					queue.remove();
					if (node.getLeft() != null) {
						queue.add(node.getLeft());
						count++;
						maxWidthSum += node.getLeft().getData();
					}
					if(node.getRight() != null){ 
					  queue.add(node.getRight());
					  count++; 
					  maxWidthSum += node.getRight().getData();
					 }
				}
				System.out.println("node count " + count);
				System.out.println("max width sum " + maxWidthSum);
				nodeCount = count;
				if(maxSum < maxWidthSum){
					maxSum = maxWidthSum;
				}
			}
			return maxSum;

		//}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem022MaxSum maxSum = new Problem022MaxSum();
		System.out.println(maxSum.findLevelWithMaxSum(root));
	}
}
