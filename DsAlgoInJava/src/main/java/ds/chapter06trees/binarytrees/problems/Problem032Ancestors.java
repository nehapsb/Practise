package ds.chapter06trees.binarytrees.problems;

import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem032Ancestors {

	public static boolean printAllAncestors(BinaryTreeNode root, int data){
		if(root == null){
			return false;
		}
		if(root.getData() == data){
			return true;
		}
		
		if(printAllAncestors(root.getLeft(), data) || printAllAncestors(root.getRight(), data)){
			System.out.println(root.getData() + " ");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
	//	Problem032Ancestors.printAllAncestors(root, 6);
		Problem032Ancestors.printAllAncestorsIteratively(root, 7);
	}
	
	public static void printAllAncestorsIteratively(BinaryTreeNode root, int data){
		if(root == null){
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(true){
			while(root != null && root.getData() != data){
				stack.push(root);
				root =  root.getLeft();
			}
			if(root != null && root.getData() == data){
				break;
			}
			if(stack.isEmpty()){
				System.out.println("not a tree element");
				break;
			}
			BinaryTreeNode current = stack.peek();
			if(current.getRight() == null){
				root = stack.pop();
				while(!stack.isEmpty() && stack.peek().getRight() == root){
					root = stack.pop();
				}
			}
			root = stack.isEmpty()? null: stack.peek().getRight();
			
			/*while(root != null && root.getData() != data){
				stack.push(root);
				root = root.getRight();
			}
			if(root != null && root.getData() == data){
				break;
			}*/
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().getData());
		}
	}
	
}
