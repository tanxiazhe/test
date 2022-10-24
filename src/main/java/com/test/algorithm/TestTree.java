/**
 *
 */
package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author
 *
 */

public class TestTree {

  // Definition for a binary tree node.
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void preOrderTraverse(TreeNode node) {
    if (node != null) {
      System.out.println(node.val + " ");
      preOrderTraverse(node.left);
      preOrderTraverse(node.right);
    } else {
      return;
    }
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> res = new ArrayList<Integer>();
    TreeNode p = root;
    TreeNode temp = null;
    while (p != null || !stack.isEmpty()) {
      if (p != null) {
        stack.push(p);
        res.add(p.val);
        p = p.left;
      } else {
        temp = stack.pop();
        p = temp.right;
      }
    }
    return res;
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

  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }

    List<Integer> level = new ArrayList<Integer>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int last = 1, front = 0, rear = 1;
    while (front <= rear) {
      TreeNode top = q.poll();
      level.add(top.val);
      front++;
      if (top != null && top.left != null) {
        q.offer(top.left);
        rear++;
      }
      if (top != null && top.right != null) {
        q.offer(top.right);
        rear++;
      }

      if (front == last) {
        last = rear;
        res.add(level);
        level = new ArrayList<Integer>();
      }
    }
    Collections.reverse(res);
    return res;
  }

  static int sum = 0;

  public static int findTilt(TreeNode root) {

    if (root == null) {
      System.out.println(" sum=" + sum);
      return 0;
    }
    int l = findTilt(root.left);
    int r = findTilt(root.right);
    sum += Math.abs(l - r);
    System.out.println(
        "val=" + root.val + " sum=" + sum + " l=" + l + " r=" + r + " rtn=" + (root.val + l + r));
    return root.val + l + r;
  }

  public static void main(String[] args) {

    // int i = (int) Math.pow(2, 5);
    // System.out.println(i);

    TreeNode p;
    p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(5);
    p.right.left = p.right.left = null;
    p.left.left = new TreeNode(3);
    p.left.right = new TreeNode(4);
    p.left.left.left = p.left.left.right = null;
    p.left.right.left = p.left.right.right = null;
    // binaryTreePaths(p);
    // System.out.println(isSameTree(p, q));

    // int a[] = { 1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 8 };
    // TreeNode root = createBinaryTreeByArray(a, 0);
    // preOrderTraverse(root);
    // int count = countNodes(root);
    // System.out.println(count == a.length);

    // List<int[]> levelNode = new ArrayList<int[]>();
    // levelNode = Arrays.asList(a);

    // array2set();
    // System.out.println(findSecondMinimumValue(root));

    // List<String> l = new ArrayList<String>();
    // l.add(1 + "");
    // System.out.println(l.toString());
    System.out.println(findTilt(p));
  }

  public static int[] list2array(List<Integer> list) {
    int[] kth = new int[1 + list.size()];
    kth[0] = 0;
    int j = 1;
    for (int i : list) {
      kth[j] = i;
    }
    return kth;
  }

  public static int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<Integer>();
    findCandidatesKth(root, list);
    int[] kth = list2array(list);
    return kth[k];
  }

  static void findCandidatesKth(TreeNode root, List<Integer> candidates) {
    if (root != null) {
      findCandidatesKth(root.left, candidates);
      candidates.add(root.val);
      findCandidatesKth(root.right, candidates);
    }
  }

  static void findCandidates(TreeNode root, int min, int[] candidates) {
    if (root != null) {
      if (root.val == min && root.left != null && root.right != null
          && root.left.val != root.right.val) {
        if (root.left.val != min && root.left.val < candidates[0]) {
          candidates[0] = root.left.val;
        } else if (root.right.val != min && root.right.val < candidates[0]) {
          candidates[0] = root.right.val;
        }
      }
      findCandidates(root.left, min, candidates);
      findCandidates(root.right, min, candidates);
    }
  }

  public static int findSecondMinimumValue(TreeNode root) {
    if (root != null && root.left != null && root.right != null
        && root.left.val != root.right.val) {
      int[] a = {Integer.MAX_VALUE};
      findCandidates(root, root.val, a);
      return a[0];
    }
    return -1;
  }

  public static void array2set() {
    Integer[] numbers = {7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4};

    Set<Integer> set = new TreeSet<Integer>(Arrays.asList(numbers));

    System.out.println("Print Set Value via toString(): " + set.toString());

    // if you want to use Iterator to print value
    System.out.println("\nPrint Set Value via Iterator: ");

    for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
      Object o = iterator.next();
      System.out.print(o + " ");
    }

    System.out.println("min=" + Collections.min(set));
  }

  public static int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    TreeNode temp = null;
    int sum = 0;
    while (!stack.isEmpty()) {
      temp = stack.pop();
      if (temp == null) {
        continue;
      } else {
        TreeNode l, r;
        l = temp;
        r = temp;
        int lc = 0, rc = 0;
        while (l != null) {
          l = l.left;
          lc++;
        }
        while (r != null) {
          r = r.right;
          rc++;
        }
        if (lc == rc) {
          sum = sum + (int) Math.pow(2, lc) - 1;
        } else {
          sum += 1;
          stack.push(temp.left);
          stack.push(temp.right);
        }
      }
    }

    return sum;
  }

  public static class StackNode {
    boolean visited;
    TreeNode treeNode;

    StackNode(boolean visited, TreeNode treeNode) {
      this.visited = visited;
      this.treeNode = treeNode;
    }
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<String>();

    String arrow = "->";
    String path = "";

    if (root == null) {
      return res;
    }
    TreeNode p = root;
    StackNode top;
    Stack<StackNode> s1 = new Stack<StackNode>();
    Stack<StackNode> s2 = new Stack<StackNode>();

    while (p != null || !s1.isEmpty()) {

      if (p != null) {
        StackNode node = new StackNode(false, p);
        s1.push(node);
        p = p.left;
      } else if (!s1.isEmpty()) {
        StackNode temp = s1.pop();

        if (temp.visited == false) {
          temp.visited = true;
          s1.push(temp);

          if (temp.treeNode.left == null && temp.treeNode.right == null) {

            while (!s1.isEmpty()) {
              s2.push(s1.pop());
            }
            path = "";
            while (!s2.isEmpty()) {
              top = s2.pop();
              path += top.treeNode.val + arrow;
              s1.push(top);
            }
            res.add(path.substring(0, path.lastIndexOf("->")));
            System.out.println(path.substring(0, path.lastIndexOf("->")));
            s1.pop();
          } else {
            p = temp.treeNode.right;
          }
        }
      }
    }

    return res;
  }

  static List<Integer> preOrder(TreeNode h) {
    List<Integer> a = new ArrayList<Integer>();
    if (h != null) {
      a.add(h.val);
      preOrder(h.left);
      preOrder(h.right);
    } else {
      a.add(null);
    }
    System.out.println(a.toString());
    return a;
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    int last = 1, front = 0, rear = 1, level = 0;
    while (front <= rear) {
      TreeNode top = q.poll();
      front++;

      if (top != null && top.left != null) {
        q.offer(top.left);
        rear++;
      }
      if (top != null && top.right != null) {
        q.offer(top.right);
        rear++;
      }

      if (front == last) {
        last = rear;
        level++;
      }
    }

    return level;
  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (q == null || q == null) {
      return false;
    }

    List<Integer> a1 = preOrder(p);
    System.out.println();
    List<Integer> a2 = preOrder(q);

    if (a1.size() != a2.size()) {
      return false;
    }
    if (a1.size() == a2.size() && a1.equals(a2)) {
      return true;
    }
    return false;
  }
}
