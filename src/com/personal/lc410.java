package com.personal;

/**
 * 分割数组的最大值
 * @author liuxiaohan1
 * @date 2021-07-08 5:56 下午
 */
public class lc410 {

    public int splitArray(int[] nums, int m) {
        int max_num = 0, max_sum = 0;
        for (int num : nums) {
            if (num > max_num) {
                max_num = num;
            }
            max_sum += num;
        }
        int left = max_num;
        int right = max_sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int split(int[] nums, int max) {
        int splits = 1;
        int curr_sum = 0;
        for (int num : nums) {
            if (curr_sum + num > max) {
                curr_sum = 0;
                splits++;
            }
            curr_sum += num;
        }
        return splits;
    }

}
