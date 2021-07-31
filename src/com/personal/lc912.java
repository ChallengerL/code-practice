package com.personal;

import java.util.Random;

/**
 * 手撕快速排序、堆排序、归并排序、递归插入排序
 * @author liuxiaohan1
 * @date 2021-06-27 5:13 下午
 */
public class lc912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
