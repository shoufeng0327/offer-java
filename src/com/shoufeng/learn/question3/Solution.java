package com.shoufeng.learn.question3;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 * @author shoufeng
 */

import java.util.ArrayList;

public class Solution {

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> list = new ArrayList<>();
    while (listNode != null){
      list.add(listNode.val);
      listNode = listNode.next;
    }

    for (int i = 0; i < list.size()/2; i++) {
      Integer temp = list.get(i);
      list.set(i,list.get(list.size() - 1 - i));
      list.set(list.size() - 1 - i,temp);
    }
    return list;
  }

  class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
}