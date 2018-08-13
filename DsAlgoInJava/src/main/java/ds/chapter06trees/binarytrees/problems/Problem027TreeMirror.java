package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.traversals.LevelOrderTraversal;
import ds.chapter06trees.binarytrees.traversals.PreOrderTraversal;

public class Problem027TreeMirror {

	public BinaryTreeNode getMirrorOfBinaryTree(BinaryTreeNode root){
		if(root == null){
			return null;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			BinaryTreeNode prevLeft = null;
			if(node.getLeft() != null && root.getRight() != null){
				queue.offer(node.getLeft());
				prevLeft = node.getLeft();
				node.setLeft(node.getRight());
			}
			if(node.getRight() != null){
				queue.offer(node.getRight());
				node.setRight(prevLeft);
			}
		}
		return root;
	}
	
	public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root){
		BinaryTreeNode temp;
		if(root != null){
			mirrorOfBinaryTree(root.getLeft());
			mirrorOfBinaryTree(root.getRight());
			
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem027TreeMirror treeMirror = new Problem027TreeMirror();
		BinaryTreeNode root1 = treeMirror.getMirrorOfBinaryTree(root);
	//	treeMirror.mirrorOfBinaryTree(root);
		System.out.println(new LevelOrderTraversal().levelOrder(root1));
	}
}
