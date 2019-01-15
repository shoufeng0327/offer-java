package com.shoufeng.learn.question13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序， 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author shoufeng
 */
public class Solution {

  public void reOrderArray(int[] array) {
    List<Integer> evenList = new ArrayList<>();
    List<Integer> oddList = new ArrayList<>();
    for (int i : array) {
      if (i%2 == 0){
        evenList.add(i);
        continue;
      }
      oddList.add(i);
    }
    oddList.addAll(evenList);
    for (int i = 0; i < oddList.size(); i++) {
      array[i] = oddList.get(i);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] array = {1,2,3,4,5,6,7};
    solution.reOrderArray(array);
    System.out.println(Arrays.toString(array));
  }
}
