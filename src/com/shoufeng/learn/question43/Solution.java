package com.shoufeng.learn.question43;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 * @author shoufeng
 */
public class Solution {

  public String LeftRotateString(String str, int n) {
    if (str == null || str.length() == 0){
      return "";
    }
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i],i);
    }
    int times = n % str.length();
    for (Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
      if (characterIntegerEntry.getValue() - times < 0){
        chars[characterIntegerEntry.getValue() + chars.length - times] = characterIntegerEntry.getKey();
      }else {
        chars[characterIntegerEntry.getValue() - times] = characterIntegerEntry.getKey();
      }
    }
    return new String(chars);
  }
}
