package com.shoufeng.learn.question36;

/**
 * 输入两个链表，找出它们的第一个公共结点。
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

  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    if (pHead1 == null || pHead2 == null){
      return null;
    }
    ListNode copyPhead1 = pHead1;
    ListNode copyPhead2 = pHead2;
    int pHead1Len = 0;
    int pHead2Len = 0;
    while (copyPhead1.next != null){
      pHead1Len++;
      copyPhead1 = copyPhead1.next;
    }
    while (copyPhead2.next != null){
      pHead2Len++;
      copyPhead2 = copyPhead2.next;
    }
    if (pHead1Len - pHead2Len >= 0){
      int len = pHead1Len - pHead2Len;
      while (len > 0){
        pHead1 = pHead1.next;
        len--;
      }
      while (pHead2Len >= 0){
        if (pHead1 == pHead2){
          return pHead1;
        }
        pHead1 = pHead1.next;
        pHead2 = pHead2.next;
        pHead2Len--;
      }
    }else {
      int len = pHead2Len - pHead1Len;
      while (len > 0){
        pHead2 = pHead2.next;
        len--;
      }
      while (pHead1Len >= 0){
        if (pHead1 == pHead2){
          return pHead1;
        }
        pHead1 = pHead1.next;
        pHead2 = pHead2.next;
        pHead1Len--;
      }
    }
    return null;
  }

  public class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
}