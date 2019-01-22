package com.shoufeng.learn.question34;


/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @author shoufeng
 */
public class Solution {
  public int FirstNotRepeatingChar(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      StringBuilder sb = new StringBuilder();
      for (int i1 = 0; i1 < chars.length; i1++) {
        if (i1 != i){
          sb.append(chars[i1]);
        }
      }
      if (!sb.toString().contains(String.valueOf(c))){
        return i;
      }
    }
    return -1;
  }
}
