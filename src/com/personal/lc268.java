package com.personal;

/**
 * 丢失的数字
 * @author liuxiaohan1
 * @date 2021-07-06 4:02 下午
 */
public class lc268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        for (int i = 0; i < n; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }

}
