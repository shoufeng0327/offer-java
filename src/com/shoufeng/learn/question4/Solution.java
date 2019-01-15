package com.shoufeng.learn.question4;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author shoufeng
 */

import java.util.Arrays;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    TreeNode treeNode = new TreeNode(pre[0]);
    if (pre.length == 1){
      return treeNode;
    }
    int i = 0;
    for (i = 0; i < in.length; i++) {
      if (in[i] == pre[0]){
        break;
      }
    }
    if (i != 0){
      int[] nextLeftPre = Arrays.copyOfRange(pre, 1, i + 1);
      int[] nextLeftIn = Arrays.copyOfRange(in, 0, i);
      treeNode.left = reConstructBinaryTree(nextLeftPre,nextLeftIn);
    }

    if (i + 1 != in.length){
      int[] nextRightPre = Arrays.copyOfRange(pre, i + 1, pre.length);
      int[] nextRightIn = Arrays.copyOfRange(in, i + 1, pre.length);
      treeNode.right = reConstructBinaryTree(nextRightPre,nextRightIn);
    }
    return treeNode;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    int[] pre = {1,2,4,3,5,6};
    int[] in = {4,2,1,5,3,6};
    Solution solution = new Solution();
    TreeNode treeNode = solution.reConstructBinaryTree(pre, in);
  }
}
