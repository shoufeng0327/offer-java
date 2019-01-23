package com.shoufeng.learn.question37;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author shoufeng
 */
public class Solution {

  public int GetNumberOfK(int[] array, int k) {
    int count = 0;
    if (array == null || array.length == 0){
      return 0;
    }
    if (array.length == 1){
      if (array[0] == k){
        return 1;
      }else {
        return 0;
      }
    }
    if (array.length == 2){
      int c = 0;
      for (int i = 0; i < array.length; i++) {
        if (array[i] == k){
          c++;
        }
      }
      return c;
    }
    int len = array.length / 2;
    if (k == array[len]) {
      count++;
      for (int i = len - 1; i >= 0; i--) {
        if (array[i] == k) {
          count++;
        } else {
          break;
        }
      }
      for (int i = len + 1; i < array.length; i++) {
        if (array[i] == k) {
          count++;
        } else {
          break;
        }
      }
    }else {
      int[] leftArr = new int[len];
      int[] rightArr = new int[array.length - len];
      for (int i = 0; i < array.length; i++) {
        if (i<len){
          leftArr[i]=array[i];
        }else {
          rightArr[i-len] = array[i];
        }
      }
      int leftCount = GetNumberOfK(leftArr, k);
      int rightCount = GetNumberOfK(rightArr, k);
      count = count + leftCount + rightCount;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {3,3,3,3,4,5};
    System.out.println(solution.GetNumberOfK(arr,3));
  }
}
