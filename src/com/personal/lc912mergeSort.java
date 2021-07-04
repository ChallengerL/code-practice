package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-07-04 5:56 下午
 */
public class lc912mergeSort {

    // 递归
    public int[] sortArray_(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                temp[index++] = nums[i++];
            }
        }
        if (j <= right) {
            while (j <= right) {
                temp[index++] = nums[j++];
            }
        }
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }

    //迭代
    public int[] sortArray(int[] nums) {
        int k  = 1;
        int len = nums.length;
        while (k < len) {
            mergePass(nums, k, len);
            k *= 2;
        }
        return nums;
    }
    public void mergePass(int[] nums, int k, int len) {
        int i;
        for (i = 0; i < len - 2 * k; i += 2 * k) {
            merge(nums, i, i + k - 1, i + 2 * k - 1);
        }
        if (i + k < len) {
            merge(nums, i ,i + k - 1, len - 1);
        }
    }

}
