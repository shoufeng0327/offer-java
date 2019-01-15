package com.shoufeng.learn.question14;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author shoufeng
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Solution {

  public ListNode FindKthToTail(ListNode head, int k) {
    if (head == null || k == 0){
      return null;
    }
    List<ListNode> list= new ArrayList<>();
    while (head != null){
      list.add(head);
      head = head.next;
    }
    if (k > list.size()){
      return null;
    }
    return list.get(list.size() - k);
  }
}

class ListNode {

  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }
}
