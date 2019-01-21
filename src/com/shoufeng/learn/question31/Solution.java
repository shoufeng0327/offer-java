package com.shoufeng.learn.question31;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 思路: 假设输入数字是13，个位数为1出现的次数(11，01，两次)，十位数为1出现的次数(10,11,12,13)
 * 总结: 当前位数>1的话，当前位数为1出现的次数为( 数字高位 + 1)*级数,若是为1则为( 数字高位)*级数 + 数字低位，
 *       如果为0则为( 数字高位)*级数
 * @author shoufeng
 */
public class Solution {
  /*
 0  1  2  3  4  5  6  7  8  9
 10 11 12 13 14 15 16 17 18 19
 20 21 22 23 24 25 26 27 28 29
   */
  public int NumberOf1Between1AndN_Solution(int n) {
    int count = 0;
    for (int i = 1; i <= n; i = i*10) {
      int leftWithIndex = n / i;
      int index = leftWithIndex % 10;
      int left = leftWithIndex/10;
      int right = n%i;
      switch (index){
        case 0 : {
          count = count + left*i;
          break;
        }
        case 1 : {
          count = count + left*i + right + 1;
          break;
        }
        default:{
          count = count + (left + 1)*i;
        }
      }

    }
    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.NumberOf1Between1AndN_Solution(13));
  }
}
