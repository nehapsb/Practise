package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem021Width {

	public int width(BinaryTreeNode root) {
		int maxWidth = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		/*while (true) {
			int count = queue.size();
			if (count == 0) {
				return maxWidth;
			}*/
		int nodeCount =1;
		//	int count = 0;
			while (!queue.isEmpty()) {
				int count = 0;
				
				for (int i = 0; i < nodeCount; i++) {
					BinaryTreeNode node = queue.peek();
					queue.remove();
					if (node.getLeft() != null) {
						queue.add(node.getLeft());
						count++;
					}
					if(node.getRight() != null){ 
					  queue.add(node.getRight());
					  count++; 
					 }
				}
				System.out.println("node count " + count);
				nodeCount = count;
				if(maxWidth < count){
					maxWidth = count;
				}
			}
			return maxWidth;

		//}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		Problem021Width problem021 = new Problem021Width();
		System.out.println(problem021.width(root));
	}
}
