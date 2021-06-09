package com.personal;

import java.util.List;

/**
 * 反转链表Ⅱ-区间
 *
 * @author liuxiaohan1
 * @date 2021-06-09 18:13
 */
public class lc92 {

    // 迭代 - 头插法
    public ListNode reverseBetween_(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur, next;
        cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    // 递归
    int i = 0;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        i++;
        if (i == right) {
            return head;
        }
        if (i < left) {
            head.next = reverseBetween(head.next, left, right);
            return head;
        } else {
            ListNode last = reverseBetween(head.next, left, right);
            ListNode next = head.next.next;
            head.next.next = head;
            head.next = next;
            return last;
        }
    }

}
