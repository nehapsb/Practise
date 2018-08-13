package ds.chapter06trees.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

import ds.chapter06trees.binarytrees.implementation.BinaryTreeNode;

public class Problem028CheckMirror {

	public boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null ||  root2 == null){
			return false;
		}
		
		if(root1.getData() != root2.getData()){
			return false;
		}
		else{
			return areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft()); 
		}
	}
	
	public boolean areMirrorsIteratively(BinaryTreeNode root1, BinaryTreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null ||  root2 == null){
			return false;
		}
		if(root1.getData() != root2.getData()){
			return false;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		return false;
	}
}
