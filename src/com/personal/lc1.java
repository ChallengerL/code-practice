package com.personal;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author liuxiaohan1
 * @date 2021-06-10 11:34
 */
public class lc1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

}
