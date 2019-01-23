package com.shoufeng.learn.question39;

import com.shoufeng.learn.question38.Solution.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 解释:平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（有别于AVL算法），
 * 且具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。 最小二叉平衡树的节点总数的公式如下 F(n)=F(n-1)+F(n-2)+1
 * 这个类似于一个递归的数列，可以参考Fibonacci(斐波那契)数列，1是根节点，F(n-1)是左子树的节点数量，F(n-2)是右子树的节点数量。
 * @author shoufeng
 */
public class Solution {
  public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null){
      return true;
    }
    Depth depth = new Depth();
    int leftDepth = depth.TreeDepth(root.left);
    depth.count = 0;
    depth.max = 0;
    int rightDepth = depth.TreeDepth(root.right);
    boolean isRootTrue = Math.abs(leftDepth - rightDepth) <= 1;
    boolean isLeftTrue = IsBalanced_Solution(root.left);
    boolean isRightTrue = IsBalanced_Solution(root.left);
    return isLeftTrue&&isRightTrue&&isRootTrue;
  }

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }
  }

  public static class Depth{
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
  }
}
