package com.personal;

import java.util.Stack;

/**
 * 验证二叉搜索树
 *
 * @author liuxiaohan1
 * @date 2021-06-10 21:01
 */
public class lc98 {

    // 递归
    public boolean isValidBST_1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 中序遍历
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    // 中序非递归
    public boolean isValidBST_(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inOrder = Long.MIN_VALUE;
        while (!stack.isEmpty() || root!= null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder) {
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

}
