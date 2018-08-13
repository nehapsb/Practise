package geeksforgeeks.ds.trees.binaryTrees.util;

import javax.swing.text.Utilities;

import org.junit.Test;

import geeksforgeeks.ds.trees.binaryTrees.Utility;
import geeksforgeeks.ds.trees.binaryTrees.impl.BinaryNode;

public class BinaryTreeUtilTest {

  @Test
  public void testTraversal() {
    BinaryNode root = Utility.dummyBinaryTree(1);
   // BinaryTreeUtil.levelorderTraversal(root);

    System.out.println("");

    BinaryTreeUtil.inorderTraversalIterative(root);
    System.out.println("");
    //BinaryTreeUtil.inorderTraversalRecursive(root);

    System.out.println("");
    //BinaryTreeUtil.preorderTraversalRecursive(root);

    System.out.println("");
    //BinaryTreeUtil.preorderIterative(root);
  }

  @Test
  public void testAreIdentical() {
    BinaryNode root1 = Utility.dummyBinaryTree(1);
    BinaryNode root2 = Utility.dummyBinaryTree(1);
    root2.setData(5);
    System.out.println(BinaryTreeUtil.areIdentical(root1, root2));
  }

  @Test
  public void testGetMaxDepthOrHeight(){
    BinaryNode root = Utility.dummyBinaryTree(1);
    System.out.println(BinaryTreeUtil.getMaxDepthOrHeightRecursive(root));

    BinaryNode root1 = Utility.dummyBinaryTree(1);
    System.out.println(BinaryTreeUtil.getMaxDepthOrHeightIterative(root1));

  }

  @Test
  public void testPrintKDistantNodes() {
    BinaryNode root = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.printKDistantNodes(root, 2);
  }

  @Test
  public void testDeleteBinaryTree(){
    BinaryNode root = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.deleteBinaryTree(root);
  }

  @Test
  public void testMirror() {
    BinaryNode root = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.inorderTraversalIterative(root);
    System.out.println("------Mirror------");
    BinaryTreeUtil.mirror(root);
    BinaryTreeUtil.inorderTraversalIterative(root);
  }

  @Test
  public void testPrintPaths() {
    BinaryNode root = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.printPaths(root);
  }

  @Test
  public void testAreMirror() {
    BinaryNode root = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.inorderTraversalIterative(root);
    System.out.println("----Mirror----");
    BinaryNode tmp = Utility.dummyBinaryTree(1);
    BinaryTreeUtil.mirror(root);
    BinaryTreeUtil.inorderTraversalIterative(root);
    System.out.println(BinaryTreeUtil.areMirrors(root, tmp));
  }

}

