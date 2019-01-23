package com.shoufeng.learn.question48;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author shoufeng
 */
public class Solution {
  public int Add(int num1,int num2) {
//    BigDecimal bigDecimal1 = new BigDecimal(num1);
//    BigDecimal bigDecimal2 = new BigDecimal(num2);
//    return Integer.valueOf(bigDecimal1.add(bigDecimal2).toBigInteger().toString());
    //进位
    int temp1 = (num1 & num2) << 1;
    //余位
    int temp2 = num1^num2;
    return temp1 + temp2;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.Add(7,11));
  }
}
