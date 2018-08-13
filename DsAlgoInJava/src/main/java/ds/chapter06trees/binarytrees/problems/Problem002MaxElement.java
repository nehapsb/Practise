
package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem002MaxElement {
	
	public int findMaxElementInBinaryTree(BinaryTreeNode root){
		int maxElement = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			if(current.getData() > maxElement){
				maxElement = current.getData();
			}
			if(current != null){
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
				
			}
			
		}
		return maxElement;
		
	}
	
	public int findMaxElementInBinarySearchTree(BinarySearchTreeNode root){
		int maxElement = 0;
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinarySearchTreeNode current = queue.poll();
			if(current.getData() > maxElement){
				maxElement = current.getData();
			}
			if(current != null){
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
				
			}
			
		}
		return maxElement;
		
	}
	
	public int findMinElementInBinarySearchTree(BinarySearchTreeNode root){
		int minElement = root.getData();
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinarySearchTreeNode current = queue.poll();
			if(current.getData() < minElement){
				minElement = current.getData();
			}
			if(current != null){
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
				
			}
			
		}
		return minElement;
		
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem002MaxElement problem002MaxElement = new Problem002MaxElement();
		System.out.println("max element " + problem002MaxElement.findMaxElementInBinaryTree(root));
		BinarySearchTreeNode root1 = TreeUtil.createBinarySearchTree(); 
		System.out.println("min element "+ problem002MaxElement.findMinElementInBinarySearchTree(root1));
	}
}
