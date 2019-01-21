package com.shoufeng.learn.question30;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author shoufeng
 */
public class Solution {
  public int FindGreatestSumOfSubArray(int[] array) {
    if (array.length == 0){
      return 0;
    }
    //全负数
    boolean isAllNegative = true;
    //有负数有正数
    int startAt = 0;
    int endAt = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] >= 0){
        startAt = i;
        endAt = i;
        isAllNegative = false;
        break;
      }
    }
    //全负数取最大和逻辑
    if (isAllNegative){
      int max = array[0];
      for (int i = 0; i < array.length; i++) {
        if (max < array[i]){
          max = array[i];
        }
      }
      return max;
    }
    //有负数有正数
    for (int i = startAt; i < array.length; i++) {
      int leftSum = 0;
      for (int j = startAt; j <= i; j++) {
        leftSum = leftSum + array[j];
      }
      if (leftSum <= 0 && i + 1 < array.length && array[i + 1] > array[startAt]){
        startAt = i + 1;
        endAt = startAt;
      }
      int nowMaxSum = 0;
      for (int j = startAt; j <= endAt; j++) {
        nowMaxSum = nowMaxSum + array[j];
      }
      int nowSum = 0;
      for (int j = startAt; j <= i ; j++) {
        nowSum = nowSum + array[j];
      }

      if (nowSum > nowMaxSum){
        endAt = i;
      }
    }

    int max = 0;
    for (int i = startAt; i <= endAt; i++) {
      max = max + array[i];
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {6,-3,-2,7,-15,1,2,2};
    Solution solution = new Solution();
    System.out.println(solution.FindGreatestSumOfSubArray(arr));
  }
}
