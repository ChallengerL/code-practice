package com.personal;

/**
 * 寻找旋转排序数组中的最小值
 * @author liuxiaohan1
 * @date 2021-07-04 3:20 下午
 */
public class lc153 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
