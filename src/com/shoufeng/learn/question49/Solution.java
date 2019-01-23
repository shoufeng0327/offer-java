package com.shoufeng.learn.question49;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能， 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author shoufeng
 */
public class Solution {

  public int StrToInt(String str) {
    if (str == null){
      return 0;
    }
    int len = str.length();
    if (len == 0){
      return 0;
    }
    char[] chars = str.toCharArray();
    if (chars[0] != '+' && chars[0] != '-' && (chars[0] < 48 || chars[0] > 57)) {
      return 0;
    }
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] < 48 || chars[i] > 57) {
        return 0;
      }
    }
    double sum = 0;
    if (chars[0] == '+' || chars[0] == '-') {
      for (int i = 1; i < len; i++) {
        sum = sum + Math.pow(10, len - 1 - i) * (chars[i] - 48);
      }
      if (chars[0] == '-') {
        sum = 0 - sum;
      }
      return (int) sum;
    }

    for (int i = 0; i < len; i++) {
      sum = sum + Math.pow(10, len - 1 - i) * (chars[i] - 48);
    }
    return (int) sum;
  }

  public static void main(String[] args) {
    System.out.println('0' - 0);
    Solution solution = new Solution();
    System.out.println(solution.StrToInt("111"));
  }
}
