package com.shoufeng.learn.question21;

import java.util.HashMap;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author shoufeng
 */
public class Solution {

  public boolean IsPopOrder(int[] pushA, int[] popA) {
    boolean[] status = new boolean[pushA.length];
    boolean isFirst = true;
    HashMap<Integer, Integer> pushMap = new HashMap<>();
    for (int i = 0; i < pushA.length; i++) {
      pushMap.put(pushA[i], i);
    }
    for (int popValue : popA) {
      if (isFirst) {
        Integer index = pushMap.get(popValue);
        if (index == null){
          return false;
        }
        status[index] = true;
        isFirst = false;
      } else {
        Integer index = pushMap.get(popValue);
        if (index == null){
          return false;
        }
        status[index] = true;

        if (index == (pushA.length - 1)) {
          continue;
        } else {
          for (int i = index + 1; i < pushA.length; i++) {
            if (!status[i]) {
              return false;
            }
          }
        }

        if (index == 0) {
          if (!status[1]) {
            return false;
          }
        }

        if (index > 0 && index < pushA.length - 1) {
          if (!status[index - 1] && !status[index + 1]) {
            return false;
          }
        }
      }
    }

    for (boolean b : status) {
      if (!b) {
        return b;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] pushA = {1, 2, 3, 4, 5};
    int[] popA = {3,5,4,2,1};
    Solution solution = new Solution();
    System.out.println(solution.IsPopOrder(pushA, popA));

  }
}
