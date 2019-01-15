package com.shoufeng.learn.question17;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author shoufeng
 */

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

  public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    return isSonTree(root1, root2, true);
  }

  private Boolean isSonTree(TreeNode root1, TreeNode root2, boolean isFirst) {
    if (isFirst) {
      if (root2 == null) {
        return false;
      }
    } else {
      if (root2 == null) {
        return true;
      }
    }

    if (root1 == null) {
      return false;
    }
    if (root1.val == root2.val) {
      boolean flag = isSonTree(root1.left, root2.left,false) && isSonTree(root1.right, root2.right,false);
      if (!flag && (root1.left != null || root1.right != null)) {
        return isSonTree(root1.left, root2,false) || isSonTree(root1.right, root2,false);
      }
      return flag;
    }
    return isSonTree(root1.left, root2,false) || isSonTree(root1.right, root2,false);
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
