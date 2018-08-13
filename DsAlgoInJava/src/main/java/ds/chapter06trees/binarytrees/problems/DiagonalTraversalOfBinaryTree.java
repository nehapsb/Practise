package ds.chapter06trees.binarytrees.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class DiagonalTraversalOfBinaryTree {

	/*public List<Integer> getDiagonalTraversal(BinaryTreeNode root){
		List<Integer> nodes = new ArrayList<Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			BinaryTreeNode temp = current;
			if(!nodes.contains(current.getData())){
				nodes.add(current.getData());
			}
			while(current.getRight() != null){
				current = current.getRight();
				queue.offer(current);
			}
			if(temp.getLeft() != null){
				queue.offer(temp.getLeft());
			}
		}
		
		return nodes;
	}*/
	
	public List<Integer> getDiagonalTraversal(BinaryTreeNode root){
		List<Integer> nodes = new ArrayList<Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			while(current != null){
				nodes.add(current.getData());
				//queue.offer(current);
				if(current != null && current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				current = current.getRight();
			}
		}
		
		return nodes;
	}
	
	public Map<Integer, Integer> computeDiagonalSum(BinaryTreeNode root, Integer currDiag){
		HashMap<Integer, Integer> diagonalSum = new HashMap<Integer, Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			int sum = 0;
			 while (current != null){
				 int prevSum = (diagonalSum.get(currDiag) == null) ? 0 : diagonalSum.get(currDiag) ;
				 diagonalSum.put(currDiag, prevSum + current.getData());
				 sum = sum + current.getData();
				 if(current.getLeft() != null){
					 queue.offer(current.getLeft());
					// currDiag = currDiag + 1;
				 }
				 current = current.getRight();
	        }
			 currDiag = currDiag +1;
			 System.out.println("sum " + sum);
		}
		return diagonalSum;
		
	}

	private void computeDiagSum(BinaryTreeNode currentNode, int currDiag,HashMap<Integer, Integer> diagSum) {
		if (currentNode == null) {
			return;
		}

		computeDiagSum(currentNode.getLeft(), currDiag + 1, diagSum);

		int prevSum = (diagSum.get(currDiag) == null) ? 0 : diagSum
				.get(currDiag);
		diagSum.put(currDiag, prevSum + currentNode.getData());

		computeDiagSum(currentNode.getRight(), currDiag, diagSum);
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		DiagonalTraversalOfBinaryTree diagonalTraversalOfBinaryTree = new DiagonalTraversalOfBinaryTree();
		List<Integer> nodes =  diagonalTraversalOfBinaryTree.getDiagonalTraversal(root);
		System.out.println(nodes);
		
		/* Map<Integer, Integer> diagonalSum = diagonalTraversalOfBinaryTree.computeDiagonalSum(root, 0);
		 for(Map.Entry<Integer, Integer> entry : diagonalSum.entrySet()){
			 System.out.println("get key " + entry.getKey() + " diagonal sum " + entry.getValue());
		 }*/
		HashMap<Integer, Integer> diagSum = new HashMap<Integer, Integer>();
		diagonalTraversalOfBinaryTree.computeDiagSum(root, 0, diagSum);
		for (Map.Entry<Integer, Integer> entry : diagSum.entrySet()) 
		 {
		  System.out.println("Diagonal Sum for level "  + entry.getKey() + " :"  + entry.getValue());
		 }
	}
}
