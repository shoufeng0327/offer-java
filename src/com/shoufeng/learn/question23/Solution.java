package com.shoufeng.learn.question23;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 思路: 后续遍历获得的最后一个数值就是根结点的数值，左树都比根结点小，右树都比根结单大
 * @author shoufeng
 */
public class Solution {
  public boolean VerifySquenceOfBST(int [] sequence) {

    //数组长度
    int len = sequence.length;
    if (len == 0){
      return false;
    }
    if (len == 1 || len == 2){
      return true;
    }
    //第一个根结点的数值
    int rootVal = sequence[len - 1];
    //左树都比根结点小，右树都比根结单大
    //右树开启点
    Integer rightStartAt = null;
    for (int i = 0; i < sequence.length - 1; i++) {
      if (sequence[i] > rootVal){
        rightStartAt = i;
        break;
      }
    }
    if (rightStartAt == null){
      return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,len - 1));
    }
    if (rightStartAt == sequence.length - 2){
      return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,len - 2));
    }
    for (int i = rightStartAt; i < sequence.length - 1; i++) {
      if (sequence[i] < rootVal){
        return false;
      }
    }
    int[] leftSequence = Arrays.copyOfRange(sequence, 0, rightStartAt);
    boolean leftFlag = (leftSequence.length == 0 || VerifySquenceOfBST(leftSequence));
    int[] rightSequence = Arrays.copyOfRange(sequence, rightStartAt, len - 1);
    boolean rightFlag = (rightSequence.length == 0 || VerifySquenceOfBST(rightSequence));
    return leftFlag && rightFlag;
  }

  public static void main(String[] args) {
    int[] arr = {5,4,3,2,1};
    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, 3)));
    Solution solution = new Solution();
    solution.VerifySquenceOfBST(arr);
  }
}
