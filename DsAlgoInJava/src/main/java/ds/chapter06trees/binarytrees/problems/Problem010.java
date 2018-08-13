package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem010 {

	public int findMaxDepthRecursively(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		
		
		int leftDepth = findMaxDepthRecursively(root.getLeft());
		int rightDepth = findMaxDepthRecursively(root.getRight());
		
		return (leftDepth > rightDepth)?leftDepth+1 : rightDepth +1;
	}
	
	public int findMaxDepthIteratively(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		int depth = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			BinaryTreeNode current = queue.poll();
			if(current != null){
				if(current.getLeft() == null && current.getRight() == null){
					return depth;
				}
				if(current.getLeft() != null){
					queue.offer(current.getLeft());
				}
				if(current.getRight() != null){
					queue.offer(current.getRight());
				}
			}
			else{
				if(!queue.isEmpty()){
					depth++;
					queue.offer(null);
				}
			}
			
		}
		return depth;
		
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem010 problem010 = new Problem010();
		//System.out.println("depth recursively" +problem010.findMaxDepthRecursively(root));
		System.out.println("depth iteratively " +problem010.findMaxDepthIteratively(root));
		//System.out.println("treeHeight " + problem010.treeHeight(root));
	}
	
	int treeHeight(BinaryTreeNode node) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Create an empty queue for level order tarversal
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;
        while (true) {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
            	BinaryTreeNode newnode = q.peek();
                q.remove();
                if (newnode.getLeft() != null) {
                    q.add(newnode.getLeft());
                }
                if (newnode.getRight() != null) {
                    q.add(newnode.getRight());
                }
                nodeCount--;
            }
        }
    }
}
