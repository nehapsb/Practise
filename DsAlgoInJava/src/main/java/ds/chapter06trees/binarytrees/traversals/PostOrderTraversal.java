package ds.chapter06trees.binarytrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;
import ds.chapter06trees.binarytrees.problems.TreeUtil;

/**1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
 */

public class PostOrderTraversal {

	public ArrayList<Integer> postOrder(BinaryTreeNode root){
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if(root == null){
			return nodes;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		BinaryTreeNode prev = null;
		while(!stack.isEmpty()){
			BinaryTreeNode current = stack.peek();
			if(prev == null || prev.getLeft()==current || prev.getRight()==current){
				if(current.getLeft() != null){
					stack.push(current.getLeft());
				}else if(current.getRight() != null){
				stack.push(current.getRight());
				}
			}
			else if(current.getLeft()== prev){
				if(current.getRight() != null){
					stack.push(current.getRight());
				}
			}
			else{
				nodes.add(current.getData());
				stack.pop();
			}
			prev = current;
		}
		
		return nodes;
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = TreeUtil.createBinaryTree();
		
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
	//	List<Integer> nodes = postOrderTraversal.postOrder(root);
		List<Integer> nodes = postOrderTraversal.postOrderTraversal(root);
		System.out.println("nodes "+ nodes);
		
	}
	
	public ArrayList<Integer> postOrderTraversal(BinaryTreeNode root){
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if(root == null){
			return nodes;
		}
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack1.push(root);
		
		while(!stack1.isEmpty()){
			BinaryTreeNode current = stack1.pop();
			stack2.push(current);
			
			if(current != null && current.getLeft() != null){
				stack1.push(current.getLeft());
			}
			if(current != null && current.getRight() != null){
				stack1.push(current.getRight());
			}
		}
		
		while (!stack2.isEmpty())
	    {
	        BinaryTreeNode node = stack2.pop();
	        nodes.add(node.getData());
	    }
		return nodes;
		
	}
}
