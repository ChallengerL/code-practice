package com.personal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 两个数组的交集
 * @author liuxiaohan1
 * @date 2021-07-12 5:02 下午
 */
public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i] = integer;
            i++;
        }
        return res;
    }
}
