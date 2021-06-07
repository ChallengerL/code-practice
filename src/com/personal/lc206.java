package com.personal;

/**
 * 反转链表，递归解法
 *
 * @author liuxiaohan1
 * @date 2021-06-07 19:46
 */
public class lc206 {

    // 迭代
    public ListNode reverseList_(ListNode head) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
