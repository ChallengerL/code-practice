package com.personal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 翻转二叉树
 * @author liuxiaohan1
 * @date 2021-07-03 7:59 下午
 */
public class lc226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree_(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
