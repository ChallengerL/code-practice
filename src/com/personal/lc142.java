package com.personal;

/**
 * 请填写类的描述
 *
 * @author liuxiaohan1
 * @date 2021-06-09 19:01
 */
public class lc142 {

    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return res;
    }
    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
//        if (root.val + left + right > res) {
//            System.out.println(root.val);
//        }
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

}
