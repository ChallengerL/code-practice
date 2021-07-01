package com.personal;

/**
 * 删除链表的倒数第 N 个结点
 * @author liuxiaohan1
 * @date 2021-07-01 2:30 下午
 */
public class lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow, fast;
        slow = fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
