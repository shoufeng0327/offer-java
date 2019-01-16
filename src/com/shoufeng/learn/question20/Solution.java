package com.shoufeng.learn.question20;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author shoufeng
 */
public class Solution {

  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();
  private Integer min;

  public void push(int node) {
    if (min == null || min > node){
      min = node;
    }
    stack.push(node);
    minStack.push(min);
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int min() {
    if (minStack.peek() > min){
      min = minStack.peek();
    }
    return min;
  }

}
