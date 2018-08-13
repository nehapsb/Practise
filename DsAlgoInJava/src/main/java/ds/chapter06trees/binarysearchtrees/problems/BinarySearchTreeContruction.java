package ds.chapter06trees.binarysearchtrees.problems;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;

public class BinarySearchTreeContruction {
	public int index = 0;

	public BinarySearchTreeNode contructBSTFromPreorderTraversal(int[] preorder, int data, int min, int max){
		int size = preorder.length;
		
		/*if(size == 1){
			return root;
		}*/
		if(index < size){
			if(preorder[index] > min && preorder[index] < max){
				BinarySearchTreeNode root = new BinarySearchTreeNode(data);
				index++;
				//System.out.println("root " + root.getData() + " index " + index);
				if(index < size){
					root.setLeft(contructBSTFromPreorderTraversal(preorder,preorder[index] , min, data));
					root.setRight(contructBSTFromPreorderTraversal(preorder, preorder[index], data, max));
				}
				return root;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		int[] preorder = new int[]{10,4,5,8,15,20};
		BinarySearchTreeContruction binarySearchTreeContruction = new BinarySearchTreeContruction();
		BinarySearchTreeNode root = binarySearchTreeContruction.contructBSTFromPreorderTraversal(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		binarySearchTreeContruction.displayTree(root);
	}
	
	public void displayTree(BinarySearchTreeNode root) {
		if (root != null) {
			displayTree(root.getLeft());
			System.out.print(" " + root.getData());
			displayTree(root.getRight());
		}
	}
}
