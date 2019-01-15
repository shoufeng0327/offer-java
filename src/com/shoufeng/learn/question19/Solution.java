package com.shoufeng.learn.question19;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author shoufeng
 */
public class Solution {
  public ArrayList<Integer> printMatrix(int [][] matrix) {
    /*
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     */
    if (matrix == null){
      return null;
    }
    ArrayList<Integer> list = new ArrayList<>();
    int high = matrix[0].length;
    int width = matrix.length;
    if (width == 1){
      for (int i = 0; i < high; i++) {
        list.add(matrix[0][i]);
      }
      return list;
    }
    if (high == 1){
      for (int i = 0; i < width; i++) {
        list.add(matrix[i][0]);
      }
      return list;
    }
    if (width == 2){
      for (int i = 0; i < high; i++) {
        list.add(matrix[0][i]);
      }
      for (int i = 0; i < high; i++) {
        list.add(matrix[1][high - 1 - i]);
      }
      return list;
    }
    if (high == 2){
      list.add(matrix[0][0]);
      list.add(matrix[0][1]);
      for (int i = 1; i < width; i++) {
        list.add(matrix[i][1]);
      }
      list.add(matrix[width - 1][0]);
      for (int i = 1; i < width - 1; i++) {
        list.add(matrix[width - 1 - i][0]);
      }
      return list;
    }
    for (int i = 0; i < high; i++) {
      list.add(matrix[0][i]);
    }
    for (int i = 1; i < width; i++) {
      list.add(matrix[i][high - 1]);
    }
    for (int i = 1; i < high; i++) {
      list.add(matrix[width - 1][high - 1 - i]);
    }
    for (int i = 1; i < width - 1; i++) {
      list.add(matrix[width - 1 - i ][0]);
    }
    int[][] nextMatrix = new int[width - 2][high -2];
    for (int i = 1; i < width - 1; i++) {
      for (int j = 1; j < high - 1; j++) {
        nextMatrix[i-1][j-1] = matrix[i][j];
      }
    }
    list.addAll(printMatrix(nextMatrix));
    return list;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    //int[][] para = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    int[][] para = {{1},{2},{3},{4},{5}};
    System.out.println(solution.printMatrix(para).toString());
  }
}
