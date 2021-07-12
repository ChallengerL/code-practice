package com.personal;

/**
 * 另一个树的子树
 * @author liuxiaohan1
 * @date 2021-07-12 7:59 下午
 */
public class lc572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else return false;
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) {
            return false;
        }
        return isSameTree(root.left, root.right) && isSameTree(root.right, root.right);
    }

}
