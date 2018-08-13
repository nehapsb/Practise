package ds.chapter06trees.binarysearchtrees.implementation;

public class BinarySearchTreeOperations {
	BinarySearchTreeNode root;
	
	public BinarySearchTreeOperations() {
		root = null;
	}

	public BinarySearchTreeNode findElementInTreeIteratively(BinarySearchTreeNode root, int data){
		if(root == null){
			return null;
		}
		while(root != null){
			if(data == root.getData()){
				return root;
			}
			else if(root.getData() > data){
				root = root.getLeft();
			}
			else{
				root = root.getRight();
			}
		}
		return null;
	}
	
	public BinarySearchTreeNode findElementInTreeRecursively(BinarySearchTreeNode root, int data){
		if(root == null){
			return null;
		}
		if(data < root.getData()){
			return findElementInTreeRecursively(root.getLeft(), data);
		}
		else{
			return findElementInTreeRecursively(root.getRight(), data);
		}
	}
	
	public BinarySearchTreeNode findMinimumInBST(BinarySearchTreeNode root){
		if(root == null){
			return null;
		}
		while(root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
	}
	
	public BinarySearchTreeNode findMaxInBST(BinarySearchTreeNode root){
		if(root == null){
			return null;
		}
		while(root.getRight() != null){
			root = root.getRight();
		}
		return root;
	}
	
	public BinarySearchTreeNode findMaxInBSTRecursively(BinarySearchTreeNode root){
		if(root == null){
			return null;
		}
		else if(root.getRight() == null){
				return root;
			}
		else{
			return findMaxInBSTRecursively(root.getRight());
			
			}
	}
	
	public BinarySearchTreeNode createBST(int data){
		if(root == null){
			root = new BinarySearchTreeNode(data);
			root.setLeft(null);
			root.setRight(null);
		}
		else{
			if(root.getData() > data){
				if(root.getLeft()!=null){
					
				}else{
					root.setLeft(new BinarySearchTreeNode(data));
				}
			}
			else{
				if(root.getRight() != null){
					
				}
				else{
					root.setRight(new BinarySearchTreeNode(data));
				}
			}
			
		}
		return root;
		
	}
	
	public BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int data){
		if(root == null){
			root = new BinarySearchTreeNode(data);
			return root;
		}
		if(data<root.getData()){
			root.setLeft(insertNode(root.getLeft(), data));
		}
		else if(data > root.getData()){
			root.setRight(insertNode(root.getRight(), data));
		}
		return root;
	}
}
