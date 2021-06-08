package com.personal;

/**
 * 重排链表
 *
 * @author liuxiaohan1
 * @date 2021-06-08 20:39
 */
public class lc143 {

    public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp;
        ListNode l2_temp;
        while (l1 != null && l2 != null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }
    }

}
