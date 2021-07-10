package com.personal;

import java.util.Arrays;

/**
 * 最小的k个数
 * @author liuxiaohan1
 * @date 2021-07-06 2:04 下午
 */
public class jz40HeapSort {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int mid = k / 2 - 1;
        if (mid < 0) {
            mid = 0;
        }
        // 建k个元素的大根堆
        for (int i = mid; i >= 0 ; i--) {
            adjust(arr, i, k);
        }

        System.out.println(Arrays.toString(arr));
        // 根和尾部交换，重新建堆
        for (int i = arr.length - 1; i >= k; i--) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                adjust(arr, 0, k);
                System.out.println(Arrays.toString(arr));
            }
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public void adjust(int[] arr, int index, int len) {
        while (2 * index + 1 < len) {
            int l = 2 * index + 1;
            int r = 2 * index + 2;
            int maxIndex = index;
            if (l < len && arr[l] > arr[maxIndex]) {
                maxIndex = l;
            }
            if (r < len && arr[r] > arr[maxIndex]) {
                maxIndex = r;
            }
            if (maxIndex != index) {
                swap(arr, index, maxIndex);
                index = maxIndex;
            } else {
                break;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,2,4,4,1,3,3,2};
        int k  = 6;
        jz40HeapSort jz40HeapSort = new jz40HeapSort();
        jz40HeapSort.getLeastNumbers(arr, k);
    }

}
