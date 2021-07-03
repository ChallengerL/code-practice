package com.personal;

/**
 * 删除链表中的重复元素
 * @author liuxiaohan1
 * @date 2021-07-03 9:06 下午
 */
public class lc83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

}
