package com.personal;

/**
 * 打家劫舍
 * @author liuxiaohan1
 * @date 2021-06-26 4:31 下午
 */
public class lc198 {

    public int rob_(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int res = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int num : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(cur, pre + num);
            pre = cur;
            cur = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }
        return cur;
    }

}
