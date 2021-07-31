package com.personal;

/**
 * 两个链表的第一个公共节点
 *
 * @author liuxiaohan1
 * @date 2021-07-17 10:48 下午
 */
public class jz52 {

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
