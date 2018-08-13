package ds.chapter06trees.binarytrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

/**
 * 1) Create an empty stack S.
   2) Initialize current node as root
   3) Push the current node to S and set current = current->left until current is NULL
   4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
   5) If current is NULL and stack is empty then we are done.
 */

public class InOrderTraversal {

	public ArrayList<Integer> inOrder(BinaryTreeNode root){
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		boolean isDone = false;
		if(root == null){
			return nodes;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
		while(!isDone){
			if(current!= null){
				stack.push(current);
				current = current.getLeft();
			}
			else{
				if(stack.isEmpty()){
					isDone = true;
				}
				else{
					current = stack.pop();
					nodes.add(current.getData());
					current = current.getRight();
				}
			}
		}
		return nodes;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		List<Integer> nodes = inOrderTraversal.inOrder(root);
		System.out.println("nodes "+ nodes);
		
	}

}
