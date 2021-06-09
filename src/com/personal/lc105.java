package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author liuxiaohan1
 * @date 2021-06-09 17:02
 */
public class lc105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, n - 1, inorder, 0, n - 1, inorderMap);
    }

    public TreeNode build(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end, Map<Integer, Integer> inorderMap) {
        if (pre_start > pre_end || pre_start >= preorder.length) {
            return null;
        }
        int root_val = preorder[pre_start];
        TreeNode root = new TreeNode(root_val);
        int root_inorderIndex = inorderMap.get(root_val);
        int leftNums = root_inorderIndex - in_start;
        root.left = build(preorder, pre_start + 1, pre_start + leftNums, inorder, in_start, root_inorderIndex - 1, inorderMap);
        root.right = build(preorder, pre_start + leftNums + 1, pre_end, inorder, root_inorderIndex + 1, in_end, inorderMap);
        return root;
    }

}
