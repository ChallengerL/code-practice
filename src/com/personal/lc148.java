package com.personal;

import java.util.List;

/**
 * 排序链表
 * @author liuxiaohan1
 * @date 2021-06-28 6:22 下午
 */
public class lc148 {

    /**
     * 归并排序-递归
     * @param head
     * @return
     */
    public ListNode sortList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList_1(head);
        ListNode right = sortList_1(rightHead);

        return mergeTwoLists(left, right);
    }

    // lc876(链表节点的中点)
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // lc21(合并两个有序链表)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 归并排序-非递归
     * @param head
     * @return
     */
    public ListNode sortList_2(ListNode head) {
        int length = getLength(head);
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        for (int step = 1; step < length; step *= 2) {
            ListNode pre = dummyNode;
            ListNode cur = dummyNode.next;
            while (cur != null) {
                ListNode l1 = cur; // 第一部分头（第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块）
                ListNode l2 = split(l1, step); // 第二部分头
                cur = split(l2, step); // 剩余部分的头
                ListNode temp = mergeTwoLists(l1, l2); // 将一二部分合并
                pre.next = temp; // 将前面部分与排序好的部分连接
                while (pre.next != null) {
                    pre = pre.next; // 把pre指针移动到排序好部分的末尾
                }
            }
        }
        return dummyNode.next;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode split(ListNode head, int step) {
        if (head == null) return head;
        ListNode cur = head;
        for (int i = 1; i < step; i++) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null; // 断开连接
        return right;
    }

    /**
     * 快排
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {

        return quickSort(head, null);
    }

    public static ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) return head;
        ListNode cur = head.next;
        // lHead维护的是小于基准值的头插指针，uTail维护的是大于等于基准值的尾插指针
        ListNode lHead = head, uTail = head;
        while (cur != end) {
            ListNode next = cur.next;
            if (cur.val < head.val) { // 头插
                cur.next = lHead;
                lHead = cur;
            } else { // 尾插
                uTail.next = cur;
                uTail = cur;
            }
            cur = next;
        }
        uTail.next = end;
        ListNode node = quickSort(lHead, head);
        head.next = quickSort(head.next, end);
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode0 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode0;
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        ListNode res = sortList(listNode);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);
    }

}
