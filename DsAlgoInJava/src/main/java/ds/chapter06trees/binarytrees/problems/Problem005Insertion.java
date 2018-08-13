package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.traversals.InOrderTraversal;

public class Problem005Insertion {

	public BinaryTreeNode insertInBinaryTree(BinaryTreeNode root, int data){
		if(root==null){
			return new BinaryTreeNode(data);
		}
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			
			if(current != null){
				BinaryTreeNode left = current.getLeft();
				if(left != null){
					queue.offer(left);
				}
				else{
					current.setLeft(new BinaryTreeNode(data));
					return root;
				}
				BinaryTreeNode right = current.getRight();
				if(right != null){
					queue.offer(right);
				}
				else{
					current.setRight(new BinaryTreeNode(data));
					return root;
				}
			}
		}
		return root;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		Problem005Insertion insertion = new Problem005Insertion();
		BinaryTreeNode root1 = insertion.insertInBinaryTree(root, 8);
		
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		List<Integer> nodes = inOrderTraversal.inOrder(root1);
		System.out.println(nodes);
		insertion.insertRecursively(root1, 9);
		List<Integer> nodes2 = inOrderTraversal.inOrder(root1);
		System.out.println(nodes2);
		
	}
	
	public void insertRecursively(BinaryTreeNode root, int data){
		if(root == null){
			root = new BinaryTreeNode(data); 
		}
		else{
		if(root.getLeft() == null){
			root.setLeft(new BinaryTreeNode(data));
		}else{
			insertRecursively(root.getLeft(), data);
		}
		
		if(root.getRight() == null){
			root.setRight(new BinaryTreeNode(data));
		}
		else{
			insertRecursively(root.getRight(), data);
		}
		}
	}
}
