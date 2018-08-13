package geeksforgeeks.ds.trees.binaryTrees.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import geeksforgeeks.ds.trees.binaryTrees.impl.BinaryNode;

public class BinaryTreeUtil {

  public static void inorderTraversalRecursive(BinaryNode root) {
    if(root==null) {
      return;
    }
    inorderTraversalRecursive(root.getLeft());
    System.out.print(root.getData()+" ");
    inorderTraversalRecursive(root.getRight());
  }
  public static void preorderTraversalRecursive(BinaryNode root) {
    if(root==null) {
      return;
    }
    System.out.print(root.getData()+" ");
    preorderTraversalRecursive(root.getLeft());
    preorderTraversalRecursive(root.getRight());
  }
  public static void postorderTraversalRecursive(BinaryNode root) {
    if(root==null) {
      return;
    }
    postorderTraversalRecursive(root.getLeft());
    postorderTraversalRecursive(root.getRight());
    System.out.print(root.getData()+" ");
  }
  public static void levelorderTraversal(BinaryNode root){
    Queue<BinaryNode> q = new LinkedList<BinaryNode>();
    q.offer(root);
    while(!q.isEmpty()) {
      BinaryNode temp = q.poll();
      System.out.print(temp.getData()+" ");
      if(temp.getLeft()!=null) {
        q.offer(temp.getLeft());
      }
      if(temp.getRight()!=null) {
        q.offer(temp.getRight());
      }
    }
    System.out.println("");
  }
  public static void inorderTraversalIterative(BinaryNode root) {
    Stack<BinaryNode> s = new Stack<BinaryNode>();
    BinaryNode temp = root;
    while(temp!=null) {
      s.push(temp);
      temp = temp.getLeft();
    }
    while(!s.isEmpty()) {
      BinaryNode temp2 = s.pop();
      System.out.print(temp2.getData()+" ");
      if(temp2.getRight()!=null) {
        temp2 = temp2.getRight();
        while(temp2!=null) {
          s.push(temp2);
          temp2 = temp2.getLeft();
        }
      }
    }
    System.out.println("");
  }
  public static void preorderIterative(BinaryNode root) {
    Stack<BinaryNode> s = new Stack<BinaryNode>();
    BinaryNode temp = root;
    s.push(temp);
    while(!s.isEmpty()) {
      BinaryNode temp2 = s.pop();
      System.out.print(temp2.getData()+" ");
      if(temp2.getRight()!=null) {
        s.push(temp2.getRight());
      }
      if(temp2.getLeft()!=null) {
        s.push(temp2.getLeft());
      }
    }



  }
  public static int size(BinaryNode root) {
    if(root==null) {
      return 0;
    }
    return size(root.getLeft())+1+size(root.getRight());
  }

  public static boolean areIdentical(BinaryNode root1, BinaryNode root2) {
    if(root1==null && root2==null) {
      return true;
    }
    if(root1!=null&&root2!=null) {
      return root1.getData()==root2.getData()&&areIdentical(root1.getLeft(), root2.getLeft())&&areIdentical(root1.getRight(), root2.getRight());
    }
    return false;
  }
  public static int getMaxDepthOrHeightRecursive(BinaryNode root){
    if(root==null) {
      return 0;
    }
    int maxLeft = getMaxDepthOrHeightRecursive(root.getLeft());
    int maxRight = getMaxDepthOrHeightRecursive(root.getRight());
    return Math.max(maxLeft, maxRight)+1;
  }
  /**
   * Using level order traversal.
   * @param root
   * @return
   */
  public static int getMaxDepthOrHeightIterative(BinaryNode root){
    if(root == null) {
      return 0;
    }
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.offer(root);
    queue.offer(null);
    int count=1;
    while(!queue.isEmpty()) {
      BinaryNode temp = queue.poll();
      if(temp!=null) {
        if(temp.getLeft()==null && temp.getRight()==null && queue.isEmpty()) {
          return count;
        }
        if(temp.getLeft()!=null) {
          queue.offer(temp.getLeft());
        }
        if(temp.getRight()!=null) {
          queue.offer(temp.getRight());
        }
      } else {
        if(!queue.isEmpty()) {
          count++;
          queue.offer(null);
        }
      }
    }
    return count;
  }

  /**
   * Traversing all nodes using post-order traversal to delete all nodes
   * as the child elems should be deleted first than the parent.
   *
   * @param root
   * @return
   */
  public static void deleteBinaryTree(BinaryNode root) {
    if(root==null) {
      return;
    }
    deleteBinaryTree(root.getLeft());
    deleteBinaryTree(root.getRight());
    System.out.println("Deleting node: "+root.getData());
    root = null;
  }

  /**
   * Algorithm – Mirror(tree):

(1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
(2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
(3)  Swap left and right subtrees.
          temp = left-subtree
          left-subtree = right-subtree
          right-subtree = temp
   * @param root
   * @return
   */
  public static void mirror(BinaryNode root) {
    if(root==null) {
      return;
    }
    mirror(root.getLeft());
    mirror(root.getRight());
    BinaryNode temp = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(temp);
  }

  public static boolean areMirrors(BinaryNode root1, BinaryNode root2) {
    if(root1==null && root2==null) {
      return true;
    }
    if(root1==null || root2==null) {
      return false;
    }
    if(root1.getData()!=root2.getData()) {
      return false;
    }
    return areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft());


  }
/**
 *
 * A node is a leaf node if both left and right child nodes of it are NULL.

Here is an algorithm to get the leaf node count.

getLeafCount(node)
1) If node is NULL then return 0.
2) Else If left and right child nodes are NULL return 1.
3) Else recursively calculate leaf count of the tree using below formula.
    Leaf count of a tree = Leaf count of left subtree +
                                 Leaf count of right subtree
 * @param root
 * @return
 */
  public static int leafNodes(BinaryNode root) {
    if(root==null) {
      return 0;
    }
    if(root.getLeft()==null && root.getRight()==null) {
      return 1;
    }
    return leafNodes(root.getLeft())+leafNodes(root.getRight());
  }

/**
 * Problem-30:
 * For the below example tree, all root-to-leaf paths are:
    10 –> 8 –> 3
    10 –> 8 –> 5
    10 –> 2 –> 2
                       10
                     /    \
                    8      2
                   / \    /
                  3   5  2

Algorithm:
Use a path array path[] to store current root to leaf path. Traverse from root to all leaves in top-down fashion. While traversing, store data of all nodes in current path in array path[]. When we reach a leaf node, print the path array.

CJava

 * @param root
 */
  public static void printPaths(BinaryNode root) {
    int[] paths = new int[100];
    printPathsRecursive(root, paths, 0);
  }
  private static void printPathsRecursive(BinaryNode root, int[] paths, int pathLen) {
    if(root==null) {
      return;
    }
    paths[pathLen]=root.getData();
    pathLen++;
    if(root.getLeft()==null && root.getRight()==null) {
      printPaths(paths, pathLen);
    } else {
      printPathsRecursive(root.getLeft(), paths, pathLen);
      printPathsRecursive(root.getRight(), paths, pathLen);
    }
  }
  private static void printPaths(int[] paths, int pathLen) {
    System.out.println("");
    for(int i=0; i<pathLen; i++) {
      System.out.print(paths[i]+" ");
    }
    System.out.println("");
  }

/**
 * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
  For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
            1
          /   \
         2      3
       /  \    /
     4     5  8

 * @param root
 * @param k
 */
  public static void printKDistantNodes(BinaryNode root, int k) {
    if(root==null) {
      return;
    }
    if(k==0) {
      System.out.println(root.getData()+" ");
      return;
    }
    printKDistantNodes(root.getLeft(), k-1);
    printKDistantNodes(root.getRight(), k-1);
  }

public static boolean isSubtree(BinaryNode root, BinaryNode sub) {
  if(sub == null) {
    return true;
  }
  if(root==null) {
    return false;
  }
  if(areIdentical(root, sub)) {
    return true;
  }

  return isSubtree(root.getLeft(), sub) || isSubtree(root.getRight(), sub);
}

/**
 * Build Tree from inorder array.
 *
 * @param inorder
 * @param start
 * @param end
 * @param node
 * @return
 */
public static BinaryNode buildTree(int[] inorder, int start, int end, BinaryNode node) {
  if(start > end) {
    return null;
  }
  int i = max(inorder, start, end);
  node = new BinaryNode(inorder[i]);

  if(start==end) {
    return node;
  }
  node.setLeft(buildTree(inorder, start, i-1, node.getLeft()));
  node.setRight(buildTree(inorder, i+1, end, node.getRight()));
  return node;
}
private static int max(int[] inorder, int start, int end) {
  int i, max = inorder[start], maxind = start;
  for (i = start + 1; i <= end; i++) {
      if (inorder[i] > max) {
          max = inorder[i];
          maxind = i;
      }
  }
  return maxind;

}


}
