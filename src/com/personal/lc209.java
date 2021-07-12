package com.personal;

/**
 * 长度最小的子数组
 * @author liuxiaohan1
 * @date 2021-07-09 9:42 下午
 */
public class lc209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                if (sum == target   ) {
                    res = Math.min(res, end - start + 1);
                }
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
