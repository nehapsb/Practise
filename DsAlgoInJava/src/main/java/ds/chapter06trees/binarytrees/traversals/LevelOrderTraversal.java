package ds.chapter06trees.binarytrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.problems.TreeUtil;


public class LevelOrderTraversal {

	public ArrayList<Integer> levelOrder(BinaryTreeNode root) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if(root == null) {
			return nodes;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			if(current != null){
				nodes.add(current.getData());
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
			}
		}
		return nodes;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
		List<Integer> nodes = levelOrderTraversal.levelOrder(root);
		System.out.println("nodes "+ nodes);
		
	}
	
}
