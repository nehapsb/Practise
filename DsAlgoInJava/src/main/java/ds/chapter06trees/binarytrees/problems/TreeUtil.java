package ds.chapter06trees.binarytrees.problems;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class TreeUtil {

	public static BinaryTreeNode createBinaryTree() {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode leftTree = new BinaryTreeNode(2);
		root.setLeft(leftTree);
		BinaryTreeNode rightTree = new BinaryTreeNode(3);
		root.setRight(rightTree);
		BinaryTreeNode leftSub1 = new BinaryTreeNode(4);
		leftTree.setLeft(leftSub1);
		BinaryTreeNode leftSub2 = new BinaryTreeNode(5);
		leftTree.setRight(leftSub2);
		BinaryTreeNode rightSub1 = new BinaryTreeNode(6);
		rightTree.setLeft(rightSub1);
		BinaryTreeNode rightSub2 = new BinaryTreeNode(7);
		rightTree.setRight(rightSub2);
		/*BinaryTreeNode rightsub3 = new BinaryTreeNode(8);
		rightSub2.setLeft(rightsub3);*/
		return root;
	}
	
/*	public static BinarySearchTreeNode createBinarySearchTree() {
		BinarySearchTreeNode root = new BinarySearchTreeNode(2);
		BinarySearchTreeNode leftTree = new BinarySearchTreeNode(1);
		root.setLeft(leftTree);
		BinarySearchTreeNode rightTree = new BinarySearchTreeNode(3);
		root.setRight(rightTree);
		BinarySearchTreeNode leftSub1 = new BinarySearchTreeNode(4);
		leftTree.setLeft(leftSub1);
		BinarySearchTreeNode leftSub2 = new BinarySearchTreeNode(9);
		leftTree.setRight(leftSub2);
		BinarySearchTreeNode rightSub1 = new BinarySearchTreeNode(6);
		rightTree.setLeft(rightSub1);
		BinarySearchTreeNode rightSub2 = new BinarySearchTreeNode(7);
		rightTree.setRight(rightSub2);
		BinaryTreeNode rightsub3 = new BinaryTreeNode(8);
		rightSub2.setLeft(rightsub3);
		return root;
	}*/
	
	public static BinarySearchTreeNode createBinarySearchTree() {
		BinarySearchTreeNode root = new BinarySearchTreeNode(6);
		BinarySearchTreeNode leftTree = new BinarySearchTreeNode(3);
		root.setLeft(leftTree);
		BinarySearchTreeNode rightTree = new BinarySearchTreeNode(8);
		root.setRight(rightTree);
		BinarySearchTreeNode leftSub1 = new BinarySearchTreeNode(2);
		leftTree.setLeft(leftSub1);
		BinarySearchTreeNode leftSub2 = new BinarySearchTreeNode(4);
		leftTree.setRight(leftSub2);
		BinarySearchTreeNode rightSub1 = new BinarySearchTreeNode(9);
		rightTree.setLeft(rightSub1);
		BinarySearchTreeNode rightSub2 = new BinarySearchTreeNode(10);
		rightTree.setRight(rightSub2);
//		BinaryTreeNode rightsub3 = new BinaryTreeNode(8);
//		rightSub2.setLeft(rightsub3);
		return root;
	}
}
