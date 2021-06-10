package com.personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author liuxiaohan1
 * @date 2021-06-10 18:06
 */
public class lc39 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(candidates, target, 0, path);
        return res;
    }

    public void backtrack(int[] candidates, int target, int begin, LinkedList<Integer> path) {
        //
        if (target < 0) {
            return;
        }
        //
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

}
