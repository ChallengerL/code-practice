package com.personal;

/**
 * 相交链表
 *
 * @author liuxiaohan1
 * @date 2021-06-07 20:47
 */
public class lc160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2) {
            if (head1 == null) {
                head1 = headB;
            } else {
                head1 = head1.next;
            }
            if (head2 == null) {
                head2 = headA;
            } else {
                head2 = head2.next;
            }
        }
        return head1;
    }

}
