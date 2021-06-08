package com.personal;

/**
 * 搜索旋转排序数组
 *
 * @author liuxiaohan1
 * @date 2021-06-08 16:12
 */
public class lc33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left= 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
