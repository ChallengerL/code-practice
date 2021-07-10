package com.personal;

/**
 * 数组中的逆序对
 * @author liuxiaohan1
 * @date 2021-07-06 4:20 下午
 */
public class jz51 {
    int res = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1);
        return res;
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
            } else { // 左子数组当前元素 > 右子数组当前元素 时，
                // 意味着 「左子数组当前元素 至 末尾元素」 与 「右子数组当前元素」 构成了若干 「逆序对」 。
                res += mid - i + 1;
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
        for (int k = 0; k < temp.length; k++) {
            nums[k + left] = temp[k];
        }

    }

}
