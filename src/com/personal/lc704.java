package com.personal;

import java.util.Arrays;

/**
 * 二分查找
 * @author liuxiaohan1
 * @date 2021-06-30 8:10 下午
 */
public class lc704 {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
