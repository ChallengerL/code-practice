package com.personal;

/**
 * 下一个排列
 *
 * @author liuxiaohan1
 * @date 2021-06-08 17:47
 */
public class lc31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
