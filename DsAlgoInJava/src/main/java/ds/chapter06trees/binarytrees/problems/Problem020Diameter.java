package ds.chapter06trees.binarytrees.problems;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.traversals.PreOrderTraversal;

/**
 * he diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
 * @author pasbola
 *
 */
public class Problem020Diameter {

	public int findDiameterRecursively(BinaryTreeNode root){
		int diameter = 0;
		int left, right;
		if(root == null){
			return 0;
		}
		left = findDiameterRecursively(root.getLeft());
		right = findDiameterRecursively(root.getRight());
		
		if(left+right > diameter) {
			diameter = left + right;
		}
		return Math.max(left, right)+1;
		//return left + right +1;
		
	}
	
	public int diameter (BinaryTreeNode root) {
		if(root == null) return 0;
		int len1 = height(root.getLeft()) + height(root.getRight())+3;
		int len2 = Math.max(diameter(root.getLeft()), diameter(root.getRight()));
		return Math.max(len1, len2);
		
	}
	public int height(BinaryTreeNode root){
		if(root == null) return 0;
		int leftDepth = height(root.getLeft());
		int rightDepth = height(root.getRight());
		return (leftDepth>rightDepth) ? leftDepth +1 : rightDepth +1;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem020Diameter problem020 = new Problem020Diameter();
		int diameter = problem020.findDiameterRecursively(root);
		System.out.println("diameter "+ diameter);
		System.out.println(problem020.diameter(root));
		
		System.out.println("get diameter " + problem020.getDiameter(root));
	}
	
	public int getDiameter(BinaryTreeNode root){
		Problem010 problem010 = new Problem010();
		int leftLength = problem010.treeHeight(root.getLeft());
		System.out.println("left  " + leftLength);
		int rightLength = problem010.treeHeight(root.getRight());
		System.out.println("right " + rightLength);
		return leftLength+rightLength+1;
	}
}
