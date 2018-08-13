package ds.chapter06trees.binarysearchtrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarysearchtrees.implementation.BinarySearchTreeNode;
import ds.chapter06trees.binarytrees.problems.Problem002MaxElement;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

/**
 * /**
 * Problem: Can we further improve the complexity of Problem-56?
 * Solution: Yes, by using inorder traversal. The idea behind this soln is that,
 * 	inorder traversal of BST produces sorted lists. While traversing the BST in
 * 	inorder, at each node check the condition that its key value shld be greater 
 * 	than the key value of its prev visited node. Also, we need to 
 * 	initialize the prev with possible min integer value.
 * 
 * Time Complexity: 
 * Space Complexity:
 *
 */
public class Problem058 {

	//int prev = Integer.MIN_VALUE;
	public boolean isValidBST(BinarySearchTreeNode root, int prev){
		if(root == null){
			return true;
		}
		if(!isValidBST(root.getLeft(), prev)){
			return false;
		}
		if(root.getData() < prev){
			return false;
		}
		prev = root.getData();
		return isValidBST(root.getRight(), prev);
	}
	
	public boolean isBSTUsinginorderTraversal(BinarySearchTreeNode root) {
		if(root == null){
			return true;
		}
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		while(!queue.isEmpty()){
			BinarySearchTreeNode current  = queue.poll();
			if(current.getData() <= min || current.getData() >= max){
				return false;
			}
			if(current.getLeft() != null ){
				queue.offer(current.getLeft());
				max = current.getData();
			}
			if(current.getRight() != null ){
				queue.offer(current.getRight());
				min = current.getData();
			}
		}
		return true;
	}
	
	public boolean isBinarysearchTree(BinarySearchTreeNode root){
		if(root == null){
			return false;
		}
		Queue<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			BinarySearchTreeNode current = queue.poll();
			Problem002MaxElement element = new Problem002MaxElement();
			if(current != null){
				if(current.getData() > min && current.getData() < max){
					return false;
				}
				queue.offer(current);
			}
				
		}
		return true;
		
	}
	
	public static void main(String[] args){
		Problem058 problem058 = new Problem058();
		BinarySearchTreeNode root = TreeUtil.createBinarySearchTree();
		System.out.println("is valid bst root:" +problem058.isValidBST(root, Integer.MIN_VALUE));
		int[] preorder = new int[]{10,4,5,8,15,20};
		BinarySearchTreeNode root1 = new BinarySearchTreeContruction().contructBSTFromPreorderTraversal(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("is valid bst root1:" +problem058.isValidBST(root1, Integer.MIN_VALUE));
		
		System.out.println("is BST using inorder , root " + problem058.isBSTUsinginorderTraversal(root));
		System.out.println("is BST using inorder , root1 " + problem058.isBSTUsinginorderTraversal(root1));
	}
}
