package com.shoufeng.learn.question44;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author shoufeng
 */
public class Solution {
  public String ReverseSentence(String str) {
    if (str == null || str.length() == 0){
      return "";
    }
    if (str.length() == 1){
      return str;
    }
    String[] splitStrs = str.split(" ");
    if (splitStrs.length == 0){
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        sb.append(" ");
      }
      return sb.toString();
    }
    for (int i = 0; i < splitStrs.length/2; i++) {
      String temp = splitStrs[splitStrs.length - 1 - i];
      splitStrs[splitStrs.length - 1 - i] = splitStrs[i];
      splitStrs[i] = temp;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < splitStrs.length - 1; i++) {
      sb.append(splitStrs[i]).append(" ");
    }
    sb.append(splitStrs[splitStrs.length - 1]);
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.ReverseSentence(" ");
  }
}
