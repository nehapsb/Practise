package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem004Search {

	public boolean findInBinaryTreeLevelOrder(BinaryTreeNode root, int data){
		if(root == null){
			return false;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			if(data == current.getData()){
				return true;
			}
			if(current != null){
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		Problem004Search problem004Search = new Problem004Search();
		System.out.println("find iteratively" + problem004Search.findInBinaryTreeLevelOrder(root, 6));
		System.out.println("find recursively " + problem004Search.findInBinaryTreeRecursively(root, 6));
		
	}
	
	public boolean findInBinaryTreeRecursively(BinaryTreeNode root, int data){
		if(root==null) {
			return false;
		}
		System.out.println("root.getData " + root.getData());
		if(root.getData() == data){
			return true;
		}
		
		return findInBinaryTreeRecursively(root.getLeft(), data) || findInBinaryTreeRecursively(root.getRight(), data);
	}
}
