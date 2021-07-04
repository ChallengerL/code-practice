package com.personal;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author liuxiaohan1
 * @date 2021-07-04 2:01 下午
 */
public class lc34 {

    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                left = mid;
                right = mid;
                break;
            }
        }
        if (left == -1) {
            return new int[]{-1, -1};
        }
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
            right++;
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;
        lc34 lc34 = new lc34();
        int[] ints = lc34.searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
