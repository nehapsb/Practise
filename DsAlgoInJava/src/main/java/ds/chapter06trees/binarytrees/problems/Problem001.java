package ds.chapter06trees.binarytrees.problems;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem001 {

	public int findMaxElementInBinaryTreeUsingRecursion(BinaryTreeNode root){
		int maxElement = 0;
		if(root != null){
			int leftMax = findMaxElementInBinaryTreeUsingRecursion(root.getLeft());
			int rightMax = findMaxElementInBinaryTreeUsingRecursion(root.getRight());
			
			if(leftMax > rightMax){
				maxElement = leftMax;
			}
			else{
				maxElement = rightMax;
			}
			if(root.getData() > maxElement){
				maxElement = root.getData();
			}
		}
		return maxElement;
		
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem001 problem001 = new Problem001();
		System.out.println("max element " + problem001.findMaxElementInBinaryTreeUsingRecursion(root));
		
	}
	
}
