package com.shoufeng.learn.question29;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author shoufeng
 */
public class Solution {
  public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    if (k > input.length || k <= 0){
      return list;
    }
    for (int i = 0; i < input.length; i++) {
      for (int i1 = 0; i1 < input.length - 1 - i; i1++) {
        if (input[i1 + 1] > input[i1]){
          int temp = input[i1];
          input[i1] = input[i1 + 1];
          input[i1 + 1] = temp;
        }
      }
      list.add(input[input.length - 1 - i]);
      k--;
      if (k == 0){
        return list;
      }
    }
    return list;
  }

  public static void main(String[] args) {
    int[] arr = {4,5,1,6,2,7,3,8};
    Solution solution = new Solution();
    System.out.println(solution.GetLeastNumbers_Solution(arr,0));
  }
}
