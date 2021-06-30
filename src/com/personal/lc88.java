package com.personal;

/**
 * 合并两个有序数组
 * @author liuxiaohan1
 * @date 2021-06-30 3:56 下午
 */
public class lc88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] > nums2[n]) {
                int temp = nums1[m];
                nums1[i] = temp;
                nums1[m] = nums1[i];
                i--;
                m--;
            }
            nums1[i] = nums2[n];
            i--;
            n--;
        }
    }
}
