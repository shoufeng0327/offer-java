package com.shoufeng.learn.question40;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * @author shoufeng
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : array) {
      if (map.get(i) == null){
        map.put(i,1);
        continue;
      }
      int nextValue = map.get(i) + 1;
      map.put(i,nextValue);
    }
    boolean isFirstDone = false;
    boolean isSecondDone = false;
    for (Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
      if (integerIntegerEntry.getValue()%2 != 0){
        if (!isFirstDone){
          num1[0] = integerIntegerEntry.getKey();
          isFirstDone = true;
          continue;
        }
        if (!isSecondDone){
          num2[0] = integerIntegerEntry.getKey();
          isSecondDone = true;
          continue;
        }
        if (isFirstDone&&isSecondDone){
          return;
        }
      }
    }
  }
}
