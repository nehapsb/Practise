package ds.chapter06trees.binarysearchtrees.problems;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;

public class Problem061BSTCreation {

	public BinarySearchTreeNode buildBSTFromSortedArray(int[] array, int left, int right){
		if(left>right){
			return null;
		}
		BinarySearchTreeNode newNode;
		if(left == right){
			newNode = new BinarySearchTreeNode(array[left]);
			newNode.setLeft(null);
			newNode.setRight(null);
		}
		else{
			int mid = left + (right - left)/2;
			newNode = new BinarySearchTreeNode(array[mid]);
			newNode.setLeft(buildBSTFromSortedArray(array, left, mid-1));
			newNode.setRight(buildBSTFromSortedArray(array, mid + 1, right));
		}
		return newNode;
	}
	
	public static void main(String[] args){
		int[] arr = new int[] {1,2,3,4,5,6,7};
		Problem061BSTCreation problem061bstCreation = new Problem061BSTCreation();
		BinarySearchTreeNode root = problem061bstCreation.buildBSTFromSortedArray(arr, 0, arr.length-1);
		System.out.println("root " + root.getData());
		problem061bstCreation.disply(root);
	}
	
	public void disply(BinarySearchTreeNode root){
		System.out.println(root.getData() + " ");
		System.out.println(root.getLeft().getData() + " " + root.getRight().getData());
		System.out.println(root.getLeft().getLeft().getData() + " " + root.getLeft().getRight().getData() + " " +
				root.getRight().getLeft().getData() + " " + root.getRight().getRight().getData() );
	}
}
