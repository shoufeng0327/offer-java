package com.shoufeng.learn.question35;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007 思路: 利用归并排序
 *
 * @author shoufeng
 */
public class Solution {

  static int count = 0;

  public int InversePairs(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] copyArr = new int[array.length];
    InversePairsCore(array, copyArr, 0, array.length - 1);
    return count;

  }

  private static int InversePairsCore(int[] array, int[] copyArr, int low, int high) {
    if (low == high) {
      return 0;
    }
    int mid = (low + high) / 2;
    InversePairsCore(array, copyArr, low, mid);
    InversePairsCore(array, copyArr, mid + 1, high);
    int i = mid;
    int j = high;
    int copyIndex = high;
    while (i >= low && j > mid) {
      if (array[i] > array[j]) {
        copyArr[copyIndex] = array[i];
        count = count + j - mid;
        count = count%1000000007;
        copyIndex--;
        i--;
      } else {
        copyArr[copyIndex] = array[j];
        copyIndex--;
        j--;
      }
    }
    while (i>=low){
      copyArr[copyIndex]=array[i];
      copyIndex--;
      i--;
    }
    while (j>mid){
      copyArr[copyIndex]=array[j];
      copyIndex--;
      j--;
    }
    if (high + 1 - low >= 0) {
      System.arraycopy(copyArr, low, array, low, high + 1 - low);
    }
    count = count % 1000000007;
    return count;
  }

  public static void main(String[] args) {
    int[] arr = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301,
        601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149,
        588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739,
        288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973,
        958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235,
        187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
    Solution solution = new Solution();
    System.out.println(solution.InversePairs(arr));
  }
}
