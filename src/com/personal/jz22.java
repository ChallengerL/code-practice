package com.personal;

/**
 * 链表中倒数第k个节点
 * @author liuxiaohan1
 * @date 2021-06-30 8:40 下午
 */
public class jz22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow, fast;
        slow = fast = head;
        int count = 0;
        while (fast != null) {
            // fast 先走 k 步
            if (count >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        return slow;
    }

}
