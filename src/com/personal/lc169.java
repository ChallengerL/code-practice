package com.personal;

/**
 * 多数元素
 * @author liuxiaohan1
 * @date 2021-07-03 9:20 下午
 */
public class lc169 {

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
                continue;
            }
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

}
