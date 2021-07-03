package com.personal;

/**
 * 二叉搜索树与双向链表
 * @author liuxiaohan1
 * @date 2021-07-03 4:57 下午
 */
public class jz36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node head;
    public Node treeToDoublyList(Node root) {
        return head;
    }
}
