package geeksforgeeks.ds.trees.binaryTrees;

import geeksforgeeks.ds.trees.binaryTrees.impl.BinaryNode;

public class Utility {
  /**
   *             1
   *          /     \
   *         2       3
   *       /   \    / \
   *      4     5  7   8
   *     /
   *    6
   *
   *
   * @param data
   * @return
   */
  public static BinaryNode dummyBinaryTree(int data) {
    BinaryNode root = new BinaryNode(data++);
    root.setLeft(new BinaryNode(data++));
    root.setRight(new BinaryNode(data++));
    root.getLeft().setLeft(new BinaryNode(data++));
    root.getLeft().setRight(new BinaryNode(data++));
    root.getLeft().getLeft().setLeft(new BinaryNode(data++));
    root.getRight().setLeft(new BinaryNode(data++));
    root.getRight().setRight(new BinaryNode(data++));
    return root;
  }
}
