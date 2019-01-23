package com.shoufeng.learn.question42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author shoufeng
 */
public class Solution {
  public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    int num1 = 0;
    int num2 = 0;
    int max = 0;
    boolean isFirst = true;
    for (int i = 0; i < array.length; i++) {
      map.put(Integer.toString(array[i]),array[i]);
    }
    for (int i = 0; i < array.length; i++) {
      if (map.get(Integer.toString(sum - array[i])) != null){
        int nextNum1 = array[i];
        int nextNum2 = map.get(Integer.toString(sum - array[i]));
        if (isFirst){
          num1 = nextNum1;
          num2 = nextNum2;
          max = num1*num2;
          continue;
        }
        if (nextNum1*nextNum2 < max){
          num1 = nextNum1;
          num2 = nextNum2;
          max = num1*num2;
        }
      }
    }
    if (num1 == 0 || num2 == 0){
      return list;
    }
    list.add(num1);
    list.add(num2);
    Collections.sort(list);
    return list;
  }
}
