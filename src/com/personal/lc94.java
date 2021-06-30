package com.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * @author liuxiaohan1
 * @date 2021-06-30 7:51 下午
 */
public class lc94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode curr = stack.pop();
                res.add(curr.val);
                root = curr.right;
            }
        }
        return res;
    }

}
