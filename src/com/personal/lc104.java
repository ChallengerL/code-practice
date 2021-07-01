package com.personal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liuxiaohan1
 * @date 2021-07-01 3:19 下午
 */
public class lc104 {

    // 非递归
    public int maxDepth_(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.pollFirst();
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
                }
            }
            height++;
        }
        return height;
    }

    // 递归
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = dfs(root.left);
            int right = dfs(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
