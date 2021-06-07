package com.personal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿型层序遍历
 *
 * @author liuxiaohan1
 * @date 2021-06-07 19:55
 */
public class lc103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        //
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftOrder = true;
        while(!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(isLeftOrder) {
                    deque.offerLast(node.val);
                } else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            isLeftOrder = !isLeftOrder;
            res.add(new LinkedList<>(deque));
        }
        return res;
    }

}
