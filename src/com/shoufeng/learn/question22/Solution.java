package com.shoufeng.learn.question22;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author shoufeng
 */

import java.util.ArrayList;

/**
 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right = null;
 *
 * public TreeNode(int val) { this.val = val;
 *
 * }
 *
 * }
 */
public class Solution {

  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.add(root.val);
    addNodeVal(root, list);
    return list;
  }

  public void addNodeVal(TreeNode root, ArrayList<Integer> integers) {
    if (root.left != null) {
      integers.add(root.left.val);
    }
    if (root.right != null) {
      integers.add(root.right.val);
    }
    if (root.left != null) {
      addNodeVal(root.left, integers);
    }
    if (root.right != null) {
      addNodeVal(root.right, integers);
    }
  }

  public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }
}
