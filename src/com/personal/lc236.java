package com.personal;

/**
 * @description: 二叉树的最近公共祖先
 * @author: liuXiaoHan
 * @date: 2021-06-08 00:45
 **/
public class lc236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
