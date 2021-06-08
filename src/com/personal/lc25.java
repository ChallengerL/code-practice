package com.personal;

/**
 * K 个一组翻转链表，不足 K 个不需要反转
 *
 * @author liuxiaohan1
 * @date 2021-06-07 16:33
 */
public class lc25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = head;
        b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            // 不足 k 个也要反转
//            if (b == null) {
//                return reverse(a, b);
//            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
