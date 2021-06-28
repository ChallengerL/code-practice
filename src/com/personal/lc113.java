package com.personal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和
 * @author liuxiaohan1
 * @date 2021-06-28 9:31 下午
 */
public class lc113 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.removeLast();
    }
}
