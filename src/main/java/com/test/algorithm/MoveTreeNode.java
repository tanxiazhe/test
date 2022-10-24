/**
 *
 */
package com.test.algorithm;

public class MoveTreeNode {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static TreeNode createBinaryTreeByArray(int[] array, int index) {
    TreeNode tn = null;
    if (index < array.length) {
      int value = array[index];
      tn = new TreeNode(value);
      tn.left = createBinaryTreeByArray(array, 2 * index + 1);
      tn.right = createBinaryTreeByArray(array, 2 * index + 2);
      return tn;
    }
    return tn;
  }

  public static TreeNode moveBinaryTreeNode() {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    TreeNode root = createBinaryTreeByArray(arr, 0);

    TreeNode sourceNode = new TreeNode(2);
    TreeNode targetNode = new TreeNode(7);
    TreeNode sourceNodeParent = findParentNode(root, sourceNode);

    targetNode.left = sourceNode;
    if (sourceNodeParent.left == sourceNode) {
      sourceNodeParent.left = null;
    } else {
      sourceNodeParent.right = null;
    }
    return root;
  }

  public static TreeNode findParentNode(TreeNode root, TreeNode node) {
    TreeNode p, f;
    p = root;
    f = null;
    while (p != null) {
      if (p.val == node.val) {
        return f;
      } else if (p.val >= node.val) {
        f = p;
        p = p.left;
      } else {
        f = p;
        p = p.right;
      }
    }
    return root;
  }
}
