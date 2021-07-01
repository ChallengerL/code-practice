package com.personal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author liuxiaohan1
 * @date 2021-07-01 2:46 下午
 */
public class lc144 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            res.add(node.val);
            if (node.left != null) {
                stack.offerFirst(node.left);
            }
            if (node.right != null) {
                stack.offerLast(node.right);
            }
        }
        return res;
    }

}
