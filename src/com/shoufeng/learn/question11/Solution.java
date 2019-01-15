package com.shoufeng.learn.question11;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author shoufeng
 */
public class Solution {

  public int NumberOf1(int n) {
//    return Integer.toBinaryString(n).replace("0","").length();
    int count = 0;
    while (n != 0){
      n = n&(n-1);
      count++;
    }
    return count;
  }
}
