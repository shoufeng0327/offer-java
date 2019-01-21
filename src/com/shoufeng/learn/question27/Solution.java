package com.shoufeng.learn.question27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author shoufeng
 */
public class Solution {

  Set<String> stringSet = new HashSet<>();
  public ArrayList<String> Permutation(String str) {
    char[] chars = str.toCharArray();
    PermutationHelper(chars,0);
    ArrayList<String> list = new ArrayList<>(stringSet);
    Collections.sort(list);
    return list;
  }

  private void PermutationHelper(char[] chars, int index){
    if (index == chars.length -1){
      stringSet.add(String.valueOf(chars));
    }
    for (int i = index; i < chars.length; i++) {
      swap(chars,index,i);
      PermutationHelper(chars,index + 1);
      swap(chars,index,i);
    }
  }

  public void swap(char[] cs, int i, int j) {
    char temp = cs[i];
    cs[i] = cs[j];
    cs[j] = temp;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.Permutation("abc").toArray()));
  }
}
