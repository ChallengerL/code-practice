package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-07-04 6:05 下午
 */
public class lc912HeapSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 先建大根堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(nums, i, len);
        }
        // 根和尾部交换，逐步移出当前最大元素，重新建堆
        for (int i = len - 1; i >= 1; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
        return nums;
    }

    public void adjust(int[] nums, int index, int len) {
        while (2 * index + 1 < len) {
            // 两个子节点
            int l = 2 * index + 1;
            int r = 2 * index + 2;
            int maxIndex = index;
            if (l < len && nums[l] > nums[maxIndex]) {
                maxIndex = l;
            }
            if (r < len && nums[r] > nums[maxIndex]) {
                maxIndex = r;
            }
            if (maxIndex != index) {
                swap(nums, index, maxIndex);
                index = maxIndex;
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
