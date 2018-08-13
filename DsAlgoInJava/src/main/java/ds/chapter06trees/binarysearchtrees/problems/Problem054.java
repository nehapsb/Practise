package ds.chapter06trees.binarysearchtrees.problems;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;

public class Problem054 {

	public BinarySearchTreeNode findLCA(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b){
		
		if(root == null){
			return root;
		}
		if(root == a || root == b ){
			return root;
		}
		if(Math.max(a.getData(), b.getData()) < root.getData()){
			return findLCA(root.getLeft(), a, b);
		}else if(Math.min(a.getData(), b.getData()) > root.getData()){
			return findLCA(root.getRight(), a, b);
		}else{
			return root;
		}
	}
	
	public static void main(String[] args){
		int[] preorder = new int[]{10,5,8,15,20,4};
		BinarySearchTreeContruction binarySearchTreeContruction = new BinarySearchTreeContruction();
		BinarySearchTreeNode root = binarySearchTreeContruction.contructBSTFromPreorderTraversal(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		BinarySearchTreeNode lca = new Problem054().findLCA(root, new BinarySearchTreeNode(8), new BinarySearchTreeNode(5));
		System.out.println(lca.getData());
		
	}
}
