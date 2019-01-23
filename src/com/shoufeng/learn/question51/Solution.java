package com.shoufeng.learn.question51;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author shoufeng
 */
public class Solution {
  public int[] multiply(int[] A) {
    if (A == null || A.length == 0){
      return null;
    }
    int[] B = new int[A.length];
    for (int i = 0; i < B.length; i++) {
      if (i == 0){
        B[0] = 1;
        continue;
      }
      B[i] = B[i-1]*A[i-1];
    }
    int temp = 1;
    for (int i = 0; i < B.length; i++) {
      B[B.length - 1 - i] = B[B.length - 1 - i]*temp;
      temp = A[A.length - 1 - i]*temp;
    }
    return B;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {1,2,3,4,5};
    System.out.println(Arrays.toString(solution.multiply(arr)));
  }
}
