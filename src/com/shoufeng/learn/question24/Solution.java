package com.shoufeng.learn.question24;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意:
 * 在返回值的list中，数组长度大的数组靠前)
 * 思路: 是到底层节点的和为目标值，中间点达成不行。到最深处后逐级上跳
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

  private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
  private ArrayList<Integer> list = new ArrayList<Integer>();

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
   if (root == null){
     return listAll;
   }
   list.add(root.val);
   target = target - root.val;
   if (target == 0 && root.left == null && root.right == null){
     listAll.add(new ArrayList<>(list));
   }
   FindPath(root.left,target);
   FindPath(root.right,target);
   list.remove(list.size() - 1);
   return listAll;
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
    TreeNode rootNode = new TreeNode(10);
    rootNode.left = new TreeNode(5);
    rootNode.left.left = new TreeNode(7);
    rootNode.left.left.left = new TreeNode(8);
    rootNode.right = new TreeNode(12);
    Solution solution = new Solution();
    System.out.println(solution.FindPath(rootNode, 22).toString());
  }
}
