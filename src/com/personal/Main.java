package com.personal;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        additional1 solution = new additional1();
        ListNode resList = solution.sortOddEvenList(head);
        System.out.println(resList.val);
        System.out.println(resList.next.val);
        System.out.println(resList.next.next.val);
        System.out.println(resList.next.next.next.val);
        System.out.println(resList.next.next.next.next.val);
        System.out.println(resList.next.next.next.next.next.val);
        System.out.println(resList.next.next.next.next.next.next.val);
        System.out.println(resList.next.next.next.next.next.next.next.val);
    }
}
