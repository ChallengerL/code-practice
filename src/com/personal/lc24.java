package com.personal;

/**
 * 两两交换链表中的节点
 * @author liuxiaohan1
 * @date 2021-07-02 5:14 下午
 */
public class lc24 {

    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代
    public ListNode swapPairs_(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node2;
        }
        return dummyHead.next;
    }

}
