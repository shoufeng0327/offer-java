package com.shoufeng.learn.question15;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
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

  public ListNode ReverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode currentNode = head;
    ListNode preNode = null;
    while (currentNode.next != null){
      ListNode temp = currentNode.next;
      currentNode.next = preNode;
      preNode = currentNode;
      currentNode = temp;
    }
    currentNode.next = preNode;
    return currentNode;
  }

  public class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
}
