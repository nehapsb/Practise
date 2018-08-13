package ds.chapter06trees.binarytrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

public class PreOrderTraversal {

	public ArrayList<Integer> preOrder(BinaryTreeNode root){
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if(root == null){
			return nodes;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode tmp = stack.pop();
			nodes.add(tmp.getData());
			if(tmp.getRight() != null){
				stack.push(tmp.getRight());
			}
			if(tmp.getLeft() != null){
				stack.push(tmp.getLeft());
			}
		}
		return nodes;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		PreOrderTraversal orderTraversal = new PreOrderTraversal();
		List<Integer> nodes = orderTraversal.preOrder(root);
		System.out.println("nodes "+ nodes);
		
	}

}
