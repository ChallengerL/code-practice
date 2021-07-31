package com.personal;

/**
 * 相同的树
 * @author liuxiaohan1
 * @date 2021-07-15 10:30 上午
 */
public class lc100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
