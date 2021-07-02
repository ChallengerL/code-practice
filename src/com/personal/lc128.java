package com.personal;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 最长连续序列
 * @author: liuXiaoHan
 * @date: 2021-07-02 21:20
 **/
public class lc128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int len = 0;
                while (set.contains(num)) {
                    num++;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }

}
