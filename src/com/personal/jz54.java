package com.personal;

/**
 * 二叉搜索树的第k大节点
 * @author liuxiaohan1
 * @date 2021-07-03 4:37 下午
 */
public class jz54 {

    int res, count;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    public void dfs (TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        dfs(root.left, k);
    }

}
