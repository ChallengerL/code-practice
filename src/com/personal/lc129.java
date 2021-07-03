package com.personal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 球根节点到叶节点数字之和
 * @author liuxiaohan1
 * @date 2021-07-03 12:37 下午
 */
public class lc129 {

    // 递归
    public int sumNumbers_(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int res = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return res;
        }
        return dfs(root.left, res) + dfs(root.right, res);
    }

    // 非递归
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 叶节点就收集答案
                if (node.left == null && node.right == null) {
                    res += node.val;
                }
                if (node.left != null) {
                    node.left.val += node.val * 10;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val += node.val * 10;
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

}
