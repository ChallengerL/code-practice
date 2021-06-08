package com.personal;

import java.util.Random;

/**
 * 数组中的第K个最大元素
 *
 * @author liuxiaohan1
 * @date 2021-06-08 10:09
 */
public class lc215 {

    private Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int targrt = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (targrt == index) {
                return nums[index];
            } else if (targrt < index) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        if (left < right) {
            int randomIndex = left + random.nextInt(right - left) + 1;
            swap(nums, left, randomIndex);
        }
        int privot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < privot) {
                lt++;
            }
            while (gt >= left && nums[gt] > privot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
