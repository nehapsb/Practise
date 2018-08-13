package ds.chapter06trees.binarysearchtrees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.problems.Problem002MaxElement;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

public class Problem055BST {

	public boolean isBST(BinarySearchTreeNode root){
		if(root == null){
			return false;
		}
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinarySearchTreeNode current = queue.poll();
			Problem002MaxElement element = new Problem002MaxElement();
			if(current != null){
				if(current.getLeft() != null){
					//System.out.println("max " + element.findMaxElementInBinarySearchTree(current.getLeft()));
					if(element.findMaxElementInBinarySearchTree(current.getLeft()) > current.getData())
						return false;
					else
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					//System.out.println("min " + element.findMinElementInBinarySearchTree(current.getRight()));
					if(element.findMinElementInBinarySearchTree(current.getRight()) < current.getData())
						return false;
					else
					queue.offer(current.getRight());
				}
			}
				
		}
		return true;
		
	}
	
	public boolean checkIsBSTRecursively(BinarySearchTreeNode root){
		if(root == null){
			return false;
		}
		if(root.getLeft() != null && root.getLeft().getData() > root.getData()){
			return false;
		}
		
		if(root.getRight() != null && root.getRight().getData() < root.getData()){
			return false;
		}
		if(!isBST(root.getLeft()) || !isBST(root.getRight())){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int[] preorder = new int[]{10,4,5,8,15,20};
		BinarySearchTreeNode root = new BinarySearchTreeContruction().contructBSTFromPreorderTraversal(preorder , preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		Problem055BST problem055bst = new Problem055BST();
		BinarySearchTreeNode root1 = TreeUtil.createBinarySearchTree();
		System.out.println("is bst root1 : " +problem055bst.isBST(root));
		System.out.println("is BST root2: " + problem055bst.isBST(root1));
		System.out.println("is BST check recursively root1: " + problem055bst.checkIsBSTRecursively(root));
		System.out.println("is BST check recursively root2: " + problem055bst.checkIsBSTRecursively(root1));
	}
}

