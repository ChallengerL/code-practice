package com.personal;

/**
 * @description: 合并两个有序链表
 * @author: liuXiaoHan
 * @date: 2021-06-08 23:15
 **/
public class lc21 {

    // 迭代
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            //
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归要想到中止条件
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

}
