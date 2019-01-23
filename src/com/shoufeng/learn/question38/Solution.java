package com.shoufeng.learn.question38;

/**
 * 输入一棵二叉树，求该树的深度。 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author shoufeng
 */

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
  int max = 0;
  int count = 0;
  public int TreeDepth(TreeNode root) {
    if (root == null){
      return 0;
    }
    count++;
    TreeDepth(root.left);
    if (max < count){
      max = count;
    }
    TreeDepth(root.right);
    if (max < count){
      max = count;
    }
    count--;
    return max;
  }

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(1);
    treeNode.right.right = new TreeNode(1);
    treeNode.right.right.left = new TreeNode(1);
    treeNode.left = new TreeNode(1);
    treeNode.left.left = new TreeNode(1);
    treeNode.left.right = new TreeNode(1);
    System.out.println(solution.TreeDepth(treeNode));
  }
}
