package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.traversals.InOrderTraversal;
import ds.chapter06trees.binarytrees.traversals.LevelOrderTraversal;

/**
 * /**
 * Problem: Give an algo for deleting an elem (assuming data is given) from BT.
 * Solution: The deletion of a node in binary tree can be implemented as:
 * a) Starting at root, find the node which we want to delete.
 * b) Find the deepest node in tree.
 * c) Replace the deepest nodes data with data to be deleted.
 * d) Then delete the deepest node.
 * 
 * @author pasbola
 *
 */
public class Problem015 {

	public BinaryTreeNode deleteNodeFromBinaryTree(BinaryTreeNode root, int data){
		if(root == null){
			return null;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		BinaryTreeNode nodeToBeDeleted = null;
		BinaryTreeNode current = null;
		while(!queue.isEmpty()){
			current = queue.poll();
			
			if(current.getData() == data){
				nodeToBeDeleted = current;
			}
			if(current.getLeft() != null){
				queue.offer(current.getLeft());
			}
			
			if(current.getRight() != null){
				queue.offer(current.getRight());
			}
		}
		System.out.println("node to be deleted " + nodeToBeDeleted.getData());
		System.out.println("deepest node " + current.getData() + " left " + current.getLeft() + " right " + current.getRight());
		nodeToBeDeleted.setData(current.getData());
		//nodeToBeDeleted.setRight(null);
		current.setData(0);
		current = null;
		return root;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem015 problem015 = new Problem015();
		BinaryTreeNode root1 = problem015.deleteNodeFromBinaryTree(root, 2);
		List<Integer> nodes = new LevelOrderTraversal().levelOrder(root1);
		System.out.println(nodes);
	}
		
}
