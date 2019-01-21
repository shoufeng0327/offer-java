package com.shoufeng.learn.question32;


/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author shoufeng
 */
public class Solution {
  public String PrintMinNumber(int [] numbers) {
    String[] numbersStrs = new String[numbers.length];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numbers.length; i++) {
      numbersStrs[i] = Long.toString(numbers[i]);
    }
    for (int i = 0; i < numbersStrs.length; i++) {
      for (int i1 = 0; i1 < numbersStrs.length - 1 - i; i1++) {
        String leftAdd = numbersStrs[i1] + numbersStrs[i1 + 1];
        String rightAdd = numbersStrs[i1 + 1] + numbersStrs[i1];
        if (Long.valueOf(leftAdd) > Long.valueOf(rightAdd)){
          String temp = numbersStrs[i1];
          numbersStrs[i1] = numbersStrs[i1+1];
          numbersStrs[i1+1] = temp;
        }
      }
    }
    for (int i = 0; i < numbersStrs.length; i++) {
      sb.append(numbersStrs[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {3,32,321};
    System.out.println(solution.PrintMinNumber(arr));
  }
}
