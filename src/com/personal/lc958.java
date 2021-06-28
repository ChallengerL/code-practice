package com.personal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性校验
 * @author liuxiaohan1
 * @date 2021-06-28 5:35 下午
 */
public class lc958 {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 完全二叉树层次遍历的最后一个节点
        boolean reachedEnd = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // 如果之前到达了最后一个节点，但后面还有非空节点，则不是一颗完全二叉树
            if (reachedEnd && curr != null) {
                return false;
            }
            if (curr == null) {
                reachedEnd = true;
                continue;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);

        }
        return true;
    }

}
