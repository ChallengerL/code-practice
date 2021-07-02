package com.personal;

/**
 * 奇偶链表
 * @author liuxiaohan1
 * @date 2021-07-02 4:53 下午
 */
public class lc328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
