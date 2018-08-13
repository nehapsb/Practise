package ds.chapter06trees.binarytrees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem034ZigZagTree {

	public ArrayList<Integer> zigZagLevelOrderTraversal(BinaryTreeNode root) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if (root == null) {
			return nodes;
		}
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> temp;
		boolean isLeftToRight = false;
		stack1.push(root);
		while (!stack1.isEmpty()) {
			BinaryTreeNode node = stack1.pop();
			nodes.add(node.getData());
			if (!isLeftToRight) {
				if (node.getLeft() != null) {
					stack2.push(node.getLeft());
				}
				if (node.getRight() != null) {
					stack2.push(node.getRight());
				}

			} else {
				if (node.getRight() != null) {
					stack2.push(node.getRight());
				}
				if (node.getLeft() != null) {
					stack2.push(node.getLeft());
				}
			}

			if (stack1.isEmpty()) {
				isLeftToRight = !isLeftToRight;
				temp = stack1;
				stack1 = stack2;
				stack2 = temp;
			}

		}
		return nodes;
	}

	public ArrayList<Integer> zigZagLevelOrder(BinaryTreeNode root) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if (root == null) {
			return nodes;
		}
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()){
				BinaryTreeNode node = stack1.pop();
				nodes.add(node.getData());
					if (node.getLeft() != null) {
						stack2.push(node.getLeft());
					}
					if (node.getRight() != null) {
						stack2.push(node.getRight());
					}
			}
			while(!stack2.isEmpty()){
				BinaryTreeNode node = stack2.pop();
				nodes.add(node.getData());
				if (node.getRight() != null) {
					stack1.push(node.getRight());
				}
				if (node.getLeft() != null) {
					stack1.push(node.getLeft());
				}
			}
			
		}
		return nodes;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem034ZigZagTree zigZagTree = new Problem034ZigZagTree();
		System.out.println(zigZagTree.zigZagLevelOrderTraversal(root));
		System.out.println("2nd way " + zigZagTree.zigZagLevelOrder(root));
	}
}
