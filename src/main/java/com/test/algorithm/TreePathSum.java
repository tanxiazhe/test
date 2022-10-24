package com.test.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreePathSum {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public void getPreorder(TreeNode root, Integer sum) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;

    int c = 0;
    while (p != null || !stack.isEmpty()) {

      if (p != null) {
        c += p.val;
        stack.push(p);
        p = p.left;
      } else {
        p = stack.pop();
        p = p.right;
      }
    }
  }

  public List<List<Integer>> getPath(TreeNode root, Integer sum) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();

    helper(root, sum, path, res);
    return res;
  }

  public void helper(TreeNode root, Integer remaining, LinkedList<Integer> path,
      List<List<Integer>> res) {
    if (root == null) {
      return;
    }
    path.add(root.val);
    if (root.left == null && root.right == null && root.val == remaining) {

      res.add(new LinkedList<>(path));
      return;
    }
    helper(root.left, remaining-root.val, path, res);
    helper(root.right, remaining-root.val, path, res);
    path.removeLast();
  }
}
