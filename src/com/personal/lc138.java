package com.personal;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 * @author liuxiaohan1
 * @date 2021-07-02 5:55 下午
 */
public class lc138 {

    HashMap<Node, Node> visited = new HashMap<>();
    // 递归
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node node = new Node(head.val);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    // 迭代
    public Node copyRandomList_(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        while (p != null) {
            p.next.random = (p.random == null) ? null : p.random.next;
            p = p.next.next;
        }
        Node p_old = head;
        Node p_new = head.next;
        Node res = head.next;
        while (p_old != null) {
            p_old.next = p_old.next.next;
            p_new.next = p_new.next == null ? null : p_new.next.next;
            p_old = p_old.next;
            p_new = p_new.next;
        }
        return res;
    }

}
