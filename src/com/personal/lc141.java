package com.personal;

/**
 * 环形链表-判断链表中是否有环
 *
 * @author liuxiaohan1
 * @date 2021-06-10 16:41
 */
public class lc141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
