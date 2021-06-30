package com.personal;

/**
 * 二叉树的直径
 * @author liuxiaohan1
 * @date 2021-06-30 3:49 下午
 */
public class lc543 {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left); // 左孩子为根的子树深度
        int r = dfs(root.right);
        res = Math.max(l + r, res);
        return Math.max(l, r) + 1;
    }

}
