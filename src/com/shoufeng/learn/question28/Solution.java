package com.shoufeng.learn.question28;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author shoufeng
 */

public class Solution {
  public int MoreThanHalfNum_Solution(int [] array) {
    for (int i = 0; i < array.length/2 + 1; i++) {
      int times = array.length/2 + 1;
      for (int i1 = 0; i1 < array.length; i1++) {
        if (array[i] == array[i1]){
          times--;
        }
        if (times == 0){
          return array[i];
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] arr = {1,3,4,5,2,2,2,2,2};
    Solution solution = new Solution();
    System.out.println(solution.MoreThanHalfNum_Solution(arr));
  }
}
