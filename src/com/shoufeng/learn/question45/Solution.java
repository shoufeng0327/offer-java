package com.shoufeng.learn.question45;

import java.util.ArrayList;
import java.util.Collections;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * @author shoufeng
 */
public class Solution {
  public boolean isContinuous(int [] numbers) {
    if (numbers == null || numbers.length == 0){
      return false;
    }
    int hasZeroNum = 0;
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] != 0){
        list.add(numbers[i]);
        continue;
      }
      hasZeroNum++;
    }
    Collections.sort(list);
    for (int i = 0; i < list.size() - 1; i++) {
      int needZero = (Math.abs(list.get(i + 1) - list.get(i)) - 1);
      if (needZero < 0){
        return false;
      }
      hasZeroNum = hasZeroNum - needZero;
      if (hasZeroNum < 0){
        return false;
      }
    }
    return true;
  }
}
