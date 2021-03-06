package com.personal;

/**
 * 两数相加（链表）
 * @author liuxiaohan1
 * @date 2021-06-27 5:06 下午
 */
public class lc2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry = carry / 10;
        }
        return pre.next;
    }

}
