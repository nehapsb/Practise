package ds.chapter06trees.binarysearchtrees.problems;

import java.util.LinkedList;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

public class BSTSolution {

	    public boolean isValidBST(BinarySearchTreeNode root) {
	        if(root == null)
	            return true;
	 
	        LinkedList<BNode> queue = new LinkedList<BNode>();
	        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
	        while(!queue.isEmpty()){
	            BNode b = queue.poll();
	            if(b.node.getData() <= b.left || b.node.getData() >=b.right){
	                return false;
	            }
	            if(b.node.getLeft()!=null){
	                queue.offer(new BNode(b.node.getLeft(), b.left, b.node.getData()));
	            }
	            if(b.node.getRight()!=null){
	                queue.offer(new BNode(b.node.getRight(), b.node.getData(), b.right));
	            }
	        }
	        return true;
	    }
	    public static void main(String[] args){
	    	int[] preorder = new int[]{10,4,5,8,15,20};
	    	BinarySearchTreeNode root = new BinarySearchTreeContruction().contructBSTFromPreorderTraversal(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	    	BSTSolution bstSolution = new BSTSolution();
	    	System.out.println("is BST root " + bstSolution.isValidBST(root));
	    	BinarySearchTreeNode root1 = TreeUtil.createBinarySearchTree();
	    	System.out.println("is BST root1 " + bstSolution.isValidBST(root1));
	    	
	    }
	}
	//define a BNode class with TreeNode and it's boundaries
	class BNode{
		BinarySearchTreeNode node;
	    double left;
	    double right;
	    public BNode(BinarySearchTreeNode n, double left, double right){
	        this.node = n;
	        this.left = left;
	        this.right = right;
	    }
	}  
