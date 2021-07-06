package com.personal;

/**
 * 分隔链表
 * @author liuxiaohan1
 * @date 2021-07-06 10:47 上午
 */
public class lc86 {

    public ListNode partition(ListNode head, int x) {
        ListNode small= new ListNode(-1);
        ListNode smallHead = small;
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val <= x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

}
