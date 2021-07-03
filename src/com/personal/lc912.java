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
        int lt = left + 1, gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while (gt > left && nums[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
//        for (int i = left + 1; i <= right; i++) {
//            // 和当前位置前面的第一个大于pivot的位置进行交换，保证最后lt的位置之前的值都小于pivot
//            if (nums[i] < pivot) {
//                lt++;
//                swap(nums, i, lt);
//            }
//        }
        // gt的位置一定是小于pivot的
        swap(nums, left, gt);
        return gt;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
