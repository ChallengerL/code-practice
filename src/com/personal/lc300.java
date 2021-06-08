package com.personal;

import java.util.Arrays;

/**
 * @description: 最长递增子序列
 * @author: liuXiaoHan
 * @date: 2021-06-08 23:41
 **/
public class lc300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
