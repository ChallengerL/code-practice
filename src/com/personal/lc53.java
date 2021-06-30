package com.personal;

import java.util.Arrays;

/**
 * 最大子序和
 * @author liuxiaohan1
 * @date 2021-06-30 1:57 下午
 */
public class lc53 {

    public int maxSubArray_(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 状态压缩
    public int maxSubArray_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int subMax = nums[0];
        int res = subMax;
        for (int i = 0; i < nums.length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
            } else {
                subMax = nums[i];
            }
            res = Math.max(res, subMax);
        }
        return res;
    }

    public int[] maxSubArray(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums;
        }
        int left = 0, right = 0;
        int resLeft = 0, resRight = 0;
        int subMax = nums[0];
        int res = subMax;
        for (int i = 0; i < nums.length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
                right = i;
            } else {
                subMax = nums[i];
                left = i;
            }
            res = Math.max(res, subMax);
            resLeft = left;
            resRight = right;
        }
        return Arrays.copyOfRange(nums, resLeft, resRight - 1);
    }

    public static void main(String[] args) {
        lc53 lc53 = new lc53();
        int[] nums = new int[]{1};
        int[] res = lc53.maxSubArray(nums);
        System.out.println(Arrays.toString(res));
    }

}
