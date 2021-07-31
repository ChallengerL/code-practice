package com.personal;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * @author liuxiaohan1
 * @date 2021-07-17 5:43 下午
 */
public class lc217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
